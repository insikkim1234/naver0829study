package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	//(7)LoginController에 @GetMapping("/login/main")매핑 후 login/loginmain반환
	@GetMapping("/login/main")
	public String login()
	{
		return "login/loginmain";
	}
}
