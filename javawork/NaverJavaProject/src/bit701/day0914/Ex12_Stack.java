package bit701.day0914;

import java.util.Stack;

public class Ex12_Stack {

	public static void main(String[] args) {
		String []groupA= {"우즈벡","프랑스","미국","영국","태국","스위스","대한민국"};
		//스택 생성 스택에 컨스
		Stack<String>stack=new Stack<String>();
		//스택에 데이터 추가
		for(String g:groupA)
		{
			stack.push(g);
		}
		//출력
		System.out.println("pop으로 데이터 꺼내 출력하기");
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		

	}

}
