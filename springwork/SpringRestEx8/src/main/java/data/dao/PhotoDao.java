package data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.dto.PhotoDto;
//(59)PhotoDao의 기본세팅
@Repository
public class PhotoDao {
	
	@Autowired
	private  SqlSession session;
	private String nameSpace="data.dao.PhotoDao.";
//(61)PhotoDao에 id="insertPhoto"에 대한insertPhoto(dto)생성해서  dao에 insert해주는 쿼리 작성	
	public void insertPhoto(PhotoDto dto)
	{
		session.insert(nameSpace+"insertPhoto", dto);
	}
//(63)PhotoDao에 id="selectAllPhotos"에 대한 getAllPhotos()생성 후 출력해주는 함수 작성	
	public List<PhotoDto> getAllPhotos()
	{
		return session.selectList(nameSpace+"selectAllPhotos");
	}
///(65)PhotoDao에 id="deletePhoto"에 대한deletePhoto(int num)생성	
	public void deletePhoto(int num)
	{
		session.delete(nameSpace+"deletePhoto", num);
	}
}
