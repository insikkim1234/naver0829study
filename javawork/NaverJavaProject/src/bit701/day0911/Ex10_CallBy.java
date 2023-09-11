package bit701.day0911;

public class Ex10_CallBy {
	
	
	//call by value 값만 전달되기에 a가 20으로 바꼇음에도
	//불구하고 a=10이다
	//모든 기본형과 string타입은 값만 전달된다
	public static void changeInt(int a)
	{
		System.out.println("전달받은 a값:"+a);
		
		//a값을 변경
		a=20;
		System.out.println("변경된후 a값"+a);
		
	}
	
	//call by reference
	//이런식으로 배열은 주소가 전달되면서 객체 타입으로 인식된다
	public static void changeArray(int []arr)
	{
		System.out.println("전달받은 배열 확인");
		for(int a:arr)
		{
			System.out.print(a+"\t");
		}
		System.out.println("\n1번지 값을 변경해보자");
		arr[1]=100;
	}

	public static void main(String[] args) {
		int a=10;
		changeInt(a);
		System.out.println("main a="+a);
		
		int []arr= {3,4,5};
		changeArray(arr);
		System.out.println("main에서 arr배열 확인");
		for(int n:arr)
		{
			System.out.print(n+"\t");
		}
		System.out.println();
		
		

	}

}
