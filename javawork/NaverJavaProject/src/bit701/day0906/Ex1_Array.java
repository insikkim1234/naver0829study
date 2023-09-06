package bit701.day0906;

public class Ex1_Array {

	public static void main(String[] args) {
		//배열 : 연속된 형태로 데이터가 저장됨(변수는 하나만 저장)
		//같은타입의 데이터만 저장이 가능하다 
		//일괄적으로 처리하기 위해서 배열을 사용한다
		//자바에서 하나의 배열은하나의 객체로 인식된다
		//개수가 정해져 있으면 배열 없으면 컬랙션 주로 사용
		
		//배열 선언방법1
		int [] arr1=new int[5];//5개의 정수타입 저장할 공간 확보하고 0으로 자동초기화(다른타입이면 null로 초기화)
		System.out.println("arr1의 할당 갯수 "+arr1.length);//속성이므로 괄호x 할당갯수 5개
		
		
		//배열의 특정번지에 값을 넣는 방법
		arr1[1]=10;
		arr1[4]=50;
		
		
		//출력1
		for(int i=0;i<arr1.length;i++)//<=이면 오류(범위벗어남)
		{
			System.out.println(arr1[i]);
		}
		
		System.out.println();
		
		//출력2
		for(int n:arr1)//arr1의 갯수만큼 자동으로 반복이 되면서 하나하나의값을 n으로 보낸다
		{
			System.out.println(n);
		}

	}

}
