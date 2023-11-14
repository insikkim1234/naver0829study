package study.spring.day1113;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//처음에 strart.jsp호출\
	@GetMapping("/")
	public String home()
	{
		return "start";
	}
	
	@GetMapping("/form1")
	public String form1()
	{
		return "form1";
	}
	
	@GetMapping("/form2")
	public String form2()
	{
		return "form2";
	}
	
	@GetMapping("/form3")
	public String form3()
	{
		return "form3";
	}
	
	@GetMapping("/form4")
	public String form4()
	{
		return "form4";
	}
	
}
