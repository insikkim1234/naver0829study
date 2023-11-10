package day1109.test6.anno;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

//(9)mycar2��� ���̵� �ο��ϰ� ������ ���Թ������ �ڵ� ����
@Component("mycar2")
@AllArgsConstructor 
public class AnnoCar2 {
	//(10)�ڸ��� Ÿ�̾�� ĳ���� Ÿ�̾� ����
	AnnoKoreaTire koreaTire;
	AnnoCanadaTire canadaTire;
	//(11)koreaTire canadaTire��� ���ִ� myCarInfo�Լ� ����
	public void myCarInfo()
	{
		System.out.println("�� ���� Ÿ�̾�� "+koreaTire.getTireName()+" �Դϴ�");
		System.out.println("�ܿ�� Ÿ�̾�� "+canadaTire.getTireName()+" �Դϴ�");
	}
}
