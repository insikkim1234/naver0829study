package mini.dto;

import lombok.Data;
//(67)BoardFileDto.java에서 board_file 테이블에서 사용할 변수 선언
@Data
public class BoardFileDto {
	private int idx;
	private int num;
	private String photoName;
}
