package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		/*
		 * 상품명과 수량 단가를 각각 입력받은 후 총금액을 출력하시오d
		 * 그리고 수량이 5개 이상인 경우 10프로 할인된 최종 금액도 출력하시오
		 * 
		 * 상품명 :딸기
		 * 수량:6
		 * 단가 : 1000
		 * 
		 * 총금액:6000원 
		 * 5개 이상 10프로 할인된 금액 : 5400 원
		 */
		Scanner sc=new Scanner(System.in);
		
		NumberFormat numFormat=NumberFormat.getInstance();
		String  sangpum="";
		int su=0,dan=0,total=0;
		
		//입력
		System.out.println("상품명");
		sangpum=sc.nextLine();
		System.out.println("수량");
		su=sc.nextInt();
		System.out.println("단가");
		dan=sc.nextInt();
		
		
		//계산
		//총금액
		total=su*dan;
		
		System.out.println("총금액="+numFormat.format(total)+"원");
		
		//5개 이상 할인받는 조건 추가
		
		if (su>=5)
		{
			total=(int)(total*0.9);//integer에 double 곱하면 오류
			System.out.printf("5개 이상 10%% 할인된 금액 : %d 원\n",total);//printf에서만 %을 출력하고 싶으면 %%쓰자
			System.out.printf("5개 이상 10%% 할인된 금액 : %s 원\n",numFormat.format(total));//포멧으로 바꾼건 문자열취급
		}
		

}
}
