package day1109.test6.anno;

import org.springframework.stereotype.Component;


//(4)component�Һ� �̿��ϰ� getTireName() �������̵�� �ڵ����� ����
@Component
public class AnnoKoreaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "�ѱ�Ÿ�̾�";
	}

}
