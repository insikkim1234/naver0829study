package bit701.day0830;

public class ExamEx8_1 {

	public static void main(String[] args) {
		//money 변수에 args[0]값을 대입5674321ㅇ후 단위 백만
				/*
				 * 출력
				 * money :5674321원
				 * 만원짜리 567장
				 * 천원짜리 4장
				 * 100원짜리 3개
				 * 10원 2개
				 * 1원 1개
				 * 
				 */
				//산술연산자 사용해서 출력하기
		int money=Integer.parseInt(args[0]);
		System.out.println("money"+money);
		System.out.println("만원짜리: "+money/10000+"장");
		System.out.println("천원짜리: "+(money%10000)/1000+"장");
		System.out.println("백원짜리: "+(money%1000)/100+"개");
		System.out.println("십원짜리: "+(money%100)/10+"개");
		System.out.println("일원짜리: "+(money%10)+"개");
		
		
	}

}
