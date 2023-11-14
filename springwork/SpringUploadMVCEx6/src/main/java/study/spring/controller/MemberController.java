package study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//(4)MemberController.java수정
//1)컨트롤러 롬복 추가
@Controller
public class MemberController {
	//2)"/"으로 매핑 할 시 member/start.jsp로 이동
	@GetMapping("/")
	public String home()
	{
		return "member/start";
	}
	//3)"/member/form1"으로 매핑 할 시 member/uploadform1.jsp로 이동  (5)로 이동
	@GetMapping("/member/form1")
	public String form1()
	{
		return "member/uploadform1";
	}
	//4)"/member/form2"으로 매핑 할 시 member/uploadform2.jsp로 이동
	@GetMapping("/member/form2")
	public String form2()
	{
		return "member/uploadform2";
	}
	//5)"/member/form3"으로 매핑 할 시 member/uploadform3.jsp로 이동
	@GetMapping("/member/form3")
	public String form3()
	{
		return "member/uploadform3";
	}
}
