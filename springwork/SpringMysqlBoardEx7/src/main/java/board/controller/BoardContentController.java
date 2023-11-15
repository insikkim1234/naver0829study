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
//(14)BoardContentController.java�� �⺻����,content(),delete()
//,updateForm(),update(),addAnswer()����

//*�⺻����*
//��Ʈ�ѷ� �Һ�,��� ���ڸ� ���� ������
@Controller
@AllArgsConstructor
public class BoardContentController {
	//dao ����
	private BoardDao boardDao;
	private AnswerDao answerDao;
	
	//1)content()����
			//1.BoardContentController���� /simple/content�� �����ϸ� �Է°����� ��,num�� �Է¹���
	@GetMapping("/simple/content")
	
	public String  content(Model model,@RequestParam int num)
	{
		//2.��ȸ�� ����
		boardDao.updateReadcount(num);
		//3.dto���
		BoardDto dto=boardDao.getData(num);
		
		//4.�ش� �ۿ� ���� ��� ��������
		//��۵��� ��� ���� ����Ʈ ����
		List<AnswerDto> alist=answerDao.getAnswers(num);
		//model�� ����
		model.addAttribute("dto", dto);
		model.addAttribute("alist", alist);
		model.addAttribute("acount", alist.size());//��� ����
		//5.content�� ������
		return "content";
	}
	
	//2)delete()����
		//1.BoardContentController���� /simple/delete�� �����ϸ� �Է°����� num�� �б�
	@GetMapping("/simple/delete")
	public String delete(@RequestParam int num)
	{
		//2.����
		boardDao.deleteBoard(num);
		//3.����Ʈ ��ȯ
		return "redirect:./list";
	}
	
	
	//3)updateForm()����
			//1.BoardContentController���� /simple/updateform�� �����ϸ� �Է°����� num,model �б�
	@GetMapping("/simple/updateform")
	//dto�� �о�� �ϹǷ� �� �ʿ�
	//��� ������Ʈ �Ұ��� ���� num�ʿ�
	public String updateForm(Model model,@RequestParam int num)
	{
		//2.num�� �ش��ϴ� dto���
		BoardDto dto=boardDao.getData(num);
		//3.dto�� model�� ����
		model.addAttribute("dto", dto);
		//4.updateform��ȯ
		return "updateform";
	}
	
	//4)update()����
			//1.BoardContentController���� /simple/updateprocess�� �����ϸ� �Է°�����
			//dto,upload,request �б�
	@PostMapping("/simple/updateprocess")
	public String update(@ModelAttribute BoardDto dto,
				@RequestParam MultipartFile upload,
				HttpServletRequest request)
	{
			//2.������ ���ε��� ��Ĺ�� ������ ������Ʈ���� ����� ��ġ ���ϱ�
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/upload");
		
		//3.������ �������� ���� ��� photo�� null���� ������ ������ ������ ��� �������ϸ��� photo�� ����
		String photo="";
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto(null);
		else {
			
			photo =UUID.randomUUID().toString();
			dto.setPhoto(photo);
		}
		
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
		
		
		//5.db����
		boardDao.updateBoard(dto);
		
		
		//6.��ȯ
		return "redirect:./content?num="+dto.getNum();
	}
	
	//5)addAnswer()����
		//1.BoardContentController���� /simple/addanswer�� �����ϸ� �Է°����� dto �б�
	@PostMapping("/simple/addanswer")
	public String addAnswer(@ModelAttribute AnswerDto dto)
	{
		//2.��� �߰�
		answerDao.insertAnswer(dto);
		
		//3.��ȯ
		return "redirect:./content?num="+dto.getNum();
	}
	
}































