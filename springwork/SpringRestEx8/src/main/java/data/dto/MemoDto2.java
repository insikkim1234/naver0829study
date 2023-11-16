package data.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//(9)MemoDto2에 MemoDto의 Timestamp를 String으로만 바꿔서 dto 작성
//(8번에서 writeday에 문자를 줬으므로)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto2 {
	private int num;
	private String nickname;
	private String photo;
	private String memo;
	private int likes;
	private String writeday;
}
