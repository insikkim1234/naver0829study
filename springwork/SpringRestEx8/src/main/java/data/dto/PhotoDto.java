package data.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
//(56)PhotoDto에 사용할 변수 생성 후 롬복으로 게터 세터 생성
@Data
public class PhotoDto {
	private int num;
	private String title;
	private String photo;
	private String photo80;
	private String photo150;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="Asia/Seoul")
	private Timestamp writeday;
}
