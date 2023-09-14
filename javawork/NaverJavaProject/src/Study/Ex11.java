package Study;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String, String>();
		
		map.put("name", "캔디");
		map.put("kor", "90");
		map.put("blood", "ab");
		map.put("ipsday", "1989-12-12");
		map.put("hp", "010-2222-4444");
		
		Set<String> keys=map.keySet();
		for(String key:keys)
		{
			String v=map.get(key);
					System.out.println(key+":"+v);
		}

	}

}
