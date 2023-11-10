package day1108.test4;

import lombok.Getter;
import lombok.Setter;


//(1) 학생정보를 저장할 변수 name,blood,age 생성하기
//(2) setter/getter 생성
@Setter
@Getter
public class Student {
	private String name;
	private String blood;
	private int age;
}
