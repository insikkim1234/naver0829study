package study.spring.day1116;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//(5)HomeController.java ���� Ȩ���� ����
@Controller
public class HomeController {
	@GetMapping("/")
	public String home()
	{
		return "home/start";
	}
}
