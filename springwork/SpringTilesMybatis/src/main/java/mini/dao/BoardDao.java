package mini.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(69)BoardDao.java ���� �� �⺻ ����

import mini.dto.BoardDto;
@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardDao.";
	
	//(73)BoardDao��namespace�� totalCountOfBoard�� �ٿ��ְ� �������� ������ �ִ� ���� �ۼ�
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	//(75)BoardDao�� namespace�� selectPagingOfBoard�� �ٿ��ְ� �������� ������ �ִ� ���� �ۼ�
	public List<BoardDto> getList(Map<String, Integer> map)
	{
		
		return session.selectList(nameSpace+"selectPagingOfBoard",map);
	}
	//(77)BoardDao�� namespace�� �����ؼ�selectMaxNumOfBoard�� �ٿ��ְ� �������� ������ �ִ� getMaxNum()�ۼ�
	public int getMaxNum()
	{
		return session.selectOne(nameSpace+"selectMaxNumOfBoard");
	}
	//(83)BoardDao.java�� updateRestep�Լ� �ۼ� nameSpace�� updateRestepOfBoard �ٿ��� �������� ����
	public void updateRestep(Map<String, Integer> map)
	{
		session.update(nameSpace+"updateRestepOfBoard",map);
	}
	//(86)BoardDao.java���� insertBoard(dto)�޾Ƽ� namespace�� ���� �� ���ǿ� ������Ʈ
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard", dto);
	}
	//(89)boarddao.java�� updateReadCount(int num) �ۼ� namespace�� id �ٿ��� ���ǿ� ����
	public void updateReadCount(int num)
	{
		session.update(nameSpace+"updateReadCountOfBoard", num);
	}
	//(91)boarddao.java�� getData(int num) �ۼ��Ͽ� namespace ��selectDataByNum�ٿ��� �������� ����
	public BoardDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectDataByNum", num);
	}
	//(117)boarddao���� namespace�� �����Ͽ� dto�� �Է¹޾� ���ǿ� ����
	public void updateBoard(BoardDto dto)
	{
		session.update(nameSpace+"updateBoard",dto);
	}
	//(120)boarddao���� namespace�� �����Ͽ� num�� �Է¹��� Ʃ�� ���� ��� ����
	public void deleteBoard(int num)
	{
		session.delete(nameSpace+"deleteBoard", num);
	}
	
	
}





























