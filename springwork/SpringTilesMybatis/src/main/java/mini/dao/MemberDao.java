package mini.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mini.dto.MemberDto;

//(16)MemberDao�� 
//*�⺻ ����*
//@repository�� Ŭ������ ��ü�� ���� ����,�˻�,������Ʈ,���� �۾��� �� ���ֵ��� ȯ�� ����
//�̶� �ڵ����� ��ϵǴ� bin�� �̸��� �� ù���ڸ� �ҹ����� ��Ÿü�� �ۼ��ȴ�
//
//SqlSession���� sql�� ����
//
//nameSpace�� mini.dao.MemberDao.�� �����ؼ� ����Ҽ� �ֵ��� ����
@Repository
public class MemberDao {
	@Autowired
	private SqlSession session;
	private String nameSpace="mini.dao.MemberDao.";
	
	//1)getTotalCount()�ۼ�
	//�տ��� �ۼ��� id="totalCountOfMember"�� ���Ͽ� 
	//nameSpace�� �����Ͽ� sql�� ���� �����ִ� getTotalCount()�ۼ� 
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfMember");
	}
	
	//(29)MemberDao.java�� �ش� �κ� �Լ� insertMember�ۼ�
	public void insertMember(MemberDto dto)
	{
		session.insert(nameSpace+"insertMember", dto);
	}
	//(31)MemberDao.java�� �ش� �κ� �Լ� getSearchMember�ۼ�
		//1)���ڷ� field,word����
	public List<MemberDto> getSearchMember(String field,String word)
	{
		//2)word�� null�̰ų� word�� ���̰� 0�̸� word�� null ����,
		//	�� ���� ���̽����� �ش� word�� ����
		word=word==null || word.length()==0?null:word;
		
		//3)map������� ���ο� hashmap ����
		Map<String, String> map=new HashMap<String, String>();
		//4)�ش� ���� Ű:searchfield ��:field
		//	       Ű:searchword  ��:word
		//	���·� ���� �ɰ���
		map.put("searchfield", field);
		map.put("searchword", word);
		//5)�ش� ���� nameSpace�� (30)�� sql������ �����Ͽ� ��ȯ�Ѵ�
		return session.selectList(nameSpace+"selectAllMembers", map);
	}
	//(35)MemberDao�� �ش� �κ� �Լ�searchIdCount�ۼ�
	//myid�� �޾Ƽ� namespace�� �����ؼ� dao�� ����
	public int searchIdCount(String myid)
	{
		return session.selectOne(nameSpace+"searchIdCount", myid);
	}
//	(43)MemberDao�� deleteMember(num)�ۼ�
//	namespace�� (42)�� �����Ͽ� �ش� Ʃ���� ������ �ִ� ����
	public void deleteMember(int num)
	{
		session.delete(nameSpace+"deleteMember", num);
	}
}
