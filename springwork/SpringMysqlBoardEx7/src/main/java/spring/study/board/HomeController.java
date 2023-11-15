package spring.study.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//(3)HomeController.java에서 "/"인 홈에서 리다이렉트 되면 바로 list.jsp로 이동하도록 한다(기본위치가 list.jsp)
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:./simple/list";
	}
	
}
