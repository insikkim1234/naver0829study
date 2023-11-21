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

/*(17)MemberController.java���� 
*�⺻ ����*
1)@Controller���� ����Ͻ� ������ �ִ� ���񽺸� ȣ���ϴ� ������ ���
*/
@Controller
//2)@RequiredArgsConstructor���� �ʱ�ȭ���� ���� final �ʵ峪 @NonNull�̺��� �ʵ忡 ���� ������ ���� 
@RequiredArgsConstructor
public class MemberController {
//3)@NonNull null�� ���ö� NullPointerException��ȯ���ִ� �Һ�	
	@NonNull
//4)MemberDao�� MemberController.java ���� �ҷ��� �� �ְ� ���ش�	
	private MemberDao memberDao;
	
	
	//(10)MemberController�� @GetMapping("/member/form")���� �� member/memberform��ȯ
	@GetMapping("/member/form")
	public String login()
	{
		return "member/memberform";
	}
	//(18)MemberController.java���� @GetMapping("/member/list") ���� ��
	//�� �Է¹ޱ�
	@GetMapping("/member/list")
	public String memberList(Model model)
	{
		//1)totalCount������ �� ����� ���
		int totalCount=memberDao.getTotalCount();
		//2)�Է��ߴ� �𵨿� totalCount ��Ʈ����Ʈ�� �߰��ϱ�
		model.addAttribute("totalCount", totalCount);
		//3)member���� �ؿ� memberlist.jsp��ȯ
		return "member/memberlist";
	}
	//(32)MemberController�� @PostMapping("/member/addmember")�� �����ϰ� 
	//dto�� �ִ� ���� �ۼ�
	@PostMapping("/member/addmember")
		//1)���ڷ� request, dto,upload�ޱ�
	public String addMember(HttpServletRequest request,
			@ModelAttribute MemberDto dto,
			@RequestParam MultipartFile upload)
	{
		//2)dto���
		System.out.println(dto);
		//3)���ε��� ���� ��� ���ϰ� path���
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		
		//4)������ ���ε��� ��� �������ϸ��� photo�� ���� ���Ѱ�� no��� ����
			//1. photo�� null�� �ʱ�ȭ
		String photo=null;
			//2.������ ���ε����� ���� ���(���ϳ����� ����) photo������ no ����
		if(upload.getOriginalFilename().equals(""))
			photo="no";
			//3.������ ���ε�� ��� photo ������ ���ϸ��� �����Ͽ� ����
		else {
			photo=UUID.randomUUID().toString();
			//4.(path+"/"+photo)��ο� ���� ���ε��ϱ�
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
		//5)dto�� photo�ֱ�
		dto.setPhoto(photo);
		//6)db�� insert
		memberDao.insertMember(dto);
		//7)������ /member/list��ȯ
		return "redirect:./list";
	}
	//(36)MemberController.java�� @GetMapping("/member/idcheck")�� ���� �� �ۼ�
	@GetMapping("/member/idcheck")
		//1)���ڷ� myid�� �޴´�
	@ResponseBody public Map<String, Integer> getIdCount(@RequestParam String myid)
	{
		//2)count������ dao�� searchIdCount �Լ��� myid ���� ���� ����
		int count=memberDao.searchIdCount(myid);
		//3)map���� ����
		Map<String , Integer> map=new HashMap<String, Integer>();
		//4)map�� count�ֱ�
		map.put("count", count);
		//5)map ��ȯ
		return map;
	}
	
	//(38)MemberController�� @GetMapping("/member/search") ���� ����
	@GetMapping("/member/search")
		//1)���ڷ� field,word����
	@ResponseBody List<MemberDto> getSearchList(@RequestParam String field,
			@RequestParam String word)
	{
		//2)�ش� ������ �� field���� Ʃ���� ��ȯ
		return memberDao.getSearchMember(field, word);
	}
//	(39)postman�� get ������� http://localhost:8080/mini/member/search�� �Է� �� 
//		������ field,word�� ���� key������ �ϰ� value���� ���� �Է��� ���ϴ� ������ ������ �Է��ϸ� 
//		json���·� �ش� Ű�� ���� ��ġ�ϴ� Ʃ�õ��� ���̽� ���·� ���
//	
	
	
//	/(44)MemberController.java�� @GetMapping("/member/delete")�� �����ϰ�
	//dao�� �����ϴ� �Լ� �ۼ�
	@GetMapping("/member/delete")
			//1)���ڷ� num���޹���
	@ResponseBody public void deleteMember(@RequestParam int num)
	{
			//2)�ش� num����
		memberDao.deleteMember(num);
	}
}
