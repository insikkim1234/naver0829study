package bit701.day0914;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex11_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//map이라는 이름의해쉬맵 생성
		Map<String,String> map=new HashMap<String, String>();
		//맵에 키 값 형태로정보저장
		map.put("name","캔디");
		map.put("kor","90");
		map.put("blood","ab");
		map.put("ipsday","1989-12-12");
		map.put("hp","010-2222-4444");
		
		//key값을 얻은 후 key에 해당하는 value 알아보자 keyset이용
		//set 컨스
		Set<String> keys=map.keySet();
		for(String key:keys)
		{
			String v=map.get(key);
			System.out.println(key+":"+v);
		}

	}

}
