package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardAnswerDao;
import mini.dto.BoardAnswerDto;

//(130)BoardAnswerService�� �⺻ ����
@Service
@AllArgsConstructor
public class BoardAnswerService {
	private BoardAnswerDao answerDao;

	/*
	 * (137)boardanswerservice�� insertAnswer(dto)ȣ�� getAnswerBoard(int num) ȣ��
	 * deleteAnswer(int ansidx)ȣ��
	 */
	public void insertAnswer(BoardAnswerDto dto)
	{
		answerDao.insertAnswer(dto);
	}
	
	public List<BoardAnswerDto> getAnswerBoard(int num)
	{
		return answerDao.getAnswerBoard(num);
	}
	
	public void deleteAnswer(int ansidx)
	{
		answerDao.deleteAnswer(ansidx);
	}
}
