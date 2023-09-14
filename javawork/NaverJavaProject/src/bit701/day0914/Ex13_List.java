package bit701.day0914;
//list인터페이스 구현한 벡터나 arraylist연습

import java.util.Vector;

public class Ex13_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//백터는 할당량이 존재하고 거기서 하나만 늘어나도 단위갯수만큼 증가한다
		Vector<String> list1=new Vector<String>();//기본 10개 할당 10개씩 증가
		System.out.println("list1의 할당갯수:"+list1.capacity());
		
		Vector<String> list2=new Vector<String>(5);//기본 5개 할당 5개씩 증가
		System.out.println("list2의 할당갯수:"+list2.capacity());
		
		Vector<String> list3=new Vector<String>(3,2);//기본 3개 할당 2개씩 증가
		System.out.println("list3의 할당갯수:"+list3.capacity());
//		list3.add("red");
//		list3.add("green");
//		list3.add("blue");
//		list3.add("pink");
//		
//		System.out.println("list3의 할당갯수:"+list3.capacity());
//		System.out.println("list3의 데이터갯수:"+list3.size());

	}

}
