package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(8)BoardDao 기본 세팅,getTotalCount(),insertBoard(BoardDto dto) 생성

//*기본 세팅*
//@Repository: bin을 자동 등록해주는 어노테이션 
@Repository 
public class BoardDao {
	
	
	//*기본 세팅*
	//@Autowired : 세터주입 생성자주입을 어노테이션@Autowired으로 가능하게 한다
	//private SqlSession session:해당 구문이 있으면 세터주입이나 생성자주입으로 자동으로 처리
	//private String nameSpace="board.data.BoardDao."; :xml에서 만든 아이디들의 앞에 붙이기위함 
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="board.data.BoardDao.";
	
	//1)id=totalCountOfBoard 에 대해 게시글 전체 갯수를 반환하는 메서드
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	//2)id=insertBoard 에 대해 simpleboard에 삽입해 주는 매서드
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard", dto);
	}
	
	//(11)BoardDao 에서 getAllDatas()생성
	//1)id=selectAllBoard에 대해 게시글 전체를 반환하는 메서드
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
