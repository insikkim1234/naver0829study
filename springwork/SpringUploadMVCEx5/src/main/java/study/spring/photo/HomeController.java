package study.spring.photo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//(1)homecontroller�� ����� @controller�Һ� �߰�
@Controller
public class HomeController {
	// (2)�������� ���� shopform.jsp����
	@GetMapping("/")
	public String form()
	{
		return "shopform";
	}
	
	//(4)shopform.jsp���� ���۹�ư ������ ���μ���(HomeController.java �� /addshop)
	//�Է°����� dto�ޱ�
	//request�ޱ�
	@PostMapping("/addshop")
	public String add(@ModelAttribute("dto") MyShopDto dto,
						HttpServletRequest request)
	{
		//(5)���������� ���ε��� ��Ĺ�� ������ ������Ʈ�� ����� ��ġ ���ϱ�
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/photo");
		//(6)����Ÿ�� ���ϱ�
		MultipartFile file=dto.getPhoto();
		//(7)dto�� ���ϸ� ����
		dto.setFilename(file.getOriginalFilename());
		
		//(8)(path+"/"+file.getOriginalFilename()��η� ���� ���ε�
		try {
			file.transferTo(new File(path+"/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//(9) shopresult��ȯ
		return "shopresult";
	}
	
	
}
