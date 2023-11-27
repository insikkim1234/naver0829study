package mini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.BoardAnswerDto;

//(129)BoardAnswerDao�� �⺻ ����
@Repository
public class BoardAnswerDao {
	@Autowired
	private SqlSession session;
	/*
	 * (136)BoardAnswerDao�� insertAnswer(dto)���� �� ���ӽ����̽��� ���� ���� insert
	 * getAnswerBoard(int num) ���� �� ���ӽ����̽��� ���� ���� ���� ��ȯ deleteAnswer(int ansidx)���� ��
	 * ���ӽ����̽��� ���� ���� delete
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
