package bit701.day0914;


//T는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용하면 된다
//T에 대체되는 타입은 클래스 타입이나(string) 인터페이스만 가능하다 왜냐면 
class GenericsType<T>
{
	T[] v;
	public void set(T[] n)
	{
		v=n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			System.out.println(s+" ");
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
		//GenericsType<int> t2=new GenericsType(); t자리에는 클래스 타입만 가능하다 따라서 int는 안되고 integer만 가능
		GenericsType<Integer> t2=new GenericsType();
		
		Integer []narr= {5,7,10,30,100};
		t2.set(narr);
		t2.print();
	}

}
