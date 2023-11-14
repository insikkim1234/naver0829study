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
	//(4)BoardListController.java에서 BoardDao에 autowired 롬복을 사용하여 boardDao생성
	@Autowired
	private BoardDao boardDao;
	
	//(5)BoardListController.java에서 "/simple/list"를 매핑하면 입력값으로 모델을 입력받음
	@GetMapping("/simple/list")
	public String list(Model model)
	{
		//(6)전체 갯수를 얻어와서 totalCount에 저장
		int totalCount=boardDao.getTotalCount();
		
		//(7)totalCount를 model에 저장
		model.addAttribute("totalCount", totalCount);
		
		//(8)list.jsp 반환
		return "list";
	}
}
