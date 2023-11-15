package board.data;

import java.sql.Timestamp;

import lombok.Data;
//(1)BoardDto에 사용할 변수를 선언하고 @Data롬복으로 setter/getter선언
@Data
public class BoardDto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String photo;
	private int readcount;
	private Timestamp writeday;
}
