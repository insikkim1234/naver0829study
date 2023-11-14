package study.spring.day1113;
//(29) study.spring.day1113밑에 PhotoUploadController.java생성하고 @Controller롬복 생성 

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class PhotoUploadCntroller {
	//(30) HomeController.java 에 이어 uploadform1,uploadform2를 출력해 주는 
	//함수 생성
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
	//(31)views에 uploadform1,uploadresult1 uploadform2,uploadresult2 생성
	
	
	//(33)uploadform1.jsp에서 전송버튼 누를때 프로세스(PhotoUploadController의 ./upload1) 
	//입력값으로 모델 받기
	//제목을 입력받으면 title로 받기
	//request 받기
	@PostMapping("/upload1")
	public String uploadgo1(Model model,@RequestParam String title,
			@RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		//(34) 사진을 업로드할 톰캣에 배포된 프로젝트내 경로의 위치를 구한다
		String path=request.getSession().getServletContext()
					.getRealPath("/resources/upload");
		System.out.println(path);
		
		//(35)현재 업로드한 파일명
		String filename=upload.getOriginalFilename();
		
		//(36)실제 파일명에서 확장자만 얻기(.의 위치이다)
		//만약 abc.jpg이면 .jpg만얻는다 
		int dotIdx=filename.lastIndexOf(".");
		String extName=filename.substring(dotIdx);
		
		//(37)실제 파일명이 아닌 랜덤파일명으로 저장하기
		String filename2=UUID.randomUUID().toString()+extName;
		
		//(38)업로드 해당 경로에 괄호친 파일 (path+"/"+filename2)명으로 업로드 할것임
		try {
		upload.transferTo(new File(path+"/"+filename2));
		model.addAttribute("path",path);
		model.addAttribute("photo",filename2);
		model.addAttribute("title",title);
		} catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//(39)uploadresult1반환
		return "uploadresult1";
	}
}












