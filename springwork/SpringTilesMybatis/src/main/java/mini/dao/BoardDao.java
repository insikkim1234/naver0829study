package mini.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(69)BoardDao.java 생성 후 기본 세팅

import mini.dto.BoardDto;
@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardDao.";
	
	//(73)BoardDao에namespace와 totalCountOfBoard를 붙여주고 세션으로 전송해 주는 쿼리 작성
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	//(75)BoardDao에 namespace와 selectPagingOfBoard를 붙여주고 세션으로 전송해 주는 쿼리 작성
	public List<BoardDto> getList(Map<String, Integer> map)
	{
		
		return session.selectList(nameSpace+"selectPagingOfBoard",map);
	}
	//(77)BoardDao에 namespace와 연결해서selectMaxNumOfBoard를 붙여주고 세션으로 전송해 주는 getMaxNum()작성
	public int getMaxNum()
	{
		return session.selectOne(nameSpace+"selectMaxNumOfBoard");
	}
	//(83)BoardDao.java에 updateRestep함수 작성 nameSpace에 updateRestepOfBoard 붙여서 세션으로 전송
	public void updateRestep(Map<String, Integer> map)
	{
		session.update(nameSpace+"updateRestepOfBoard",map);
	}
	//(86)BoardDao.java에서 insertBoard(dto)받아서 namespace에 연결 후 세션에 업데이트
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard", dto);
	}
	//(89)boarddao.java에 updateReadCount(int num) 작성 namespace에 id 붙여서 세션에 저장
	public void updateReadCount(int num)
	{
		session.update(nameSpace+"updateReadCountOfBoard", num);
	}
	//(91)boarddao.java에 getData(int num) 작성하여 namespace 에selectDataByNum붙여서 세션으로 전송
	public BoardDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectDataByNum", num);
	}
	//(117)boarddao에서 namespace에 연결하여 dto를 입력받아 세션에 전송
	public void updateBoard(BoardDto dto)
	{
		session.update(nameSpace+"updateBoard",dto);
	}
	//(120)boarddao에서 namespace에 연결하여 num을 입력받은 튜플 삭제 명령 전송
	public void deleteBoard(int num)
	{
		session.delete(nameSpace+"deleteBoard", num);
	}
	
	
}





























