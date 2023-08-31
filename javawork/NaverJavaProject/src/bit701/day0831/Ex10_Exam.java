package bit701.day0831;

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
		System.out.println("수량을 입력하시오");
		int num=Integer.parseInt(sc.nextLine());
		
		System.out.println("단가를 입력하시오");
		int price=Integer.parseInt(sc.nextLine());
		
		int total=num*price;
		
		
		if(total>6000) {
			System.out.println("총금액: "+total);
			System.out.println("5개 이상 10%할인된 금액: "+(total*0.9));
			}
		else
			System.out.println("총금액: "+total);

}
}
