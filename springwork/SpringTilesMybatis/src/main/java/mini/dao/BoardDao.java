package mini.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(69)BoardDao.java ���� �� �⺻ ����
@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardDao.";
}
