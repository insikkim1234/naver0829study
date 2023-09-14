package bit701.day0914;

import java.util.HashMap;
import java.util.Map;

public class Ex10_Map {

	public static void main(String[] args) {
		//키 값 구조 map,hashmap에 컨스페
		Map<String,String> map=new HashMap<String, String>();
		map.put("name","김태희");//key value
		map.put("age","30세");
		map.put("addr","강남구");
		System.out.println("갯수: "+map.size());
		map.put("name","송혜교");//같은 키값이 들어오면 덮어쓴다
		
		//key값을 알아야 밸류 값을 얻을수있음
		System.out.println("이름: "+map.get("name"));
		System.out.println("나이: "+map.get("age"));
		System.out.println("주소: "+map.get("addr"));
		
		System.out.println("혈액형:"+map.get("blood"));//맵에 없을경우 null 반환
		
		System.out.println("addr키값을 제거햅자");
		map.remove("addr");
		System.out.println("주소:"+map.get("addr"));//제거되어씅므로 null값 반환

	}

}
