package data.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.dto.MemoDto;
import data.dto.MemoDto2;

//(8)RestTestController1에서 @GetMapping("/test/list1")작성
//@Controller
//public class RestTestController1 {
	
	//1)@GetMapping("/test/list1") 매핑
	//@GetMapping("/test/list1")
	//@ResponseBody public List<MemoDto2> list1()
	//{
		//2)튜플을 저장할 리스트 생성
		//List<MemoDto2> list=new ArrayList<MemoDto2>();
		//3)리스트에 튜플 추가
		//list.add(new MemoDto2(1,"캔디","1.jpg","안녕",5,"2023-10-10"));
		//list.add(new MemoDto2(2,"안소니","2.jpg","헬로",5,"2023-10-10"));
		//list.add(new MemoDto2(3,"테리우스","3.jpg","안녕",5,"2023-10-10"));
		//4)리스트 반환
		//return list;
	//}
	
//	(10)탐캣 실행 후 postman 접속 
//	1)collections 누르기 
//	2)+누르기
//	3)restapi검색후 추가
//	4) getdata 클릭 
//	5) Get선택, 주소입력http://(localhost:8080/day1116/test/list1)
//	6) send 누르면 json 데이터 나온다
//
//	[{1,"캔디","1.jpg","안녕",5,"2023-10-10"},
//	 {2,"안소니","2.jpg","헬로",5,"2023-10-10"},
//	{3,"테리우스","3.jpg","안녕",5,"2023-10-10"}]
	
	//(11)RestTestController1의@GetMapping("/test/add") 부분 작성
	//1)@GetMapping("/test/add") 주소 맵핑
	//@GetMapping("/test/add")
	//2)인자로 nickname,photo,memo 받기
	//@ResponseBody public MemoDto2 add(String nickname, String photo,String memo)
	//{
		//3)dto에 2)에서 받은 인자와 기본값을 삽입
		//MemoDto2 dto=new MemoDto2(1,nickname,photo,memo,10,"2022-12-25");
		//4)dto 반환
		//return dto;
	//}
//	(12)postman 접속후 get data 에서  http://localhost:8080/day1116/test/add 입력후 
//		밑에 key:값에 nickname photo memo 원하는것 입력하면 해당 데이터를 포함해서 제이슨 형태로 출력
//}

//(13)
//RestTestController1의 앞에 두개 매핑을 모두 주석처리 하고 
//@responsebody를 안쓰기 위해서@RestController을 쓴 버전 작성


//1)
//@RestController으로 쓴RestTestController1 의 내용을 복붙
//(@GetMapping("/test/list1"),@GetMapping("/test/add")부분 복붙)
@RestController
public class RestTestController1 {
	
	@GetMapping("/test/list1")
	public List<MemoDto2> list1()
	{
		List<MemoDto2> list=new ArrayList<MemoDto2>();
		
		list.add(new MemoDto2(1,"캔디","1.jpg","안녕",5,"2023-10-10"));
		list.add(new MemoDto2(2,"안소니","2.jpg","헬로",5,"2023-10-10"));
		list.add(new MemoDto2(3,"테리우스","3.jpg","안녕",5,"2023-10-10"));
		
		return list;
	}
	
	
	@GetMapping("/test/add")
	
	public MemoDto2 add(String nickname, String photo,String memo)
	{
		//3.dto에 2에서 받은 인자와 기본값을 삽입
		MemoDto2 dto=new MemoDto2(1,nickname,photo,memo,10,"2022-12-25");
		//4.dto반환
		return dto;
	}

	
	//2)RestTestController1의@GetMapping("/test/list2") 부분 작성
		//1.@GetMapping("/test/list2") 매핑
	@PostMapping("/test/list2")
		//2.Map방식으로 {String :String}을 받는 test함수
	public Map<String, String> test()
	{
		//3.{String :String}을HashMap방식으로 받음
		Map<String, String> map=new HashMap<String, String>();
		//4.데이터 2개 삽입
		map.put("name", "홍길동");
		map.put("age", "35");
		//5.map반환
		return map;
	}
//(14)postman 의 getdata에서 get으로 바꾼 후 
//	http://localhost:8080/day1116/test/add를 입력하고 send로 전송하면 결과 확인	
	
//	(15)postman 의 getdata에서 post로 바꾼 후 
//	http://localhost:8080/day1116/test/list2를 입력하고 send로 전송하면 결과 확인
}

















