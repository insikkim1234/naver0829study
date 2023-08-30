public class DataTypeEx1{
	public static void main(String []args)//
	{
		//이라인은 비실행문입니다
		/*
			2023.08.30 데이타 타입 예제
		*/
		//byte는 1바이터 크기의 정수형 타입입니다
		//크기는 -128 127까지만 저장 가능합니다
		byte a=127;
		System.out.println("a="+a);

		byte b=(byte)200;//200으로 저장시 오류 발생 강제형변환
		System.out.println("b="+b);//형변환 했을경우 값손실 발생
		//-56이 나오는 이유는 노트에 있음

		//실행시 인자로 넘어오는 문자열을 확인해보자
		System.out.println(args[0]);//배열의 첫문자열 출력
		//이걸 실행하면 ArrayIndexOutOfBoundsException오류 나옴

		//java DataTypeEx1 apple 을 cmd창에 입력해서 인자 하나를 주어서 args[0]에 
		//채울 수 있게 되었다.

		//java DataTypeEx1 20을 입력하면 20이 숫자가 아닌 스트링으로 입력
	}
}

