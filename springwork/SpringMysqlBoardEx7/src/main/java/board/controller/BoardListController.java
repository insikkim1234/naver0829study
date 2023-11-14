package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.BoardDao;
import lombok.AllArgsConstructor;

@Controller
//@AllArgsConstructor
public class BoardListController {
	//(4)BoardListController.java���� BoardDao�� autowired �Һ��� ����Ͽ� boardDao����
	@Autowired
	private BoardDao boardDao;
	
	//(5)BoardListController.java���� "/simple/list"�� �����ϸ� �Է°����� ���� �Է¹���
	@GetMapping("/simple/list")
	public String list(Model model)
	{
		//(6)��ü ������ ���ͼ� totalCount�� ����
		int totalCount=boardDao.getTotalCount();
		
		//(7)totalCount�� model�� ����
		model.addAttribute("totalCount", totalCount);
		
		//(8)list.jsp ��ȯ
		return "list";
	}
}
