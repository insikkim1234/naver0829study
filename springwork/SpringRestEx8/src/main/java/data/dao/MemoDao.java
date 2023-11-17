package data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.dto.MemoDto;
//(2)MemoDao에서
//*기본세팅*
//@Repository
//@Autowired
//private SqlSession session;
@Repository
public class MemoDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="data.dao.MemoDao.";
//(17)MemoDao.java에 insertMemo()작성	
	public void insertMemo(MemoDto dto)
	{
		session.insert(nameSpace+"insertMemo",dto);
	}
//(19)MemoDao.java에 getAllMemos()작성
	public List<MemoDto> getAllMemos()
	{
		return session.selectList(nameSpace+"selectAllMemos");
	}
	
	public void deleteMemo(int num)
	{
		session.delete(nameSpace+"deleteMemo", num);
	}
	
	public void updateLikes(int num)
	{
		session.update(nameSpace+"updateLikesByNum", num);
	}
	public int getCountLikes(int num)
	{
		return session.selectOne(nameSpace+"countLikes", num);
	}
}


















