package mini.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(70)BoardFileDao.java ���� �� �⺻ ����
@Repository
public class BoardFileDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardFileDao.";
}
