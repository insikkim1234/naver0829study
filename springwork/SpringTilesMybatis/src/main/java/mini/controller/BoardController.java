package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	//(8)BoardController�� @GetMapping("/board/list")���� �� board/boardlist��ȯ
	@GetMapping("/board/list")
	public String login()
	{
		return "board/boardlist";
	}
}
