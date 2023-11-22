package mini.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//(70)BoardFileDao.java 생성 후 기본 세팅
@Repository
public class BoardFileDao {
	@Autowired
	private SqlSession session;
	
	private String nameSpace="mini.dao.BoardFileDao.";
}
