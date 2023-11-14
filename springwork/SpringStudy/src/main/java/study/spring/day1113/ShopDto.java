package study.spring.day1113;

import lombok.Data;

//(18)dto에 sang,photo,color,su,dan 생성하고 게터/세터 생성
@Data
public class ShopDto {
	private String sang;
	private String photo;
	private String color;
	private int su;
	private int dan;
}
