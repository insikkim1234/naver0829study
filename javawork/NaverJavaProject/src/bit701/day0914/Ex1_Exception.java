package bit701.day0914;

public class Ex1_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {10,20,30};
		//배열 번지를 원래대로라면 [0,arr.length) 로 해야 하는데 
		//[0,arr.length]로 잡는 바람에 오류가 생겼음
		//이를 해결하기 위해 트라이 캣치 문을 사용하여서 배열 번지를 된데까지만 출력하고 정상종료
		for(int i=0;i<=arr.length;i++)
		{
			try {
			System.out.println(arr[i]);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("배열 번지를 벗어났어요"+e.getMessage());
				e.printStackTrace();//에러메세지를 추적해서 출력
			}
		}
		System.out.println("정상종료");

	}

}
