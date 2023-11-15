package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.data.AnswerDao;
import board.data.AnswerDto;
import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;
//(14)BoardContentController.java에 기본세팅,content(),delete()
//,updateForm(),update(),addAnswer()생성

//*기본세팅*
//컨트롤러 롬복,모든 인자를 가진 생성자
@Controller
@AllArgsConstructor
public class BoardContentController {
	//dao 주입
	private BoardDao boardDao;
	private AnswerDao answerDao;
	
	//1)content()생성
			//1.BoardContentController에서 /simple/content을 매핑하면 입력값으로 모델,num을 입력받음
	@GetMapping("/simple/content")
	
	public String  content(Model model,@RequestParam int num)
	{
		//2.조회수 증가
		boardDao.updateReadcount(num);
		//3.dto얻기
		BoardDto dto=boardDao.getData(num);
		
		//4.해당 글에 대한 댓글 가져오기
		//댓글들을 담기 위한 리스트 생성
		List<AnswerDto> alist=answerDao.getAnswers(num);
		//model에 저장
		model.addAttribute("dto", dto);
		model.addAttribute("alist", alist);
		model.addAttribute("acount", alist.size());//댓글 갯수
		//5.content로 포워드
		return "content";
	}
	
	//2)delete()생성
		//1.BoardContentController에서 /simple/delete를 매핑하면 입력값으로 num을 읽기
	@GetMapping("/simple/delete")
	public String delete(@RequestParam int num)
	{
		//2.삭제
		boardDao.deleteBoard(num);
		//3.리스트 반환
		return "redirect:./list";
	}
	
	
	//3)updateForm()생성
			//1.BoardContentController에서 /simple/updateform를 매핑하면 입력값으로 num,model 읽기
	@GetMapping("/simple/updateform")
	//dto를 읽어야 하므로 모델 필요
	//몇번 업데이트 할건지 묻는 num필요
	public String updateForm(Model model,@RequestParam int num)
	{
		//2.num에 해당하는 dto얻기
		BoardDto dto=boardDao.getData(num);
		//3.dto를 model에 저장
		model.addAttribute("dto", dto);
		//4.updateform반환
		return "updateform";
	}
	
	//4)update()생성
			//1.BoardContentController에서 /simple/updateprocess를 매핑하면 입력값으로
			//dto,upload,request 읽기
	@PostMapping("/simple/updateprocess")
	public String update(@ModelAttribute BoardDto dto,
				@RequestParam MultipartFile upload,
				HttpServletRequest request)
	{
			//2.사진을 업로드할 톰캣에 배포된 프로젝트내의 경로의 위치 구하기
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/upload");
		
		//3.사진을 선택하지 않은 경우 photo에 null값을 보내고 사진을 선택한 경우 랜덤파일명을 photo에 저장
		String photo="";
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto(null);
		else {
			
			photo =UUID.randomUUID().toString();
			dto.setPhoto(photo);
		}
		
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
		
		
		//5.db수정
		boardDao.updateBoard(dto);
		
		
		//6.반환
		return "redirect:./content?num="+dto.getNum();
	}
	
	//5)addAnswer()생성
		//1.BoardContentController에서 /simple/addanswer를 매핑하면 입력값으로 dto 읽기
	@PostMapping("/simple/addanswer")
	public String addAnswer(@ModelAttribute AnswerDto dto)
	{
		//2.댓글 추가
		answerDao.insertAnswer(dto);
		
		//3.반환
		return "redirect:./content?num="+dto.getNum();
	}
	
}































