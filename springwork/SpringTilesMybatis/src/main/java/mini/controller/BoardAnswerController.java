package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.BoardAnswerDto;
import mini.service.BoardAnswerService;

//(131)BoardAnswerController.java에 기본 세팅
@RestController
public class BoardAnswerController {
	@Autowired
	private BoardAnswerService answerService;
	
	private String fileName;//댓글에서 업로드되는 사진 파일명
//(133)BoardAnswerController.java에 @PostMapping("/answer/upload") 을 매핑하여
//	댓글에서 업로드되는 사진의 파일명을 받아서 map방식으로 만든 후 반환해줌	
	@PostMapping("/answer/upload")
	//1)인자로 request,upload받기
	public Map<String, String> photoUpload(HttpServletRequest request,
			@RequestParam("upload") MultipartFile upload)
	{
	//2)파일명 받기	
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
	//3)랜덤파일명
		fileName=UUID.randomUUID().toString();
	//4)(path+"/"+fileName)경로로 업로드
		try {
			upload.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//5)map생성	
		Map<String, String> map=new HashMap<String, String>();
	//6)map에 앞에서 만든 fileName저장	
		map.put("photoname", fileName);
	//7)map반환	
		return map;
	}

//(138)boardAnswerController.java에 @PostMapping("/answer/insert")을 매핑 후 작성	
	@PostMapping("/answer/insert")
	//1)인자로 num,msg,session 받고 실행
	public void insertAnswer(@RequestParam int num,
			@RequestParam String msg,
			HttpSession session)
	{
	//2)로그인한 정보(myname,myid)받아 변수에 저장
		String myname=(String)session.getAttribute("myname");
		String myid=(String)session.getAttribute("myid");
	//3)dto생성 후 튜플 저장	
		BoardAnswerDto dto=new BoardAnswerDto();
		dto.setNum(num);
		dto.setAnsname(myname);
		dto.setAnsid(myid);
		dto.setAnsphoto(fileName);
		dto.setAnsmsg(msg);
		
	//4)db insert
		answerService.insertAnswer(dto);
		
	//5)사진 초기화
		fileName=null;
	}
//(139)boardAnswerController.java에 @GetMapping("/answer/list") 매핑 후 작성	
	@GetMapping("/answer/list")
	//1)인자로 해당 게시글의 num얻기
	public List<BoardAnswerDto> answerList(@RequestParam int num)
	{
	//2)num번째 게시글의 모든 댓글 얻기	
		return answerService.getAnswerBoard(num);
	}
///(144)boardanswercontroller.java에 @GetMapping("/answer/delete") 매핑 후 작성	
	@GetMapping("/answer/delete")
	//1)인자로 ansidx받음
	public void deleteAnswer(@RequestParam int ansidx)
	{
	//2)ansidx에 해당하는 댓글 삭제	
		answerService.deleteAnswer(ansidx);
	}
}
