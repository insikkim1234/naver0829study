package bit701.day0831;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex7_Format {

	public static void main(String[] args) {
		//패턴을 이용해서 다양하게 날?짜와 시간을 출력해보자
		Date date=new Date();

		//패턴1
		SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		//MM월 mm 분 EEE요일짧게 HH24시간 기준
		System.out.println(dateFormat1.format(date));


		//패턴1
		SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy년MM월dd일 a HH:mm:ss EEEE");
		//a 오전 오후 EEEE요일길게 hh12시간기준
		System.out.println(dateFormat1.format(date));
		
		//숫자를 ㅍ맷 양식에 맞게 출력하기
		int money=4567890;
		
		NumberFormat numberFormat1=NumberFormat.getInstance();//단순 컴마만 추가해서 출력
		System.out.println(numberFormat1.format(money));//4,567,890
		
		NumberFormat numberFormat2=NumberFormat.getCurrencyInstance();//지역설정된 화폐단위 붙여서 출력(원화)
		System.out.println(numberFormat2.format(money));
		
		double num=456.12345;
		System.out.println(numberFormat1.format(num));//3자리씩 끊어서소수점은 셋째자리까지만
		
		numberFormat1.setMaximumFractionDigits(1);
		System.out.println(numberFormat1.format(num));
		//소수점아래 한자리만 출력(그아래는 반올림) 456.1
		
	}

}
