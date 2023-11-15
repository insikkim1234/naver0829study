package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;
//(6)BoardWriteController.java 수정
	//1)컨트롤러 롬복 생성, 모든 인자가 있는 생성자,/simple로 매핑
@Controller
@RequestMapping("/simple")
@AllArgsConstructor
public class BoardWriteController {
	//2)BoardDao를 아직 작성하지는 않았지만 미리 불러옴
	private BoardDao boardDao;
	
	//3)만약 /writeform이 매핑된다면 writeform으로 돌아간다
	@GetMapping("/writeform")
	public String form()
	{
		return "writeform";
	}
	//(9)boardWriteController.java의 수정
			//1)writeform.jsp에서 전송버튼 누를때 프로세스(BoardWriteController의 ./addprocess)
	@PostMapping("/addprocess")
				//1.입력값으로 -request 받음
				//		   -파일을 MultipartFile방식으로 받는다
				//		   -입력값으로 BoardDto를 받고 boardDto로 받는다
	public String add(HttpServletRequest request,
			@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload)
	{
		//2.사진을 업로드할 톰캣에 배포된 프로젝트내의 경로의 위치 구하기
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/upload");
		System.out.println(path);
		
		//3.사진이 업로드되지 않은 경우는 no라고 저장 아닌 경우에는 임의의 파일명을 얻어서
		//photo에 저장한 후 dto에 저장
		String photo=UUID.randomUUID().toString();
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto("no");//사진을 업로드하지 않은 경우는 no라고 저장
		else
			dto.setPhoto(photo);
		
		//4.입력받은 사진을 (path+"/"+photo)의 경로에 업로드
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5.dto를 dao에서 만든 insert구문(insertBoard)를 이용해서 삽입
		boardDao.insertBoard(dto);
		
		//6.작성된 글의 목록이 있는 list.jpg로 반환
		return "redirect:./list";
	}
}
