package day1108.test4;

import lombok.Setter;

//(7)setter�ҷ�����
@Setter
public class Bitcamp {
	//(6)StudentŬ������ SawonŬ���� �ҷ�����
	private Student stu;
	private Sawon sawon;
	
	//(8)��� Ʋ�� ����� ���� infoProcess()�Լ� ����
	public void infoProcess()
	{
		System.out.println("** �л����� **");
		System.out.println("�̸�:"+stu.getName());
		System.out.println("������:"+stu.getBlood());
		System.out.println("����:"+stu.getAge());
		System.out.println();
		System.out.println("** ��� ����**");
		System.out.println("�����:"+sawon.getName());
		System.out.println("����:"+sawon.getCity());
		System.out.println("���:");
		for(String h:sawon.getHobby())
			System.out.println(h);
	}
	//(9) appcontext1.xml�� 
	// 1.id�� stu�� �ؼ� Student.java�� ������name/age/blood����
	// 2.id�� sawon���� �ؼ� Sawon.java�� ���� ��name/city/hobby����
	// 3.id�� bit���� �ؼ� sawon,stu�ҷ���
}
