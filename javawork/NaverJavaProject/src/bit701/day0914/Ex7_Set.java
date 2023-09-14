package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set 인터페이스 특징1. 순차적이 아니다
		//2.중복허용을 안한다
		//Set<Integer> set=new HashSet();//정렬안함
		Set<Integer> set=new TreeSet<Integer>();//오름차순
		System.out.println(set.size());//size는 데이터의 갯수 (배열이면 length) 초기상태는 0개
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size());//3개만 들어감(5는 1번만 계산하기 때문)
		
		//컬렉션들을 출력하는 방법
		//출력1
		System.out.println("----------------------");
		for(Integer n: set)
			System.out.println(n);
		System.out.println("----------------------");
		
		//출력2
		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("--------------");
	}

}
