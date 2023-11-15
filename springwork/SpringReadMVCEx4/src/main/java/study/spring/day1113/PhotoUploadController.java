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
		//������ ���ε��� Ž�Ͽ� ������ ������Ʈ�� ����� ��ġ�� ���Ѵ�
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		
		//���� ���ε��� ���ϸ�
		String filename=upload.getOriginalFilename();
		
		//���ε� �ش� ��ο� ��ȣģ ���� ������ ���ε� �Ұ���
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