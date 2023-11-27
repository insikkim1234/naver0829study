package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardAnswerDao;
import mini.dto.BoardAnswerDto;

//(130)BoardAnswerService에 기본 세팅
@Service
@AllArgsConstructor
public class BoardAnswerService {
	private BoardAnswerDao answerDao;

	/*
	 * (137)boardanswerservice에 insertAnswer(dto)호출 getAnswerBoard(int num) 호출
	 * deleteAnswer(int ansidx)호출
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
