package day1108.test1;

public class TestMainEx1 {

	public static void main(String[] args) {
		//(1)dto �ҷ�����
		TestDto dto=new TestDto();
		//(2)setter�� �̿��ؼ� �̸� �ּ� ���� ����
		dto.setName("�̻��");
		dto.setAddr("����");
		dto.setAge(23);
		
		//(3)getter�� �̿��ؼ� ���
		System.out.println("�̸�:"+dto.getName());
		System.out.println("�ּ�:"+dto.getAddr());
		System.out.println("����:"+dto.getAge());
		
		//(4)toString �̿��Ͽ� ���
		System.out.println("toString()ȣ��");
		System.out.println(dto);
		
		TestDto dto2=new TestDto("��ȣ��","���ֵ�",45);
		System.out.println(dto2);
		
		TestDto dto3=new TestDto("������");
		System.out.println(dto3);
	}

}
