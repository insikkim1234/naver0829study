package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(8)BoardDao �⺻ ����,getTotalCount(),insertBoard(BoardDto dto) ����

//*�⺻ ����*
//@Repository: bin�� �ڵ� ������ִ� ������̼� 
@Repository 
public class BoardDao {
	
	
	//*�⺻ ����*
	//@Autowired : �������� ������������ ������̼�@Autowired���� �����ϰ� �Ѵ�
	//private SqlSession session:�ش� ������ ������ ���������̳� �������������� �ڵ����� ó��
	//private String nameSpace="board.data.BoardDao."; :xml���� ���� ���̵���� �տ� ���̱����� 
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="board.data.BoardDao.";
	
	//1)id=totalCountOfBoard �� ���� �Խñ� ��ü ������ ��ȯ�ϴ� �޼���
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	//2)id=insertBoard �� ���� simpleboard�� ������ �ִ� �ż���
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard", dto);
	}
	
	//(11)BoardDao ���� getAllDatas()����
	//1)id=selectAllBoard�� ���� �Խñ� ��ü�� ��ȯ�ϴ� �޼���
	public List<BoardDto> getAllDatas()
	{
		return session.selectList(nameSpace+"selectAllBoard");
	}
	// (15) 
	public void updateReadcount(int num)
	{
		session.update(nameSpace+"updateReadcount", num);
	}
	
	public BoardDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectOneData", num);
	}
	
	public void deleteBoard(int num)
	{
		session.delete(nameSpace+"deleteBoard", num);
	}
	
	public void updateBoard(BoardDto dto)
	{
		session.update(nameSpace+"updateBoard",dto);
	}
			
}
