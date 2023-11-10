package study.day1109.mvc3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//(14)@data�� getter/setter����
//	  @NoArgsConstructor���� �� ������ ����
//	  @AllArgsConstructor���� ��� ������ �޴� ������ ����
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
	//(15)shop�� ������ �ޱ� ���ؼ� sang,photo,price ���� ���� 
	//(16)�� home.jsp�� �̵��ؼ� Ȩ�������� �����Ű�� ��� ���� ���� 
	private String sang;
	private String photo;
	private int price;
	
}
