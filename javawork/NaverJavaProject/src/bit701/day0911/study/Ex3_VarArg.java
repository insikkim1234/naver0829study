package bit701.day0911.study;

public class Ex3_VarArg {
	public static int sum(int...n)
	{
		System.out.println("총"+n.length+"개");
		int s=0;
		for(int i=0;i<n.length;i++)
		{
			System.out.println(i+":"+n[i]);
			s+=n[i];
		}
		return s;
	}
	
	public static void stringWrite(String ...str)
	{
		System.out.println("총 "+str.length+"개의 문자열");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
