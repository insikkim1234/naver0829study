package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.AnswerDao;
import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;
//(12)BoardListController.java���� �⺻ ����,list(Model model) ����
//*�⺻ ����*
//@Controller: ��Ʈ�ѷ� �Һ� ����
@Controller

public class BoardListController {
	//@Autowired : BoardDao�� autowired �Һ�(�ڵ����� ���Եǵ��� ��)�� ����Ͽ� boardDao�ҷ�����
	@Autowired
	private BoardDao boardDao;
	//(22) ����� �ޱ� ���� answerDao ���̱�
	@Autowired
	private AnswerDao answerDao;
	
	//1)list(Model model) ����
		//1.BoardListController.java���� "/simple/list"�� �����ϸ� �Է°����� ���� �Է¹���
	@GetMapping("/simple/list")
	public String list(Model model)
	{
		//2.��ü ������ ���ͼ� totalCount�� ����, ��ü ����Ÿ�� List�������� �����ͼ� list������������
		int totalCount=boardDao.getTotalCount();
		List<BoardDto> list=boardDao.getAllDatas();
		
		//(23)BoardListController���� list�� acount �� �� �ۿ� ���� ��� ���� �����ϱ�
		for(BoardDto dto:list)
		{
			dto.setAcount(answerDao.getAnswers(dto.getNum()).size());
		}
		
		//3.totalCount,list�� model�� ����
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		
		//4.list.jsp ��ȯ
		return "list";
	}
	
	
}
