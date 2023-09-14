package Study;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex7_Set {

	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		System.out.println(set.size());
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size());
		
		System.out.println("--------------");
		for(Integer n:set)
			System.out.println(n);
		System.out.println("________________");
		
		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("----------------");
		

	}

}
