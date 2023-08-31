package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("내이름은 "+args[0]+" 입니다");
		//원래대로라면 에러가 떠야 하지만 화살표 밑에 run configuration
		//argument에서 이름 입력하면 된다
		System.out.println("내주소는 "+args[1]+" 입니다");
		//인자 두개 받고싶으면argument에서 
		//김인식 강남구
		System.out.println("내혈액형은 "+args[2]+" 입니다");
		//김인식 강남구 ab
		System.out.println("실수형 데이터 타입");
		
		
		float f1=1234.567891234f;
		//1234.567891234는 더블 이므로(float는 소수점포함 여덟자리까지)
		//뒤에 f를 붙여서 float로 만들어줌
		double f2=1234.567891234;
		System.out.println(f1);//float는 소수점포함 여덟자리까지
		System.out.println(f2);//double은 소수점 포함 열다섯자리까지
		
		
		//char 타입은 2바이트라 한글 한글자도 저장이 가능하다
		char ch1='A';
		char ch2='가';
		System.out.println(ch1);
		System.out.println(ch2);
	}

}
