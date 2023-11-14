package study.spring.day1113;
//(29) study.spring.day1113�ؿ� PhotoUploadController.java�����ϰ� @Controller�Һ� ���� 

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
	//(30) HomeController.java �� �̾� uploadform1,uploadform2�� ����� �ִ� 
	//�Լ� ����
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
	//(31)views�� uploadform1,uploadresult1 uploadform2,uploadresult2 ����
	
	
	//(33)uploadform1.jsp���� ���۹�ư ������ ���μ���(PhotoUploadController�� ./upload1) 
	//�Է°����� �� �ޱ�
	//������ �Է¹����� title�� �ޱ�
	//request �ޱ�
	@PostMapping("/upload1")
	public String uploadgo1(Model model,@RequestParam String title,
			@RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		//(34) ������ ���ε��� ��Ĺ�� ������ ������Ʈ�� ����� ��ġ�� ���Ѵ�
		String path=request.getSession().getServletContext()
					.getRealPath("/resources/upload");
		System.out.println(path);
		
		//(35)���� ���ε��� ���ϸ�
		String filename=upload.getOriginalFilename();
		
		//(36)���� ���ϸ��� Ȯ���ڸ� ���(.�� ��ġ�̴�)
		//���� abc.jpg�̸� .jpg����´� 
		int dotIdx=filename.lastIndexOf(".");
		String extName=filename.substring(dotIdx);
		
		//(37)���� ���ϸ��� �ƴ� �������ϸ����� �����ϱ�
		String filename2=UUID.randomUUID().toString()+extName;
		
		//(38)���ε� �ش� ��ο� ��ȣģ ���� (path+"/"+filename2)������ ���ε� �Ұ���
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
		//(39)uploadresult1��ȯ
		return "uploadresult1";
	}
}












