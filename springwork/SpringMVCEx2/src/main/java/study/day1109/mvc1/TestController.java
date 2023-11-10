package study.day1109.mvc1;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//(1)@Controller 이용해 자동으로 설정파일에 bean이 등록되도록 한다
@Controller 
public class TestController {
	
	//(2)@GetMapping 방식을 이용하여 오늘의 메시지,현재 시간 매핑 (스프링 버전5부터 가능한 어노테이션)
	//이때 home과 같은 것은 아무이름이나 써도 상관없음 
	@GetMapping("/") 
	public String home(Model model)
	{
		model.addAttribute("message","have a good time");//request에 저장
		model.addAttribute("today",new Date());
		return "result1";
	}
	
	//(3)매핑 경로를 직접 지정하는데 {}을 이용하여 path1로 넘어온 url값을 읽는다
	//이때 go와 같은 것은 아무 이름이나 써도 상관없음
	//@GetMapping("/shop/list.do") //  /shop/list.* 모두 호출가능
	//@GetMapping("/shop/list.do") //shop/list.do만 호출가능
	@GetMapping("/shop/{path1}")	
	public String go(Model model,@PathVariable("path1") String p1)
	{
		System.out.println(p1);
		model.addAttribute("path","/shop/"+p1);
		return "list";
	}
	
	
	//(4)두개의 매핑이 같은곳으로 포워딩되도록 한다
	//hello와 같은 것은 아무 이름이나 상관업음
	@GetMapping({"/board/update","/stu/form/test1"}) 
	public ModelAndView hello(HttpServletRequest request)
	{
		//(5)프로젝트 명까지의 경로를 얻는다
		String root=request.getContextPath();
		System.out.println(root);
		
		//(6)mview에 여러개의 정보를 저장하고 리턴
		ModelAndView mview=new ModelAndView();
		mview.addObject("message","매핑주소로 사진을 나타내보자");
		mview.addObject("root",root);
		mview.setViewName("result2");
		return mview;
	}
	//(7)servlet-context.xml의 
	/*
	 * <resources mapping="/res/**" location="/resources/" /> <resources
	 * mapping="/photo/**" location="/WEB-INF/photo/" />
	 */ 
	//수정하기
	//이후 (8)번은 list.jsp로 이동
}	

















