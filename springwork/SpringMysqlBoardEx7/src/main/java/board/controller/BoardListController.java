package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;
//(12)BoardListController.java에서 기본 세팅,list(Model model) 생성
//*기본 세팅*
//@Controller: 컨트롤러 롬복 생성
@Controller

public class BoardListController {
	//@Autowired : BoardDao에 autowired 롬복(자동으로 주입되도록 함)을 사용하여 boardDao불러오기
	@Autowired
	private BoardDao boardDao;
	
	//1)list(Model model) 생성
		//1.BoardListController.java에서 "/simple/list"를 매핑하면 입력값으로 모델을 입력받음
	@GetMapping("/simple/list")
	public String list(Model model)
	{
		//2.전체 갯수를 얻어와서 totalCount에 저장, 전체 데이타를 List형식으로 가져와서 list형식으로저장
		int totalCount=boardDao.getTotalCount();
		List<BoardDto> list=boardDao.getAllDatas();
		
		//3.totalCount,list를 model에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		
		//4.list.jsp 반환
		return "list";
	}
}
