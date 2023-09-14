package Study;

import java.util.Stack;

public class Ex12 {

	public static void main(String[] args) {
		String []groupA= {"우즈벡","프랑스","미국",
				"영국","태국","스위스","대한민국"};
		Stack<String>stack=new Stack<String>();
		
		for(String g:groupA)
		{
			stack.push(g);
		}
		
		System.out.println("pop으로 데이터 꺼내 출력하기");
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}

	}

}
