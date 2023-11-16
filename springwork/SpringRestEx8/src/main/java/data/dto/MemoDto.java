package data.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//(1)MemoDto에서 사용할 변수 저장하기
@Data
//(2)memodto.java에 
//@NoArgsConstructor
//@AllArgsConstructor추가
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	private int num;
	private String nickname;
	private String photo;
	private String memo;
	private int likes;
	//(27)memodto.java에
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Seoul") 입력하여
	//날짜가 제도로 나오게함
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Seoul")
	private Timestamp writeday;
}
