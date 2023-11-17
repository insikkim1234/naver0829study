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
//(29)memodao에 deleteMemo()작성(id="deleteMemo"에 대하여 dao와 연결해주는 쿼리)

	public void deleteMemo(int num)
	{
		session.delete(nameSpace+"deleteMemo", num);
	}
//(33)MemoDao에 updateLikes(num)작성(id="updateLikesByNum"에 대하여 dao와 연결해주는 쿼리)	
	public void updateLikes(int num)
	{
		session.update(nameSpace+"updateLikesByNum", num);
	}
//(35)memodao에 getCountLikes(int num)작성(id="countLikes"에 대하여 dao와 연결해주는 쿼리)	
	public int getCountLikes(int num)
	{
		return session.selectOne(nameSpace+"countLikes", num);
	}
}


















