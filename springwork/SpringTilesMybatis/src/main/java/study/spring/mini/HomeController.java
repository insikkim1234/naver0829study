package study.spring.mini;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	//(5)HomeController.java에  @GetMapping("/")매핑 후 layout/home으로 이동되도록 함
	@GetMapping("/")
	public String home()
	{
		return "layout/home";
	}
	//(12)Homecontroller.java에 @GetMapping("/map") 을 매핑하고 layout/map 반환
	@GetMapping("/map")
	public String map()
	{
		return "layout/map";
	}
	
	
}
