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
	
	//(30)MemoRestController에 @GetMapping("/memo/delete")을 매핑하여 인자로 num을 받아서
	//dao의 deleteMemo를 실행
	@GetMapping("/memo/delete")
	public void deleteMemo(@RequestParam int num)
	{
		memoDao.deleteMemo(num);
	}
	
//(36)memoRestController에 @GetMapping("/memo/likes")으로 매핑 하고
//	좋아요수 증가시켜주는 함수 작성
//1)/memo/likes로 매핑	
	@GetMapping("/memo/likes")
//2)인자로 지금 좋아요의 갯수인 num을 받는다	
	public Map<String, Integer> countLikes(@RequestParam int num)
	{
//3)좋아요수 1 증가시키는 쿼리(dao로 보내서 updateLikes()함수 실행)
		memoDao.updateLikes(num);
//4)증가된 좋아요수 얻어내는 함수
		int likes=memoDao.getCountLikes(num);
//5)map형태로 얻어내기 위한 틀 작성		추천수: likes
		Map<String,Integer> map=new HashMap<String, Integer>();
//6)likes에 좋아요수 매핑		
		map.put("likes", likes);
//7)map반환		
		return map;
	}
}






