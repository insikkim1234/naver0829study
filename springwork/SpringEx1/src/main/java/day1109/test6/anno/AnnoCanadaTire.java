package day1109.test6.anno;

import org.springframework.stereotype.Component;

//(2) ������̼��� ����ϱ� ���� appcontext2.xml�� �Ʒ� ��Ű���� ����ϰ� 
//<context:component-scan base-package="day1109.test6.anno"/>
//@component�Һ��� �̿��Ͽ� xml �� �ڵ����� bean ���-id�� Ŭ�������� ���̵� �ȴ�(ù���� �ҹ���:annoCanadaTire)
@Component  
public class AnnoCanadaTire implements AnnoTire {
	//(3)getTireName()�� ������� ���� �� ������̼� ĳ���� Ÿ�̾� ����
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "������̼� ĳ���� Ÿ�̾�";
	}

}
