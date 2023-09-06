package bit701.day0906;

public class Ex2_Array {

	public static void main(String[] args) {
		//배열 선언시 초기값 지정
		int []arr= {5,8,10,4,20};//5개로 배열이 자동 할당
		//할당 갯수 출력
		System.out.println("arr의 할당갯수"+arr.length);
		
		//출력 방법1
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		//출력방법2
		for(int i:arr)
		{
			System.out.println(i);
		}
		
		System.out.println("=".repeat(30));
		int []arr2;
		arr2=new int[]{3,6,8,10,30};//선언 하고 나중에 지정할경우
	
		//출력 방법1
				for(int i=0;i<arr2.length;i++)
				{
					System.out.printf("[%d:%d]",i,arr2[i]);
				}
				System.out.println();
				
				
		//출력방법2
				for(int n:arr2)
					System.out.printf("%3d",n);
				System.out.println();
		

	

}
}
