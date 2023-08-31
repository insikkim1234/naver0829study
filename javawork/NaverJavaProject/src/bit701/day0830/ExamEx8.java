package bit701.day0830;

public class ExamEx8 {

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
		
		//파라미터에서 월급여를 읽어서 정수타입으로 변환
		int money=Integer.parseInt(args[0]);
		System.out.println("월급여 :"+money);
		//parseiInt 안에 스트링 타입을 넣어서 int로 바꿔줌
		//이때 만약 argument를 회계처럼 숫자를 쓰게되면 
		// java.lang.NumberFormatException 오류가 뜨게 된다
		//만약 이오류가 뜨면 Integer.parseInt(args[0]);구문찾기
		System.out.println("만원짜리"+ money/10000+"장");
		System.out.println("천원짜리"+(money%10000)/1000+"장");
		System.out.println("백원짜리"+(money%1000)/100+"장");
		System.out.println("십원짜리"+(money%100)/10+"개");
		System.out.println("일원짜리"+(money%10)+"개");
		
		
		/*String MyMoney=args[0];
		int money=Integer.parseInt(MyMoney);
		int sejong=money/10000;
		int ee=(money%10000)/1000;
		int onehundred=((money%10000)%1000)/100;
		int ten=(((money%10000)%1000)%100)/10;
		int one=(((money%10000)%1000)%100)%10;
		System.out.printf("money :%d\n",5674321);
		System.out.printf("만원짜리 :%d\n",sejong);
		System.out.printf("천원짜리 :%d\n",ee);
		System.out.printf("100원짜리 :%d\n",onehundred);
		System.out.printf("10원짜리 : %d\n",ten);
		System.out.printf("1원짜리 :%d\n",one);*/

	}

}
