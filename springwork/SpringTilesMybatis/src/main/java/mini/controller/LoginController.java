package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	//(7)LoginController�� @GetMapping("/login/main")���� �� login/loginmain��ȯ
	@GetMapping("/login/main")
	public String login()
	{
		return "login/loginmain";
	}
}
