package day1109.test6.anno;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

//(9)mycar2라는 아이디를 부여하고 생성자 주입방식으로 자동 주입
@Component("mycar2")
@AllArgsConstructor 
public class AnnoCar2 {
	//(10)코리아 타이어와 캐나다 타이어 생성
	AnnoKoreaTire koreaTire;
	AnnoCanadaTire canadaTire;
	//(11)koreaTire canadaTire출력 해주는 myCarInfo함수 생성
	public void myCarInfo()
	{
		System.out.println("내 차의 타이어는 "+koreaTire.getTireName()+" 입니다");
		System.out.println("겨울용 타이어는 "+canadaTire.getTireName()+" 입니다");
	}
}
