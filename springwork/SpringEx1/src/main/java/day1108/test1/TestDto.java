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

//(1)위의 3개의 어노테이션을 하나의 어노테이션으로 표현 가능(getter/setter/toString)
@Data
//(2)기본 생성자
@AllArgsConstructor
//(3)모든 맴버를 인자로 받는 생성자
@NoArgsConstructor
//(4)@NonNull에 관해서만 필요한 인자만 받는 생성자
@RequiredArgsConstructor
public class TestDto {
	@NonNull
	private String name;
	private String addr;
	private int age;
}
