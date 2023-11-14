package study.spring.day1113;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataReadController {
	
	@GetMapping("/process1")
	//request나 모델 아무거나 받겠다는 뜻
	//spring처럼 읽기
	//@RequestParam("폼태그의 name") String 변수명:폼태그의 name과 변수명이 같을 경우 name은 생략가능
	//@RequestParam 자체가 사실 생략은 가능하다(하지만 다른 어노테이션으로 읽는것을 방지하기 위해 안하는게 좋긴함)
	public String process1(Model model,
			@RequestParam("name") String irum,@RequestParam String addr, @RequestParam int age )
	{
		model.addAttribute("name", irum);
		model.addAttribute("addr", addr);
		model.addAttribute("age", age+"세는 "+(age>20?"성인":"미자")+"입니다");
		return "result1";
	}
//	public String process1(HttpServletRequest request,Model model)
//	{
//		//jsp처럼 읽어보자(스프링에서는 이렇게 읽지는 않음)
//		String name=request.getParameter("name");
//		String addr=request.getParameter("addr");
//		int age=Integer.parseInt(request.getParameter("age"));
//		
//		model.addAttribute("name", name);
//		model.addAttribute("addr", addr);
//		model.addAttribute("age", age+"세는 "+(age>=20?"성인":"미자")+" 입니다");
//		
//		
//		return "result1";
//	}
	
	@PostMapping("/process2")
	public String process2(Model model,@RequestParam String message,
			@RequestParam String animal,
			@RequestParam(defaultValue = "다니엘", required=false) String name
			/*null일 경우 기본값을 다니엘로 하겠다 required false옵션 이용해서 null
			 * 값이 들어오더라도 에러가 안나게 하겠다400*/)
	
		//formtag에 name이라는 태그는 없음
	{
		System.out.println(name);
		model.addAttribute("name", name);
		model.addAttribute("message", message);
		model.addAttribute("animal", animal);
		return "result2";
	}
	
	//@ModelAttribute: dto와 같은 이름의 폼태그를 읽어서 모델에 저장한다(사실 이거 없어도 되긴 한다)
	@PostMapping("/process3")
	public String process3(@ModelAttribute ShopDto dto,@RequestParam String today,
							Model model) 
	//model에 shopDto라는 이름으로 저장
	//public String process3(@ModelAttribute("dto") ShopDto dto)
	//model에 dto라는 이름으로 저장
	{
		model.addAttribute("today",today);
		return "result3";
	}
	
	
	@PostMapping("/process4")
	public String process4(Model model,@RequestParam Map<String,String> map)
	//폼태그의 name이 key로 입력값이 value로 저장
	{
		model.addAttribute("sang", map.get("sang"));
		model.addAttribute("su", map.get("su"));
		model.addAttribute("dan", map.get("dan"));
		model.addAttribute("color", map.get("color"));
		model.addAttribute("photo", map.get("photo"));
		model.addAttribute("today", map.get("today"));
		
		return "result4";
	}

}



















