package mini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
//(70)BoardFileDao.java ���� �� �⺻ ����
@Repository
public class BoardFileDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardFileDao.";
//(95)BoardFileDao�� insertPhoto(BoardDto dto)�� �ۼ��Ͽ� 
	//namespace�� id="insertPhotoOfFile"�� �����Ͽ� ���ǿ� ����	
	public void insertPhoto(BoardFileDto dto)
	{
		session.insert(nameSpace+"insertPhotoOfFile", dto);
	}
//(98)BoardFileDao�� getPhotoByNum(int num)�ۼ��Ͽ�
	//namespace�� id="selectAllPhotoByNum"�� �����Ͽ� ���ǿ� ����	
	public List<String> getPhotoByNum(int num)
	{
		return session.selectList(nameSpace+"selectAllPhotoByNum", num);
	}
//(111)boardfiledao���� namespace�� selectAllDataByNum �����Ͽ� num�Է¹ް� ����	
	public List<BoardFileDto> getFileDataByNum(int num)
	{
		return session.selectList(nameSpace+"selectAllDataByNum", num);
	}
//(114)boardfiledao���� namespace�� d�տ��� �ۼ��� deletePhotoByIdx �ٿ��� ���ǿ� ����	
	public void deletePhoto(int idx)
	{
		session.delete(nameSpace+"deletePhotoByIdx", idx);
	}
	
}
