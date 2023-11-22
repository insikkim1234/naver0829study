package data.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dao.MemoDao;
import data.dto.MemoDto;

//(21)MemoRestController.java �� 
//*�⺻����*

@RestController
public class MemoRestController {
	@Autowired
	private MemoDao memoDao;
	
	//���� ������ ���ε� �Ұǵ� �׶� ������ ���ϸ�
	private String photo;
	
	//1)@PostMapping("/memo/upload")�� �����ϸ�fileUpload()��ȯ�ϴ� �޼���
	//(���� ���ε�� ȣ��Ǵ� �޼���)
	@PostMapping("/memo/upload")
			//	1.���ڷ� multipartfile,HttpServeletRequest����
	public String fileUpload(@RequestParam("upload") MultipartFile upload,
			HttpServletRequest request)
	{
			//2.������ ���ε��� ��ġ
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		
		//3.���� ���ϸ����� ����
		photo=UUID.randomUUID().toString();
		
		//4.path+"/"+photo�� ���ε�
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5.photo�� ��ȯ
		return photo;
	}
	//(22)MemoRestController���� @GetMapping("/memo/add") ������ memoAdd�Լ� �ۼ��� ��ȯ
	@GetMapping("/memo/add")
			//1)���ڷ� nickname,memo����
	public void memoAdd(@RequestParam String nickname,
			@RequestParam String memo)
	{
		//2)dto�ҷ�����
		MemoDto dto=new MemoDto();
		//3)dto�� ���ڷ� ���� �г���,�޸� , �����߰��ϱ�
		dto.setNickname(nickname);
		dto.setMemo(memo);
		dto.setPhoto(photo);
		
		//4)db.insert
		memoDao.insertMemo(dto);
	}
	
	//(25)MemoRestController.java���� �޸� ��� json���� ��ȯ �ۼ�
	//1)MemoRestController���� @GetMapping("/memo/view") ����
	@GetMapping("/memo/view")
	public List<MemoDto> getAllMemo()
	{
		//2)getAllMemos()��ȯ
		return memoDao.getAllMemos();
	}
	//(26)postman�� getdata���� get�������
	//http://localhost:8080/day1116/memo/view�� �Է��ϸ� �����͸� json���·� �� �� ����
	
	//(30)MemoRestController�� @GetMapping("/memo/delete")�� �����Ͽ� ���ڷ� num�� �޾Ƽ�
	//dao�� deleteMemo�� ����
	@GetMapping("/memo/delete")
	public void deleteMemo(@RequestParam int num)
	{
		memoDao.deleteMemo(num);
	}
	
//(36)memoRestController�� @GetMapping("/memo/likes")���� ���� �ϰ�
//	���ƿ�� ���������ִ� �Լ� �ۼ�
//1)/memo/likes�� ����	
	@GetMapping("/memo/likes")
//2)���ڷ� ���� ���ƿ��� ������ num�� �޴´�	
	public Map<String, Integer> countLikes(@RequestParam int num)
	{
//3)���ƿ�� 1 ������Ű�� ����(dao�� ������ updateLikes()�Լ� ����)
		memoDao.updateLikes(num);
//4)������ ���ƿ�� ���� �Լ�
		int likes=memoDao.getCountLikes(num);
//5)map���·� ���� ���� Ʋ �ۼ�		��õ��: likes
		Map<String,Integer> map=new HashMap<String, Integer>();
//6)likes�� ���ƿ�� ����		
		map.put("likes", likes);
//7)map��ȯ		
		return map;
	}
}





