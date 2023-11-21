package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mini.dao.MemberDao;
import mini.dto.MemberDto;

/*(17)MemberController.java에서 
*기본 세팅*
1)@Controller으로 비즈니스 로직이 있는 서비스를 호출하는 역할을 담당
*/
@Controller
//2)@RequiredArgsConstructor으로 초기화되지 않은 final 필드나 @NonNull이붙은 필드에 대해 생성자 생성 
@RequiredArgsConstructor
public class MemberController {
//3)@NonNull null이 들어올때 NullPointerException반환해주는 롬복	
	@NonNull
//4)MemberDao를 MemberController.java 에서 불러올 수 있게 해준다	
	private MemberDao memberDao;
	
	
	//(10)MemberController에 @GetMapping("/member/form")매핑 후 member/memberform반환
	@GetMapping("/member/form")
	public String login()
	{
		return "member/memberform";
	}
	//(18)MemberController.java에서 @GetMapping("/member/list") 매핑 후
	//모델 입력받기
	@GetMapping("/member/list")
	public String memberList(Model model)
	{
		//1)totalCount변수에 총 멤버수 얻기
		int totalCount=memberDao.getTotalCount();
		//2)입력했던 모델에 totalCount 어트리뷰트를 추가하기
		model.addAttribute("totalCount", totalCount);
		//3)member폴더 밑에 memberlist.jsp반환
		return "member/memberlist";
	}
	//(32)MemberController에 @PostMapping("/member/addmember")을 매핑하고 
	//dto에 넣는 쿼리 작성
	@PostMapping("/member/addmember")
		//1)인자로 request, dto,upload받기
	public String addMember(HttpServletRequest request,
			@ModelAttribute MemberDto dto,
			@RequestParam MultipartFile upload)
	{
		//2)dto출력
		System.out.println(dto);
		//3)업로드할 실제 경로 구하고 path출력
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		
		//4)사진을 업로드한 경우 랜덤파일명을 photo에 저장 안한경우 no라고 저장
			//1. photo는 null로 초기화
		String photo=null;
			//2.사진을 업로드하지 않은 경우(파일네임이 없음) photo변수에 no 저장
		if(upload.getOriginalFilename().equals(""))
			photo="no";
			//3.사진이 업로드된 경우 photo 변수에 파일명을 변조하여 저장
		else {
			photo=UUID.randomUUID().toString();
			//4.(path+"/"+photo)경로에 실제 업로드하기
			try {
				upload.transferTo(new File(path+"/"+photo));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//5)dto에 photo넣기
		dto.setPhoto(photo);
		//6)db에 insert
		memberDao.insertMember(dto);
		//7)고쳐진 /member/list반환
		return "redirect:./list";
	}
	//(36)MemberController.java에 @GetMapping("/member/idcheck")을 매핑 후 작성
	@GetMapping("/member/idcheck")
		//1)인자로 myid를 받는다
	@ResponseBody public Map<String, Integer> getIdCount(@RequestParam String myid)
	{
		//2)count변수에 dao의 searchIdCount 함수에 myid 넣은 값을 저장
		int count=memberDao.searchIdCount(myid);
		//3)map형태 선언
		Map<String , Integer> map=new HashMap<String, Integer>();
		//4)map에 count넣기
		map.put("count", count);
		//5)map 반환
		return map;
	}
	
	//(38)MemberController에 @GetMapping("/member/search") 으로 매핑
	@GetMapping("/member/search")
		//1)인자로 field,word받음
	@ResponseBody List<MemberDto> getSearchList(@RequestParam String field,
			@RequestParam String word)
	{
		//2)해당 내용이 들어간 field에서 튜플을 반환
		return memberDao.getSearchMember(field, word);
	}
//	(39)postman에 get 방식으로 http://localhost:8080/mini/member/search을 입력 후 
//		인자인 field,word를 각각 key값으로 하고 value값은 내가 입력을 원하는 데베의 내용을 입력하면 
//		json형태로 해당 키의 값과 일치하는 튜플들이 제이슨 형태로 뜬다
//	
	
	
//	/(44)MemberController.java에 @GetMapping("/member/delete")을 매핑하고
	//dao에 전달하는 함수 작성
	@GetMapping("/member/delete")
			//1)인자로 num전달받음
	@ResponseBody public void deleteMember(@RequestParam int num)
	{
			//2)해당 num삭제
		memberDao.deleteMember(num);
	}
}
