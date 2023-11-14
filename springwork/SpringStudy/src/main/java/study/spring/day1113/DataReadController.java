package study.spring.day1113;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DataReadController {
	
	@GetMapping("/process1")
	public String process1(Model model,
			@RequestParam("name") String irum,
			@RequestParam String addr,
			@RequestParam int age)
	{
		
		model.addAttribute("irum", irum);
		model.addAttribute("addr", addr);
		model.addAttribute("age", age+"세는 "+(age>20?"성인":"미자")+"입니다");
		
		
		return "result1";
	}
	//(14)form2.jsp에서 전송버튼 누를때 프로세스
	@PostMapping("/process2")
	public String process1(Model model,
			//입력받은 메시지,동물사진 받기
			//name은 없으면(required=false) 다니엘로 하겠다(값이 안들어 왔을때 에러방지 목적)
			@RequestParam String message,
			@RequestParam String animal,
			@RequestParam(defaultValue="다니엘",required=false) String name)
	{
		//(15)message,animal,name 받고 각각 모델에 저장
		System.out.println(name);
		
		model.addAttribute("name", name);
		model.addAttribute("message", message);
		model.addAttribute("animal", animal);
		
		//(16)result2반환
		return "result2";
	}
	
	//(20)form3.jsp에서 전송버튼을 누를때 프로세스
	//입력값으로 모델 받기
	//ShopDto를 입력받으면 dto로 받기
	//오늘날짜를 입력받으면 today로 받기
	@PostMapping("/process3")
	public String process3(Model model,@ModelAttribute ShopDto dto,
			@RequestParam String today)
	{
		//(21)today를 모델에 저장(나머지값은 dto가 처리할거임)
		model.addAttribute("today", today);
		//(22) result3반환
		return "result3";
	}
	
	//(25)form4.jsp에서 전송버튼 누를때 프로세스
	//입력값으로 모델 받기
	//데이터 모음을 입력받으면 Map방식으로 map으로 받기  
	@PostMapping("/process4")
	public String process4(Model model,@RequestParam Map<String,String> map)
	{
		//(26) map에 상품,수,단가,색상,사진,오늘날짜를 키:값형태로 저장하기
		model.addAttribute("sang", map.get("sang"));
		model.addAttribute("su", map.get("su"));
		model.addAttribute("dan", map.get("dan"));
		model.addAttribute("color", map.get("color"));
		model.addAttribute("photo", map.get("photo"));
		model.addAttribute("today", map.get("today"));
		//(27)result4반환
		
		return "result4";
	}
	

}
