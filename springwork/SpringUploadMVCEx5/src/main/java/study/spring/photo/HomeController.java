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

//(1)homecontroller다 지우고 @controller롬복 추가
@Controller
public class HomeController {
	// (2)시작하자 마자 shopform.jsp리턴
	@GetMapping("/")
	public String form()
	{
		return "shopform";
	}
	
	//(4)shopform.jsp에서 전송버튼 누를때 프로세스(HomeController.java 의 /addshop)
	//입력값으로 dto받기
	//request받기
	@PostMapping("/addshop")
	public String add(@ModelAttribute("dto") MyShopDto dto,
						HttpServletRequest request)
	{
		//(5)사진파일을 업로드할 톰캣에 배포된 프로젝트내 경로의 위치 구하기
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/photo");
		//(6)파일타입 구하기
		MultipartFile file=dto.getPhoto();
		//(7)dto에 파일명 저장
		dto.setFilename(file.getOriginalFilename());
		
		//(8)(path+"/"+file.getOriginalFilename()경로로 파일 업로드
		try {
			file.transferTo(new File(path+"/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//(9) shopresult반환
		return "shopresult";
	}
	
	
}
