package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("hello!33\t");
		System.out.print("happy!454!");
		System.out.println("orange");
		//println은 개행 print는 개행아님 
		//printf는 변환기호(정수실수문자열)에 의해 출력하는 방법
		//정수%d 실수%f 문자%c 문자열%s
		//\n은 줄넘김 \t는 다음탭위치로 이동(프린트 모든형태에서 가능)
		
		int age=23;
		double weight=56.7;
		char blood='A';//두글자 입력하면 오류
		String name="캐서린";
		System.out.printf("이름:%s\n\n",name);
		System.out.printf("나이:%d\n",age);
		System.out.printf("몸무게:%fkg\n",weight);
		//퍼센트 에프 썼을때 뒷자리 없애는방법
		System.out.printf("몸무게:%5.1fkg\n",weight);
		//전체자리수(앞에공백부터 5칸) 5 소수점자리수1
		System.out.printf("혈액형:%c형\n",blood);
		System.out.println("=============");
		System.out.printf("이름:%s\n 혈액형:%c형\n 나이:%d세\n",name,blood,age);
	}

}
