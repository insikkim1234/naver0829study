package day1109.test6.anno;

import org.springframework.stereotype.Component;

//(2) 어노테이션을 사용하기 위해 appcontext2.xml에 아래 패키지를 등록하고 
//<context:component-scan base-package="day1109.test6.anno"/>
//@component롬복을 이용하여 xml 에 자동으로 bean 등록-id가 클래스명이 아이디가 된다(첫글자 소문자:annoCanadaTire)
@Component  
public class AnnoCanadaTire implements AnnoTire {
	//(3)getTireName()을 컨스페로 만든 뒤 어노테이션 캐나다 타이어 리턴
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "어노테이션 캐나다 타이어";
	}

}
