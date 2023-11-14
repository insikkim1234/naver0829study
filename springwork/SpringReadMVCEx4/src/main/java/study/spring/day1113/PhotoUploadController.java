package study.spring.day1113;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoUploadController {
	
	@GetMapping("/uploadform1")
	public String upload1()
	{
		return "uploadform1";
	}
	
	@GetMapping("/uploadform2")
	public String upload2()
	{
		return "uploadform2";
	}
	
	@PostMapping("/upload1")
	public String uploadgo1(Model model,@RequestParam String title,
			@RequestParam MultipartFile upload,HttpServletRequest request)
	{
		//사진을 업로드할 탐켓에 배포된 프로젝트내 경로의 위치를 구한다
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		
		//현재 업로드한 파일명
		String filename=upload.getOriginalFilename();
		
		//업로드 해당 경로에 괄호친 파일 명으로 업로드 할것임
		try {
			upload.transferTo(new File(path+"/"+filename));
			model.addAttribute("path",path);
			model.addAttribute("photo",filename);
			model.addAttribute("title",title);
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "uploadresult1";
	}
	
	@PostMapping("/upload2")
	public String uploadgo2()
	{
		return "uploadresult2";
	}
	
	
}
