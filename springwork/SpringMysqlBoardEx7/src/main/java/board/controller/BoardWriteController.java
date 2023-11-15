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
//(6)BoardWriteController.java ����
	//1)��Ʈ�ѷ� �Һ� ����, ��� ���ڰ� �ִ� ������,/simple�� ����
@Controller
@RequestMapping("/simple")
@AllArgsConstructor
public class BoardWriteController {
	//2)BoardDao�� ���� �ۼ������� �ʾ����� �̸� �ҷ���
	private BoardDao boardDao;
	
	//3)���� /writeform�� ���εȴٸ� writeform���� ���ư���
	@GetMapping("/writeform")
	public String form()
	{
		return "writeform";
	}
	//(9)boardWriteController.java�� ����
			//1)writeform.jsp���� ���۹�ư ������ ���μ���(BoardWriteController�� ./addprocess)
	@PostMapping("/addprocess")
				//1.�Է°����� -request ����
				//		   -������ MultipartFile������� �޴´�
				//		   -�Է°����� BoardDto�� �ް� boardDto�� �޴´�
	public String add(HttpServletRequest request,
			@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload)
	{
		//2.������ ���ε��� ��Ĺ�� ������ ������Ʈ���� ����� ��ġ ���ϱ�
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/upload");
		System.out.println(path);
		
		//3.������ ���ε���� ���� ���� no��� ���� �ƴ� ��쿡�� ������ ���ϸ��� ��
		//photo�� ������ �� dto�� ����
		String photo=UUID.randomUUID().toString();
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto("no");//������ ���ε����� ���� ���� no��� ����
		else
			dto.setPhoto(photo);
		
		//4.�Է¹��� ������ (path+"/"+photo)�� ��ο� ���ε�
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5.dto�� dao���� ���� insert����(insertBoard)�� �̿��ؼ� ����
		boardDao.insertBoard(dto);
		
		//6.�ۼ��� ���� ����� �ִ� list.jpg�� ��ȯ
		return "redirect:./list";
	}
}
