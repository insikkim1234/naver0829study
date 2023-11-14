package study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//(4)MemberController.java����
//1)��Ʈ�ѷ� �Һ� �߰�
@Controller
public class MemberController {
	//2)"/"���� ���� �� �� member/start.jsp�� �̵�
	@GetMapping("/")
	public String home()
	{
		return "member/start";
	}
	//3)"/member/form1"���� ���� �� �� member/uploadform1.jsp�� �̵�  (5)�� �̵�
	@GetMapping("/member/form1")
	public String form1()
	{
		return "member/uploadform1";
	}
	//4)"/member/form2"���� ���� �� �� member/uploadform2.jsp�� �̵�
	@GetMapping("/member/form2")
	public String form2()
	{
		return "member/uploadform2";
	}
	//5)"/member/form3"���� ���� �� �� member/uploadform3.jsp�� �̵�
	@GetMapping("/member/form3")
	public String form3()
	{
		return "member/uploadform3";
	}
}
