package Study;

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

public class Ex5_Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []sarr= {"장미꽃","안개꽃","다일리아"};
		
		GenericsType<String> t1=new GenericsType<String>();
		
		t1.set(sarr);
		t1.print();
		
		System.out.println("-".repeat(30));
		
		GenericsType<Integer> t2=new GenericsType();
		
		Integer []narr= {5,7,10,30,100};
		t2.set(narr);
		t2.print();

	}

}
