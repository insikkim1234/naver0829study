package study.spring.day1114;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;

@Controller
public class PhotoUploadController {
	//(6)uploadform1.jsp에서 전송버튼 누를때 프로세스(PhotoUploadController의 /member/upload1)
	//1)입력값으로 MemberDto 를 mdto로 받는다(원래("mdto")가 없으면 memberDto로 받을 것임)
	//2)파일을 MultipartFile방식으로 받는다
	//3)request받음
	@PostMapping("/member/upload1")
	public String upload1(@ModelAttribute("mdto") MemberDto dto,
			@RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		//(7) 사진을 업로드할 톰캣에 배포된 프로젝트내의 경로의 위치 구하기
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		//(8)파일명을 dto에 저장(파일명은 보이면 안되므로 랜덤하게 저장)
		String photo=UUID.randomUUID().toString();
		dto.setPhoto(photo);
		
		//(9)해당 경로에 (path+"/"+photo)로 업로드 할것임
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//(10)member/result1반환
		return "member/result1";
	}
	
	
	//(13)uploadform2.jsp에서 전송버튼 누를때 프로세스(PhotoUploadController의 /member/upload2)
		//1)입력값으로 MemberDto 를 mdto로 받는다(원래("mdto")가 없으면 memberDto로 받을 것임)
		//2)파일을 ArrayList방식으로 받는다
		//3)request받음
	@PostMapping("/member/upload2")
	public String upload2(@ModelAttribute("mdto") MemberDto dto,
			HttpServletRequest request,
			@RequestParam ArrayList<MultipartFile> upload)
	{
		//(14) 사진을 업로드할 톰캣에 배포된 프로젝트내의 경로의 위치 구하기
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/photo");
		
		//(15)파일명을 저장할  변수생성
		String photo="";
		
		//(16)여러장의 사진을 업로드해야 하므로 반복문을 돌린다
		for(MultipartFile m:upload)
		{
			//(17)임의의 파일명을 얻는다
			String fname=UUID.randomUUID().toString();
			photo+=fname+",";
			
			//(18)(path+"/"+fname) 경로로 업로드
			try {
				m.transferTo(new File(path+"/"+fname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//(19)마지막 컴마 제거(끝에서 한글자 빼고 출력)하여 온전한 photo 값을 얻는다
		photo=photo.substring(0, photo.length()-1);
		
		//(20)dto에 넣기
		dto.setPhoto(photo);
		
		//(21)member/result2반환
		return "member/result2";
	}
	
	
	//(24)uploadform2.jsp에서 전송버튼 누를때 프로세스(PhotoUploadController의 /member/upload2)
		//1)입력값으로 MemberDto 를 mdto로 받는다(원래("mdto")가 없으면 memberDto로 받을 것임)
		//2)파일을 MultipartFile방식으로 두개를 받는다
		//3)request받음
	@PostMapping("/member/upload3")
	public String upload3(HttpServletRequest request,
				@ModelAttribute("mdto") MemberDto dto,
				@RequestParam MultipartFile upload,
				@RequestParam MultipartFile upload2)
	{
		//(25) 사진을 업로드할 톰캣에 배포된 프로젝트내의 경로의 위치 구하기
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/photo");
		
		//(26)파일명 dto에 저장
		String filename1=UUID.randomUUID().toString();
		String filename2=UUID.randomUUID().toString();
		
		dto.setPhoto(filename1);
		dto.setPhoto2(filename2);
		
		//(27)두 장의 사진을 (path+"/"+filename1)(path+"/"+filename2)에 업로드
		try {
			upload.transferTo(new File(path+"/"+filename1));
			upload2.transferTo(new File(path+"/"+filename2));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//(28)member/result3반환
		return "member/result3";
	}
}
















