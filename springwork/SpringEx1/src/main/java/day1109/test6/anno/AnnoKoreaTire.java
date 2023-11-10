package day1109.test6.anno;

import org.springframework.stereotype.Component;


//(4)component롬복 이용하고 getTireName() 오버라이드로 자동으로 생성
@Component
public class AnnoKoreaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "한국타이어";
	}

}
