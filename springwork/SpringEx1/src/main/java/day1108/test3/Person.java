package day1108.test3;

import lombok.Getter;

@Getter
public class Person {
	//(4) 사용할 변수 생성
	private String name;
	private String addr;
	private MyShop myShop;
	
	//(5) name만 있는 생성자
	public Person(String name) {
		this.name=name;
	}
	//(6) addr,myShop만 setter생성
	public void setAddr(String addr) {
		this.addr=addr;
	}
	
	public void setMyShop(MyShop myShop) {
		this.myShop=myShop;
	}
	
	//(7)이름,주소 주문한 상품,가격,색상 출력해주는 함수 
	//writeProcee()
	public void writeProcee()
	{
		System.out.println("이름:"+name);
		System.out.println("주소:"+addr);
		System.out.println("쇼핑정보");
		System.out.println(myShop.getSangpum()+"상품");
		System.out.println(myShop.getPrice()+"원");
		System.out.println(myShop.getColor()+"색상");
	}
}
