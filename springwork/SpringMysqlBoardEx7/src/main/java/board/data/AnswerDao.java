package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(17)AnswerDao에서 
//*기본세팅*
@Repository
public class AnswerDao {
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="board.data.AnswerDao.";
	
	//1)insertAnswer(AnswerDto dto) 만들기
	public void insertAnswer(AnswerDto dto)
	{
		session.insert(nameSpace+"insertAnswer",dto);
	}
	//2)getAnswers(int num) 만들기
	public List<AnswerDto> getAnswers(int num)
	{
		return session.selectList(nameSpace+"selectAnswerByNum", num);
	}
	//3)deleteAnswer(int idx) 만들기
	public void deleteAnswer(int idx)
	{
		session.delete(nameSpace+"deleteAnswer", idx);
	}
}








