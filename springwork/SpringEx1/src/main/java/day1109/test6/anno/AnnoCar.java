package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//(5)id�� mycar�� �ٲٱ�
//@Component  //id:annoCar
@Component("mycar") // id �� mycar �� �ȴ�
public class AnnoCar {
	
	
	//(6)@autowired�ϸ� ��Ī ������ Ŭ������ 2���̹Ƿ� ���� �߻��ϱ� ������
	//@resource�� annoKoreaTire�� ���� ���ش�
	@Autowired
	@Resource(name = "annoKoreaTire")
	//(7)�������̽� ����
	AnnoTire annoTire;
	//(8) �� ���� Ÿ�̾ � Ÿ�̾��� �������ִ� �Լ� ����
	public void myCarInfo()
	{
		System.out.println("�� ���� Ÿ�̾�� "+annoTire.getTireName()+" �Դϴ�");
	}

}