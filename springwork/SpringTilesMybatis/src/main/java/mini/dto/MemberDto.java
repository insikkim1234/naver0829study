package mini.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
//(14)MemberDto 에 사용할 변수 생성하고 data롬복을 이용해 getter/setter생성
@Data
public class MemberDto {
	private int num;
	private String name;
	private String myid;
	private String pass;
	private String photo;
	private String hp;
	private String email;
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm",timezone="Asia/Seoul")
	private Timestamp gaipday;
}
