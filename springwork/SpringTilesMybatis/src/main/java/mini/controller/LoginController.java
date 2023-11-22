package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mini.dao.MemberDao;

@Controller
public class LoginController {
	@Autowired
	private MemberDao memberDao;
	
	//(7)LoginController�� @GetMapping("/login/main")���� �� login/loginmain��ȯ
	@GetMapping("/login/main")
	public String login()
	{
		return "login/loginmain";
	}
	//(61)Logincontroller �� @GetMapping("/login/process")���� �� �ۼ�
	@GetMapping("/login/process")
		//1)���ڷ� saveid,myid,pass,session����
	@ResponseBody Map<String, Object> login(@RequestParam boolean saveid,
			@RequestParam String myid,
			@RequestParam String pass,
			HttpSession session)
	{
		//2)saveid�� ���̵� ���� ���� ����
		System.out.println("saveid:"+saveid);
		//3)Map ������� map����
		Map<String, Object> map=new HashMap<String, Object>();
		
		//4)���̵�� pw�Է� �ް� �α��� ��������(�α��� �޽����� ��������� Ʈ��� )�� bLogin������ ����
		boolean bLogin=memberDao.isLoginCheck(myid, pass);
		//5)bLogin�� true�̸�
		if(bLogin)
		{
			//1.���� �����ð�(60*60*6���� ����)
			session.setMaxInactiveInterval(60*60*6);
			//2.�α��� ������ ���ǿ� loginok:yes,saveid:üũ������ yes�ƴϸ� no,myid:�Է��� ���̵� ����
			session.setAttribute("loginok", "yes");
			session.setAttribute("saveid", saveid?"yes":"no");
			session.setAttribute("myid", myid);
			
			//3.�ش� ���̵� �ش��ϴ� �̸� �÷� ��� ���ǿ� Ű:�� ���·� ����
			String myname=memberDao.getData(myid).getName();
			session.setAttribute("myname", myname);
			//4.�ش� ���̵� �ش��ϴ� �����÷��� ��� ���ǿ� Ű:�� ���·� ����
			String myphoto=memberDao.getData(myid).getPhoto();
			session.setAttribute("myphoto", myphoto);
			//5.map�� �α��� ������success �� true����
			map.put("success", true);
		}
		//6)bLogin�� false�̸� �α����� ������ ���̹Ƿ� success�� false����
		else {
			map.put("success", false);//�α��� ���н�
		}
		//7)���������� map��ȯ
		return map;
	}
	//(63)LoginController.java�� @GetMapping("/login/logout")���� �� �� �ۼ�
	@GetMapping("/login/logout")
		//1)�Է°����� session�Է� ����
	@ResponseBody public void logout(HttpSession session)
	{
		//2)loginok���� �α׾ƿ� ������ �ش� ��Ʈ����Ʈ ����
		session.removeAttribute("loginok");
	}
	
	//(64)LoginController.java�� @PostMapping("/login/photochange")���� �� �ۼ�
	@PostMapping("/login/photochange")
		//1)upload,session,request���ڷ� �Է¹���
	@ResponseBody Map<String, String> photoChange(@RequestParam MultipartFile upload,
			HttpSession session,HttpServletRequest request)
	{
		//2)���� �α����� ���̵� ���
		String myid=(String)session.getAttribute("myid");
		//3)������ ���ε��� ��ξ��
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		//4)�������ϸ��� ����� ���� �������ϸ� ���
		String fileName=UUID.randomUUID().toString();
		//5)������ (path+"/"+fileName)�� ���ε�
		try {
			upload.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//6)db����
		memberDao.updatePhoto(fileName, myid);
		
		//7)session������ ���� ����myPhoto�� fileName����
		session.setAttribute("myPhoto", fileName);
		//8)map������ put���� �����̸� �ֱ�
		Map<String, String> map=new HashMap<String, String>();
		map.put("fileName", fileName);
		//9)map��ȯ
		return map;
	}
}
