package day1109.test5;

public class Car {
	//(4)Ÿ�̾� �������̽� ����(tire)
	Tire tire;
	
	//(5)tire�� �޴� �⺻������ ����
	public Car(Tire tire) {
		// TODO Auto-generated constructor stub
		this.tire=tire;
	}
	
	//(6)�� ���� Ÿ�̾�� ???�Դϴ� ���
	public void myCarInfo()
	{
		System.out.println("�� ���� Ÿ�̾�� "+tire.getTireName()+"�Դϴ�");
	}
}
