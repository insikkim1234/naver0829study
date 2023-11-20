package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	//(8)BoardController에 @GetMapping("/board/list")매핑 후 board/boardlist반환
	@GetMapping("/board/list")
	public String login()
	{
		return "board/boardlist";
	}
}
