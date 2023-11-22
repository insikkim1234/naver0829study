package mini.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.MemberDto;

//(16)MemberDao의 
//*기본 세팅*
//@repository로 클래스가 객체에 대해 저장,검색,업데이트,삭제 작업을 할 수있도록 환경 제공
//이때 자동으로 등록되는 bin의 이름은 맨 첫글자만 소문자인 낙타체로 작성된다
//
//SqlSession으로 sql과 연동
//
//nameSpace에 mini.dao.MemberDao.을 연결해서 사용할수 있도록 세팅
@Repository
public class MemberDao {
	@Autowired
	private SqlSession session;
	private String nameSpace="mini.dao.MemberDao.";
	
	//1)getTotalCount()작성
	//앞에서 작성한 id="totalCountOfMember"에 대하여 
	//nameSpace를 연결하여 sql과 연동 시켜주는 getTotalCount()작성 
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfMember");
	}
	
	//(29)MemberDao.java에 해당 부분 함수 insertMember작성
	public void insertMember(MemberDto dto)
	{
		session.insert(nameSpace+"insertMember", dto);
	}
	//(31)MemberDao.java에 해당 부분 함수 getSearchMember작성
		//1)인자로 field,word받음
	public List<MemberDto> getSearchMember(String field,String word)
	{
		//2)word가 null이거나 word의 길이가 0이면 word에 null 저장,
		//	그 외의 케이스에는 해당 word를 저장
		word=word==null || word.length()==0?null:word;
		
		//3)map방식으로 새로운 hashmap 생성
		Map<String, String> map=new HashMap<String, String>();
		//4)해당 맵은 키:searchfield 값:field
		//	       키:searchword  값:word
		//	형태로 저장 될것임
		map.put("searchfield", field);
		map.put("searchword", word);
		//5)해당 맵을 nameSpace와 (30)의 sql쿼리를 연결하여 반환한다
		return session.selectList(nameSpace+"selectAllMembers", map);
	}
	//(35)MemberDao에 해당 부분 함수searchIdCount작성
	//myid를 받아서 namespace와 연결해서 dao로 전송
	public int searchIdCount(String myid)
	{
		return session.selectOne(nameSpace+"searchIdCount", myid);
	}
//	(43)MemberDao에 deleteMember(num)작성
//	namespace에 (42)를 연결하여 해당 튜플을 삭제해 주는 역할
	public void deleteMember(int num)
	{
		session.delete(nameSpace+"deleteMember", num);
	}
//(48)MemberDao에 myid와 pass를 입력받아서 namespace와 연결시켜 map방식으로 전송하고 0이면false
//	1이면 true를 리턴해주는 쿼리 작성isLoginCheck()
	//1)인자로 myid(아이디),pass(비번)을 받음
	public boolean isLoginCheck(String myid,String pass)
	{
		//2)map방식으로 map 생성
		Map<String, String> map=new HashMap<String, String>();
		//3)map에 id와 pw넣기
		map.put("myid",myid);
		map.put("pass", pass);
		//4)namespace에 loginCheck붙여서 map과 함께 세션에 저장
		int n=session.selectOne(nameSpace+"loginCheck", map);
		//5)겹치는 갯수가 0이면 false, 그 외에는 모두 true리턴
		return n==0?false:true;
	}
//(50)	MemberDao에서 myid를 받아 namespace연결해서 전송하는 쿼리 getData(String myid)작성
	public MemberDto getData(String myid)
	{
		return session.selectOne(nameSpace+"selectDataById", myid);
	}
//(51)MemberDao에서  num을 받아서 namespace연결해서 전송하는 쿼리 getData(int num) 작성	
	public MemberDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectDataByNum", num);
	}
//(54)MemberDao에서 photo 와  num을 받아서 namespace연결해서 전송하는 쿼리 
//	updatePhoto(String photo,int num)	
	public void updatePhoto(String photo,int num)
	{
		//1)Map 방식으로 map매핑
		Map<String, Object> map=new HashMap<String, Object>();
		//2)map에 입력받은 photo,num저장
		map.put("photo", photo);
		map.put("num", num);
		//3)namespace와 (52)를 연결하여 해당 map을 전송해주는 쿼리 작성 
		session.update(nameSpace+"updatePhotoByNum", map);
	}

	/*
	 * (55)MemberDao에서 photo 와 myid를 받아서 namespace연결해서 전송하는 쿼리 updatePhoto(String
	 * photo,String myid)작성
	 */
	public void updatePhoto(String photo,String myid)
	{
		//1)Map 방식으로 map매핑
		Map<String, Object> map=new HashMap<String, Object>();
		//2)map에 입력받은 photo,myid저장
		map.put("photo", photo);
		map.put("myid", myid);
		//3)namespace와 (53)를 연결하여 해당 map을 전송해주는 쿼리 작성 
		session.update(nameSpace+"updatePhotoById", map);
	}
	
	
}
