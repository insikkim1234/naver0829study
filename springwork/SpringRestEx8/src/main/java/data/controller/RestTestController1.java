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

//(8)RestTestController1���� @GetMapping("/test/list1")�ۼ�
//@Controller
//public class RestTestController1 {
	
	//1)@GetMapping("/test/list1") ����
	//@GetMapping("/test/list1")
	//@ResponseBody public List<MemoDto2> list1()
	//{
		//2)Ʃ���� ������ ����Ʈ ����
		//List<MemoDto2> list=new ArrayList<MemoDto2>();
		//3)����Ʈ�� Ʃ�� �߰�
		//list.add(new MemoDto2(1,"ĵ��","1.jpg","�ȳ�",5,"2023-10-10"));
		//list.add(new MemoDto2(2,"�ȼҴ�","2.jpg","���",5,"2023-10-10"));
		//list.add(new MemoDto2(3,"�׸��콺","3.jpg","�ȳ�",5,"2023-10-10"));
		//4)����Ʈ ��ȯ
		//return list;
	//}
	
//	(10)ŽĹ ���� �� postman ���� 
//	1)collections ������ 
//	2)+������
//	3)restapi�˻��� �߰�
//	4) getdata Ŭ�� 
//	5) Get����, �ּ��Է�http://(localhost:8080/day1116/test/list1)
//	6) send ������ json ������ ���´�
//
//	[{1,"ĵ��","1.jpg","�ȳ�",5,"2023-10-10"},
//	 {2,"�ȼҴ�","2.jpg","���",5,"2023-10-10"},
//	{3,"�׸��콺","3.jpg","�ȳ�",5,"2023-10-10"}]
	
	//(11)RestTestController1��@GetMapping("/test/add") �κ� �ۼ�
	//1)@GetMapping("/test/add") �ּ� ����
	//@GetMapping("/test/add")
	//2)���ڷ� nickname,photo,memo �ޱ�
	//@ResponseBody public MemoDto2 add(String nickname, String photo,String memo)
	//{
		//3)dto�� 2)���� ���� ���ڿ� �⺻���� ����
		//MemoDto2 dto=new MemoDto2(1,nickname,photo,memo,10,"2022-12-25");
		//4)dto ��ȯ
		//return dto;
	//}
//	(12)postman ������ get data ����  http://localhost:8080/day1116/test/add �Է��� 
//		�ؿ� key:���� nickname photo memo ���ϴ°� �Է��ϸ� �ش� �����͸� �����ؼ� ���̽� ���·� ���
//}

//(13)
//RestTestController1�� �տ� �ΰ� ������ ��� �ּ�ó�� �ϰ� 
//@responsebody�� �Ⱦ��� ���ؼ�@RestController�� �� ���� �ۼ�


//1)
//@RestController���� ��RestTestController1 �� ������ ����
//(@GetMapping("/test/list1"),@GetMapping("/test/add")�κ� ����)
@RestController
public class RestTestController1 {
	
	@GetMapping("/test/list1")
	public List<MemoDto2> list1()
	{
		List<MemoDto2> list=new ArrayList<MemoDto2>();
		
		list.add(new MemoDto2(1,"ĵ��","1.jpg","�ȳ�",5,"2023-10-10"));
		list.add(new MemoDto2(2,"�ȼҴ�","2.jpg","���",5,"2023-10-10"));
		list.add(new MemoDto2(3,"�׸��콺","3.jpg","�ȳ�",5,"2023-10-10"));
		
		return list;
	}
	
	
	@GetMapping("/test/add")
	
	public MemoDto2 add(String nickname, String photo,String memo)
	{
		//3.dto�� 2���� ���� ���ڿ� �⺻���� ����
		MemoDto2 dto=new MemoDto2(1,nickname,photo,memo,10,"2022-12-25");
		//4.dto��ȯ
		return dto;
	}

	
	//2)RestTestController1��@GetMapping("/test/list2") �κ� �ۼ�
		//1.@GetMapping("/test/list2") ����
	@PostMapping("/test/list2")
		//2.Map������� {String :String}�� �޴� test�Լ�
	public Map<String, String> test()
	{
		//3.{String :String}��HashMap������� ����
		Map<String, String> map=new HashMap<String, String>();
		//4.������ 2�� ����
		map.put("name", "ȫ�浿");
		map.put("age", "35");
		//5.map��ȯ
		return map;
	}
//(14)postman �� getdata���� get���� �ٲ� �� 
//	http://localhost:8080/day1116/test/add�� �Է��ϰ� send�� �����ϸ� ��� Ȯ��	
	
//	(15)postman �� getdata���� post�� �ٲ� �� 
//	http://localhost:8080/day1116/test/list2�� �Է��ϰ� send�� �����ϸ� ��� Ȯ��
}

















