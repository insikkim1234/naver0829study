package day1108.test4;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


//(3) 사원 정보를 저장할 변수 name,city,hobby 생성
//(4) 모든 인자를 포함한 생성자 생성하고(@AllArgsConstructor) 
//(5) getter 생성
@AllArgsConstructor//전부 생성자 주입
@Getter
public class Sawon {
	private String name;
	private String city;
	private List<String> hobby;
}
