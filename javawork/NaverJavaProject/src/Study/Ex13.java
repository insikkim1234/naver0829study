package Study;

import java.util.Vector;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> list1=new Vector<String>();
		System.out.println(list1.capacity());
		
		Vector<String> list2=new Vector<String>(5);
		System.out.println(list2.capacity());
		
		Vector<String> list3=new Vector<String>(3,2);
		System.out.println(list1.capacity());
		
		list3.add("red");
		list3.add("green");
		list3.add("blue");
		list3.add("pink");
		
		System.out.println(list3.capacity());
		System.out.println(list3.size());
		
		

	}

}
