package mini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.BoardAnswerDto;

//(129)BoardAnswerDao에 기본 세팅
@Repository
public class BoardAnswerDao {
	@Autowired
	private SqlSession session;
	/*
	 * (136)BoardAnswerDao에 insertAnswer(dto)만든 후 네임스페이스와 연결 시켜 insert
	 * getAnswerBoard(int num) 만든 후 네임스페이스와 연결 스켜 세션 반환 deleteAnswer(int ansidx)만든 후
	 * 네임스페이스와 연결 시켜 delete
	 */
	private String nameSpace="mini.dao.BoardAnswerDao.";
	
	public void insertAnswer(BoardAnswerDto dto)
	{
		session.insert(nameSpace+"insertBoardAnswer", dto);
	}
	
	public List<BoardAnswerDto> getAnswerBoard(int num)
	{
		return session.selectList(nameSpace+"selectAnswerOfNum", num);
	}
	
	public void deleteAnswer(int ansidx)
	{
		session.delete(nameSpace+"deleteAnswer", ansidx);
	}
}
