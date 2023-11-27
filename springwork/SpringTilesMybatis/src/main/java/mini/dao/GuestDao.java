package mini.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.GuestDto;
//(147)guestdao�� �⺻ ����
@Repository
public class GuestDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.GuestDao.";

//(157)GuestDao�� insertGuest(GuestDto dto),getAllGuest(),deleteGuest(int guest_num) ��
	//���ӽ����̽��� �����Ͽ� �������� ����
	public void insertGuest(GuestDto dto)
	{
		session.insert(nameSpace+"insertGuest", dto);
	}
	
	public List<GuestDto> getAllGuest()
	{
		return session.selectList(nameSpace+"selectAllGuest");
	}
	
	public void deleteGuest(int guest_num)
	{
		session.delete(nameSpace+"deleteGuest", guest_num);
	}
}
