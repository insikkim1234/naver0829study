package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {
	//(9)GuestController에 @GetMapping("/guest/list")매핑 후 guest/guestlist반환
	@GetMapping("/guest/list")
	public String login()
	{
		return "guest/guestlist";
	}
}
