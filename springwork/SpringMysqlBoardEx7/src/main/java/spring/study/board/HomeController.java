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

//(3)HomeController.java���� "/"�� Ȩ���� �����̷�Ʈ �Ǹ� �ٷ� list.jsp�� �̵��ϵ��� �Ѵ�(�⺻��ġ�� list.jsp)
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:./simple/list";
	}
	
}
