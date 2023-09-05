package bit701.day0904;

import java.util.Scanner;

public class Ex8_Book133 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("메세지를 입력하세요");
		
		System.out.println("프로그램을 종료하려면 q를 입력");
		
		
		String inputString;
		
		do {
			System.out.print(">");
			inputString=sc.nextLine();
			System.out.println(inputString);
			
		}while(!inputString.equals("q"));//equals는 대소문자가 같아야지 됨 그래서 Q는 안먹힘 equalsIgnoreCase대소문자 상관없이 q입력시 종료
		
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
