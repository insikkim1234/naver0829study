package day1108.test3;

import lombok.Getter;

@Getter
public class Person {
	//(4) ����� ���� ����
	private String name;
	private String addr;
	private MyShop myShop;
	
	//(5) name�� �ִ� ������
	public Person(String name) {
		this.name=name;
	}
	//(6) addr,myShop�� setter����
	public void setAddr(String addr) {
		this.addr=addr;
	}
	
	public void setMyShop(MyShop myShop) {
		this.myShop=myShop;
	}
	
	//(7)�̸�,�ּ� �ֹ��� ��ǰ,����,���� ������ִ� �Լ� 
	//writeProcee()
	public void writeProcee()
	{
		System.out.println("�̸�:"+name);
		System.out.println("�ּ�:"+addr);
		System.out.println("��������");
		System.out.println(myShop.getSangpum()+"��ǰ");
		System.out.println(myShop.getPrice()+"��");
		System.out.println(myShop.getColor()+"����");
	}
}
