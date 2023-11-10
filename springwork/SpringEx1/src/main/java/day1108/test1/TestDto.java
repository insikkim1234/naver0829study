package day1108.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString

//(1)���� 3���� ������̼��� �ϳ��� ������̼����� ǥ�� ����(getter/setter/toString)
@Data
//(2)�⺻ ������
@AllArgsConstructor
//(3)��� �ɹ��� ���ڷ� �޴� ������
@NoArgsConstructor
//(4)@NonNull�� ���ؼ��� �ʿ��� ���ڸ� �޴� ������
@RequiredArgsConstructor
public class TestDto {
	@NonNull
	private String name;
	private String addr;
	private int age;
}
