package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {
	//(9)GuestController�� @GetMapping("/guest/list")���� �� guest/guestlist��ȯ
	@GetMapping("/guest/list")
	public String login()
	{
		return "guest/guestlist";
	}
}
