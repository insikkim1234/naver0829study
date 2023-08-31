package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex2_KeyInput {

	public static void main(String[] args) {
		
		//Date  클래스를 이용해서 현재 연도를 구해보자(jdk1.1에서 deprecae 되었지만 여전히 많이 사용)
		//Calendar을 권장하긴 함
		Date date=new Date();
		//int curYear=date.getYear();
		//getYear은 현재년도에서 1900을 뺀값이 저장되므로 여기다가 1900 더해줘야함
		//줄이 가있는 이유는 deprecated되었기 때문임
		int curYear=date.getYear()+1900;
		System.out.println("현재년도: "+curYear);
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("당신의 태어난 년도는?");
		int birthYear=Integer.parseInt(sc.nextLine());
		//이렇게 문자열로 읽은후 숫자로 변경해주면 오류없이 잘 읽는다
		
		System.out.println("지금 사는곳은 어디입니까?");
		String address=sc.nextLine();
		
		//나이 구하기
		int age=curYear-birthYear;
		
		System.out.println("저는 "+address+"에사는 "+birthYear+"년생("+age+")세 학생입니다");
		System.out.printf("저는 %s에 사는 %d 년생 (%d)세 학생입니다\n",address,birthYear,age);
		
		//20세 이상이면 성인 20대 미만이면 미성년자라는 글자 출력
		//if 나 삼항(조건)연산자를 사용하여 쓰면 된다
		//조건식?참출력 :거짓출력 
		/*String msg=age>=20?"성인":"미성년자";
		System.out.println("당신은 "+msg);*/
		//if 이용출력
		String msg="";//지역변수는 자동초기화가 안되고 쓰레기값이 들어있으므로
					//값이 안들어갈경우 대비해서 초기값을 지정하는게 좋음
					//지역변수는 그 구역을 빠져나가게 되면 자동소멸하므로 사용이 불가능하다
					//그래서 if 밖에다가 한것임 만약에 이프 안에다 했으면 else에서는 사용을 하지 못함
		if(age>=20) {//한문장만 쓸때는 {}없어도됨 두문장 이상이면 무조건사용
			msg="성인";
		}else
			msg="미성년자";
		System.out.println("당신은 "+msg);
	}

}
