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

//(131)BoardAnswerController.java�� �⺻ ����
@RestController
public class BoardAnswerController {
	@Autowired
	private BoardAnswerService answerService;
	
	private String fileName;//��ۿ��� ���ε�Ǵ� ���� ���ϸ�
//(133)BoardAnswerController.java�� @PostMapping("/answer/upload") �� �����Ͽ�
//	��ۿ��� ���ε�Ǵ� ������ ���ϸ��� �޾Ƽ� map������� ���� �� ��ȯ����	
	@PostMapping("/answer/upload")
	//1)���ڷ� request,upload�ޱ�
	public Map<String, String> photoUpload(HttpServletRequest request,
			@RequestParam("upload") MultipartFile upload)
	{
	//2)���ϸ� �ޱ�	
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
	//3)�������ϸ�
		fileName=UUID.randomUUID().toString();
	//4)(path+"/"+fileName)��η� ���ε�
		try {
			upload.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//5)map����	
		Map<String, String> map=new HashMap<String, String>();
	//6)map�� �տ��� ���� fileName����	
		map.put("photoname", fileName);
	//7)map��ȯ	
		return map;
	}

//(138)boardAnswerController.java�� @PostMapping("/answer/insert")�� ���� �� �ۼ�	
	@PostMapping("/answer/insert")
	//1)���ڷ� num,msg,session �ް� ����
	public void insertAnswer(@RequestParam int num,
			@RequestParam String msg,
			HttpSession session)
	{
	//2)�α����� ����(myname,myid)�޾� ������ ����
		String myname=(String)session.getAttribute("myname");
		String myid=(String)session.getAttribute("myid");
	//3)dto���� �� Ʃ�� ����	
		BoardAnswerDto dto=new BoardAnswerDto();
		dto.setNum(num);
		dto.setAnsname(myname);
		dto.setAnsid(myid);
		dto.setAnsphoto(fileName);
		dto.setAnsmsg(msg);
		
	//4)db insert
		answerService.insertAnswer(dto);
		
	//5)���� �ʱ�ȭ
		fileName=null;
	}
//(139)boardAnswerController.java�� @GetMapping("/answer/list") ���� �� �ۼ�	
	@GetMapping("/answer/list")
	//1)���ڷ� �ش� �Խñ��� num���
	public List<BoardAnswerDto> answerList(@RequestParam int num)
	{
	//2)num��° �Խñ��� ��� ��� ���	
		return answerService.getAnswerBoard(num);
	}
///(144)boardanswercontroller.java�� @GetMapping("/answer/delete") ���� �� �ۼ�	
	@GetMapping("/answer/delete")
	//1)���ڷ� ansidx����
	public void deleteAnswer(@RequestParam int ansidx)
	{
	//2)ansidx�� �ش��ϴ� ��� ����	
		answerService.deleteAnswer(ansidx);
	}
}
