public class ArgsArray{
	public static void main(String []args)
	{
		//args로 두개의 숫자를 읽어서 출력해보자
		String str1=args[0];
		String str2=args[1];
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("두수의 합="+(str1+str2));


		//1020 입력 후 출력하면 30이 아닌 1020으로 나온다
		//string을 기본형 인트로 변환하는 방법
		//Integer라는 wrapper class이용해서 변환
		int su1=Integer.parseInt(str1);
		int su2=Integer.parseInt(str2);
		System.out.println("두수의 합="+(su1+su2));
	
	}
}

