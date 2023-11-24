package mini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
//(70)BoardFileDao.java 생성 후 기본 세팅
@Repository
public class BoardFileDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardFileDao.";
//(95)BoardFileDao에 insertPhoto(BoardDto dto)를 작성하여 
	//namespace에 id="insertPhotoOfFile"를 연결하여 세션에 전송	
	public void insertPhoto(BoardFileDto dto)
	{
		session.insert(nameSpace+"insertPhotoOfFile", dto);
	}
//(98)BoardFileDao에 getPhotoByNum(int num)작성하여
	//namespace에 id="selectAllPhotoByNum"를 연결하여 세션에 전송	
	public List<String> getPhotoByNum(int num)
	{
		return session.selectList(nameSpace+"selectAllPhotoByNum", num);
	}
//(111)boardfiledao에서 namespace에 selectAllDataByNum 연결하여 num입력받고 전송	
	public List<BoardFileDto> getFileDataByNum(int num)
	{
		return session.selectList(nameSpace+"selectAllDataByNum", num);
	}
//(114)boardfiledao에서 namespace에 d앞에서 작성한 deletePhotoByIdx 붙여서 세션에 저장	
	public void deletePhoto(int idx)
	{
		session.delete(nameSpace+"deletePhotoByIdx", idx);
	}
	
}
