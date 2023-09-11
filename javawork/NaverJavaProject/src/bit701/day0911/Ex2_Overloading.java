package bit701.day0911;
class Apple{
	public static int sum(int a,int b)
	{
		System.out.println(1);
		return a+b;
	}
	
	public static int sum(int s1,int s2,int s3)
	{
		return s1+s2+s3;
	}
	public static double sum(double a,double b)
	{
		return a+b;
	}
	public static String sum(String a,String b)
	{
		return a+b;
	}
	public static String sum(String a,int b)
	{
		return a+b;
	}
	//...Variable argument
	/*public static int sum(int ...n)//n은 배열로 넘어오고, 숫자 갯수 상관없이 int로 배열타입으로 받는다 
	//근데 겹치면 올바른것 먼저 없으면 이거출력
	{
		System.out.println(2);
		System.out.println("총  "+n.length);
		return 0;
	}*/
	
}

public class Ex2_Overloading {

	public static void main(String[] args) {
		int s1=Apple.sum(5, 7);
		System.out.println(s1);
		System.out.println(Apple.sum("apple","orange"));
		System.out.println(Apple.sum(1.2,4.5));
		System.out.println(Apple.sum(100,200,300));
		//System.out.println(Apple.sum(100,200,300,400));

	}

}
