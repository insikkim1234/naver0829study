package day1108.test4;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


//(3) ��� ������ ������ ���� name,city,hobby ����
//(4) ��� ���ڸ� ������ ������ �����ϰ�(@AllArgsConstructor) 
//(5) getter ����
@AllArgsConstructor//���� ������ ����
@Getter
public class Sawon {
	private String name;
	private String city;
	private List<String> hobby;
}
