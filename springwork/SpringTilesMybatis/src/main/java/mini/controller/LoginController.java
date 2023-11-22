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
	
	//(7)LoginController에 @GetMapping("/login/main")매핑 후 login/loginmain반환
	@GetMapping("/login/main")
	public String login()
	{
		return "login/loginmain";
	}
	//(61)Logincontroller 에 @GetMapping("/login/process")매핑 후 작성
	@GetMapping("/login/process")
		//1)인자로 saveid,myid,pass,session받음
	@ResponseBody Map<String, Object> login(@RequestParam boolean saveid,
			@RequestParam String myid,
			@RequestParam String pass,
			HttpSession session)
	{
		//2)saveid에 아이디 저장 여부 저장
		System.out.println("saveid:"+saveid);
		//3)Map 방식으로 map생성
		Map<String, Object> map=new HashMap<String, Object>();
		
		//4)아이디와 pw입력 받고 로그인 성공여부(로그인 메시지를 출력했을때 트루면 )를 bLogin변수에 저장
		boolean bLogin=memberDao.isLoginCheck(myid, pass);
		//5)bLogin이 true이면
		if(bLogin)
		{
			//1.세션 유지시간(60*60*6동안 유지)
			session.setMaxInactiveInterval(60*60*6);
			//2.로그인 성공시 세션에 loginok:yes,saveid:체크했으면 yes아니면 no,myid:입력한 아이디 저장
			session.setAttribute("loginok", "yes");
			session.setAttribute("saveid", saveid?"yes":"no");
			session.setAttribute("myid", myid);
			
			//3.해당 아이디에 해당하는 이름 컬럼 얻고 세션에 키:값 형태로 저장
			String myname=memberDao.getData(myid).getName();
			session.setAttribute("myname", myname);
			//4.해당 아이디에 해당하는 사진컬럼을 얻기 세션에 키:값 형태로 저장
			String myphoto=memberDao.getData(myid).getPhoto();
			session.setAttribute("myphoto", myphoto);
			//5.map에 로그인 성공시success 에 true저장
			map.put("success", true);
		}
		//6)bLogin이 false이면 로그인이 실패한 것이므로 success에 false저장
		else {
			map.put("success", false);//로그인 실패시
		}
		//7)마지막으로 map반환
		return map;
	}
	//(63)LoginController.java에 @GetMapping("/login/logout")매핑 한 후 작성
	@GetMapping("/login/logout")
		//1)입력값으로 session입력 받음
	@ResponseBody public void logout(HttpSession session)
	{
		//2)loginok에서 로그아웃 누르면 해당 어트리부트 제거
		session.removeAttribute("loginok");
	}
	
	//(64)LoginController.java에 @PostMapping("/login/photochange")매핑 후 작성
	@PostMapping("/login/photochange")
		//1)upload,session,request인자로 입력받음
	@ResponseBody Map<String, String> photoChange(@RequestParam MultipartFile upload,
			HttpSession session,HttpServletRequest request)
	{
		//2)현재 로그읜한 아이디 얻기
		String myid=(String)session.getAttribute("myid");
		//3)사진을 업로드할 경로얻기
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		//4)사진파일명을 숨기기 위해 랜덤파일명 얻기
		String fileName=UUID.randomUUID().toString();
		//5)사진을 (path+"/"+fileName)에 업로드
		try {
			upload.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//6)db수정
		memberDao.updatePhoto(fileName, myid);
		
		//7)session에서도 사진 변경myPhoto에 fileName저장
		session.setAttribute("myPhoto", fileName);
		//8)map생성후 put으로 파일이름 넣기
		Map<String, String> map=new HashMap<String, String>();
		map.put("fileName", fileName);
		//9)map반환
		return map;
	}
}
