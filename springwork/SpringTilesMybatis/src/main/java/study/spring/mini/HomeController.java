package study.spring.mini;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	//(5)HomeController.java��  @GetMapping("/")���� �� layout/home���� �̵��ǵ��� ��
	@GetMapping("/")
	public String home()
	{
		return "layout/home";
	}
	//(12)Homecontroller.java�� @GetMapping("/map") �� �����ϰ� layout/map ��ȯ
	@GetMapping("/map")
	public String map()
	{
		return "layout/map";
	}
	
	
}
