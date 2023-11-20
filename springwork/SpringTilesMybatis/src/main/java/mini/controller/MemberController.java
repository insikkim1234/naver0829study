package mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	//(10)MemberController에 @GetMapping("/member/form")매핑 후 member/memberform반환
	@GetMapping("/member/form")
	public String login()
	{
		return "member/memberform";
	}
}
