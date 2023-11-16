package data.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//(1)MemoDto���� ����� ���� �����ϱ�
@Data
//(2)memodto.java�� 
//@NoArgsConstructor
//@AllArgsConstructor�߰�
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	private int num;
	private String nickname;
	private String photo;
	private String memo;
	private int likes;
	//(27)memodto.java��
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Seoul") �Է��Ͽ�
	//��¥�� ������ ��������
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Seoul")
	private Timestamp writeday;
}
