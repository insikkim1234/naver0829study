package mini.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
//(66)BoardDto.java에서 boarddb테이블에서 사용할 변수 선언
@Data
public class BoardDto {
	private int num;
	private String writer;
	private String myid;
	private String subject;
	private String content;
	private int readcount;
	private int regroup;
	private int restep;
	private int relevel;
	private List<String> photoNames;
	private Timestamp writeday;
}
