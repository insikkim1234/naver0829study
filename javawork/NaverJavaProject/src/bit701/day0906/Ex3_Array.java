package bit701.day0906;

public class Ex3_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다양한 타입으로 배열에 저장
		char []arr1= {'A','p','p','l','e'};
		
		double []arr2;
		arr2=new double[] {1.7,8.9,3.4};
		
		
		String []arr3=new String[3];
		arr3[0]="사과";
		arr3[1]="오렌지";
		arr3[2]="딸기";

		System.out.println("***arr1 출력***");

		for(int i=0;i<arr1.length;i++)
		{
			System.out.print(arr1[i]);
		}
		System.out.println();
		
		

		System.out.println("***arr2 출력***");

		for(int i=0;i<arr2.length;i++)
		{
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		
		
		System.out.println("***arr3 출력***");

		for(int i=0;i<arr3.length;i++)
		{
			System.out.print(i+"\t");
		}
		
		System.out.println("=".repeat(30));
		
		System.out.println("***arr1 출력***");
		for(char i:arr1)
		{
			System.out.print(i);
		}
		System.out.println();
		
		

		System.out.println("***arr2 출력***");

		for(double i:arr2)
		{
			System.out.print(i+"\t");
		}
		System.out.println();
		
		
		System.out.println("***arr3 출력***");

		for(String i : arr3)
		{
			System.out.print(i+"\t");
		}

	}

}
