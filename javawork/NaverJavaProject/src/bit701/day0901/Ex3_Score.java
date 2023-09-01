package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex3_Score {

	public static void main(String[] args) {
		/*이름과 세과목의 점수 kor eng mat
		 * 를 입력받은후 총점과 평균(소수점1자리까지 출력/NumberFormat이용)
		 * 등급 출력(grade) 평균이 90이상이면 "Excellent" 80이상이면 "good
		 *나머지는 Try "
		 */
		
		Scanner sc=new Scanner(System.in);
		NumberFormat numFormat=NumberFormat.getInstance();
		numFormat.setMaximumFractionDigits(1);
		
		
		int total=0,kor=0,eng=0,mat=0;
		double avg=0;
		String grade="",name="";
	
		System.out.println("이름입력");
		name=sc.nextLine();
		System.out.println("3과목의 점수 입력: ");
		kor =sc.nextInt();
		eng =sc.nextInt();
		mat =sc.nextInt();
		total=eng+mat+kor;
		avg=(double)total/3;
		
		
		
		
		
		
		if(avg>=90)
			grade="excellent";
		else if(avg>=80)
			grade="good";
		else
			grade="try";
		
		System.out.println("이름: "+name);
		System.out.println("국어점수: "+kor);
		System.out.println("영어점수: "+eng);
		System.out.println("수학점수: "+mat);
		System.out.println("총점: "+total);
		System.out.println("평균: "+numFormat.format(avg));
		System.out.println("평가: "+grade);
		
		
		
	}

}
