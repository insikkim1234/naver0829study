package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	//(10)MemberController�� @GetMapping("/member/form")���� �� member/memberform��ȯ
	@GetMapping("/member/form")
	public String login()
	{
		return "member/memberform";
	}
}
