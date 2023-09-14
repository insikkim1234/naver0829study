package Study;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "김태희");
		map.put("age", "30세");
		map.put("addr", "강남구");
		System.out.println("갯수: "+map.size());
		map.put("name", "송혜교");
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("addr"));
		System.out.println(map.get("blood"));
		
		map.remove("addr");
		map.get("addr");
		
		Set<String> keys=map.keySet();
		for(String key:keys)
		{
			String v=map.get(key);
			System.out.println(key+":"+v);
		}
		

	}

}
