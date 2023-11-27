package mini.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


//(127)BoardAnswerDto.java 에 board_answer 테이블 에서 사용할 컬럼값 추가

@Data
public class BoardAnswerDto {
	private int ansidx;
	private int num;
	private String ansname;
	private String ansid;
	private String ansphoto;
	private String ansmsg;
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
	private Timestamp writeday;
}
