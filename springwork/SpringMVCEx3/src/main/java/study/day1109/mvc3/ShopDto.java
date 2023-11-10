package study.day1109.mvc3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//(14)@data로 getter/setter생성
//	  @NoArgsConstructor으로 빈 생성자 생성
//	  @AllArgsConstructor으로 모든 변수를 받는 생성자 생성
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
	//(15)shop의 정보를 받기 위해서 sang,photo,price 변수 생성 
	//(16)은 home.jsp로 이동해서 홈페이지를 실행시키면 어떻게 뜰지 정함 
	private String sang;
	private String photo;
	private int price;
	
}
