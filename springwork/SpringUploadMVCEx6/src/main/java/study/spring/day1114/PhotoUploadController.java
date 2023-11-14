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
	//(6)uploadform1.jsp���� ���۹�ư ������ ���μ���(PhotoUploadController�� /member/upload1)
	//1)�Է°����� MemberDto �� mdto�� �޴´�(����("mdto")�� ������ memberDto�� ���� ����)
	//2)������ MultipartFile������� �޴´�
	//3)request����
	@PostMapping("/member/upload1")
	public String upload1(@ModelAttribute("mdto") MemberDto dto,
			@RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		//(7) ������ ���ε��� ��Ĺ�� ������ ������Ʈ���� ����� ��ġ ���ϱ�
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		//(8)���ϸ��� dto�� ����(���ϸ��� ���̸� �ȵǹǷ� �����ϰ� ����)
		String photo=UUID.randomUUID().toString();
		dto.setPhoto(photo);
		
		//(9)�ش� ��ο� (path+"/"+photo)�� ���ε� �Ұ���
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//(10)member/result1��ȯ
		return "member/result1";
	}
	
	
	//(13)uploadform2.jsp���� ���۹�ư ������ ���μ���(PhotoUploadController�� /member/upload2)
		//1)�Է°����� MemberDto �� mdto�� �޴´�(����("mdto")�� ������ memberDto�� ���� ����)
		//2)������ ArrayList������� �޴´�
		//3)request����
	@PostMapping("/member/upload2")
	public String upload2(@ModelAttribute("mdto") MemberDto dto,
			HttpServletRequest request,
			@RequestParam ArrayList<MultipartFile> upload)
	{
		//(14) ������ ���ε��� ��Ĺ�� ������ ������Ʈ���� ����� ��ġ ���ϱ�
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/photo");
		
		//(15)���ϸ��� ������  ��������
		String photo="";
		
		//(16)�������� ������ ���ε��ؾ� �ϹǷ� �ݺ����� ������
		for(MultipartFile m:upload)
		{
			//(17)������ ���ϸ��� ��´�
			String fname=UUID.randomUUID().toString();
			photo+=fname+",";
			
			//(18)(path+"/"+fname) ��η� ���ε�
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
		
		//(19)������ �ĸ� ����(������ �ѱ��� ���� ���)�Ͽ� ������ photo ���� ��´�
		photo=photo.substring(0, photo.length()-1);
		
		//(20)dto�� �ֱ�
		dto.setPhoto(photo);
		
		//(21)member/result2��ȯ
		return "member/result2";
	}
	
	
	//(24)uploadform2.jsp���� ���۹�ư ������ ���μ���(PhotoUploadController�� /member/upload2)
		//1)�Է°����� MemberDto �� mdto�� �޴´�(����("mdto")�� ������ memberDto�� ���� ����)
		//2)������ MultipartFile������� �ΰ��� �޴´�
		//3)request����
	@PostMapping("/member/upload3")
	public String upload3(HttpServletRequest request,
				@ModelAttribute("mdto") MemberDto dto,
				@RequestParam MultipartFile upload,
				@RequestParam MultipartFile upload2)
	{
		//(25) ������ ���ε��� ��Ĺ�� ������ ������Ʈ���� ����� ��ġ ���ϱ�
		String path=request.getSession().getServletContext()
				.getRealPath("/WEB-INF/photo");
		
		//(26)���ϸ� dto�� ����
		String filename1=UUID.randomUUID().toString();
		String filename2=UUID.randomUUID().toString();
		
		dto.setPhoto(filename1);
		dto.setPhoto2(filename2);
		
		//(27)�� ���� ������ (path+"/"+filename1)(path+"/"+filename2)�� ���ε�
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
		
		//(28)member/result3��ȯ
		return "member/result3";
	}
}
















