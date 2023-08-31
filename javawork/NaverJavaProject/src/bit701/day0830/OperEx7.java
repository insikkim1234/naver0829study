package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// 비교연산자와 논리연산자는 무조건 
		//true false로 나온다
		int kor=100,eng=90,mat=100;
		System.out.println(kor>80);//true
		System.out.println(kor>=80||kor!=mat);//true
		System.out.println(kor<80||kor!=mat);
		//앞에게 먼저 참인지 보고 참이면 뒤에거 안보고 판정
		System.out.println(kor>=80&&kor!=mat);
		System.out.println(kor<80&&kor!=mat);
		System.out.println(!(kor==mat));
		System.out.println(kor>=95&&eng>=95||mat>=95);
		System.out.println(kor>=95||eng>=95&&mat>=95);
		
		int year=2030;//위의 년도가 윤년인지 아닌지 알아보자
		System.out.println(year%4==0 && year%100!=0 ||year%400==0);

	}

}
