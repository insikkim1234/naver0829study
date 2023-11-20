package data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.dto.PhotoDto;
//(59)PhotoDao�� �⺻����
@Repository
public class PhotoDao {
	
	@Autowired
	private  SqlSession session;
	private String nameSpace="data.dao.PhotoDao.";
//(61)PhotoDao�� id="insertPhoto"�� ����insertPhoto(dto)�����ؼ�  dao�� insert���ִ� ���� �ۼ�	
	public void insertPhoto(PhotoDto dto)
	{
		session.insert(nameSpace+"insertPhoto", dto);
	}
//(63)PhotoDao�� id="selectAllPhotos"�� ���� getAllPhotos()���� �� ������ִ� �Լ� �ۼ�	
	public List<PhotoDto> getAllPhotos()
	{
		return session.selectList(nameSpace+"selectAllPhotos");
	}
///(65)PhotoDao�� id="deletePhoto"�� ����deletePhoto(int num)����	
	public void deletePhoto(int num)
	{
		session.delete(nameSpace+"deletePhoto", num);
	}
}
