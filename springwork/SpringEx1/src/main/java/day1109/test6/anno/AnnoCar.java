package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//(5)id를 mycar로 바꾸기
//@Component  //id:annoCar
@Component("mycar") // id 가 mycar 가 된다
public class AnnoCar {
	
	
	//(6)@autowired하면 매칭 가능한 클래스가 2개이므로 에러 발생하기 때문에
	//@resource로 annoKoreaTire로 연결 해준다
	@Autowired
	@Resource(name = "annoKoreaTire")
	//(7)인터페이스 생성
	AnnoTire annoTire;
	//(8) 내 차의 타이어가 어떤 타이언지 생성해주는 함수 실행
	public void myCarInfo()
	{
		System.out.println("내 차의 타이어는 "+annoTire.getTireName()+" 입니다");
	}

}