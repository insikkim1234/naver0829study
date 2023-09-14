package bit701.day0914;


//T는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용하면 된다

class GenericsType<T>
{
	//선언
	T[] v;
	
	public void set(T[] n)
	{
		v=n;
	}
	//출력
	public void print()
	{
		for(T s:v)
		{
			System.out.print(s+" ");
		}
		System.out.println();
	}
}



public class Ex5_Generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//저장하고 싶은 데이터를 스트링 형식으로 받음
		String []sarr= {"장미꽃","안개꽃","다일리아"};
		
		GenericsType<String> t1=new GenericsType<>();// 뒤에 태그는 생략하기도 한다
		
		t1.set(sarr);
		t1.print();
		
		System.out.println("-".repeat(30));
		//GenericsType<int> t2=new GenericsType(); 
		//t자리에는 클래스 타입만 가능하다 따라서 int는 안되고 integer만 가능
		
		Integer []narr= {5,7,10,30,100};
		GenericsType<Integer> t2=new GenericsType();
		
		
		t2.set(narr);
		t2.print();
	}

}
