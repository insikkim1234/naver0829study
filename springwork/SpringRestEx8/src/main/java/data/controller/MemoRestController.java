package data.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

//(21)MemoRestController.java 에 
//*기본세팅*

@RestController
public class MemoRestController {
	@Autowired
	private MemoDao memoDao;
	
	//먼저 사진을 업로드 할건데 그때 저장할 파일명
	private String photo;
	
	//1)@PostMapping("/memo/upload")을 매핑하면fileUpload()반환하는 메서드
	//(파일 업로드시 호출되는 메서드)
	@PostMapping("/memo/upload")
			//	1.인자로 multipartfile,HttpServeletRequest받음
	public String fileUpload(@RequestParam("upload") MultipartFile upload,
			HttpServletRequest request)
	{
			//2.파일을 업로드할 위치
		String path=request.getSession().getServletContext()
				.getRealPath("/resources/upload");
		System.out.println(path);
		
		//3.랜덤 파일명으로 저장
		photo=UUID.randomUUID().toString();
		
		//4.path+"/"+photo에 업로드
		try {
			upload.transferTo(new File(path+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5.photo를 반환
		return photo;
	}
	//(22)MemoRestController에서 @GetMapping("/memo/add") 매핑후 memoAdd함수 작성후 반환
	@GetMapping("/memo/add")
			//1)인자로 nickname,memo받음
	public void memoAdd(@RequestParam String nickname,
			@RequestParam String memo)
	{
		//2)dto불러오기
		MemoDto dto=new MemoDto();
		//3)dto에 인자로 받은 닉네임,메모 , 사진추가하기
		dto.setNickname(nickname);
		dto.setMemo(memo);
		dto.setPhoto(photo);
		
		//4)db.insert
		memoDao.insertMemo(dto);
	}
	
	//(25)MemoRestController.java에서 메모 목록 json으로 반환 작성
	//1)MemoRestController에서 @GetMapping("/memo/view") 매핑
	@GetMapping("/memo/view")
	public List<MemoDto> getAllMemo()
	{
		//2)getAllMemos()반환
		return memoDao.getAllMemos();
	}
	//(26)postman의 getdata에서 get방식으로
	//http://localhost:8080/day1116/memo/view을 입력하면 데이터를 json형태로 볼 수 잇음
}






