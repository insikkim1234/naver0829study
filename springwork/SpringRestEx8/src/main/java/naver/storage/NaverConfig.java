package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;


//(43) @Configuration 롬복 붙이기,세터게터 롬복 붙이기
//사용할 변수 만들기
//@value 롬복으로 각 변수마다 강사님 세팅 복붙
@Configuration
@Setter
@Getter
public class NaverConfig {
	
	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	@Value("kr-standard")
	private String regionName;
	
	@Value("8yt6c0uo9is9HLAN1BZH")
	private String accessKey;
	
	@Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0")
	private String secretKey;

}
