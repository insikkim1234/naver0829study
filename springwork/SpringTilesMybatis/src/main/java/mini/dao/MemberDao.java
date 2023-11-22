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
//(48)MemberDao�� myid�� pass�� �Է¹޾Ƽ� namespace�� ������� map������� �����ϰ� 0�̸�false
//	1�̸� true�� �������ִ� ���� �ۼ�isLoginCheck()
	//1)���ڷ� myid(���̵�),pass(���)�� ����
	public boolean isLoginCheck(String myid,String pass)
	{
		//2)map������� map ����
		Map<String, String> map=new HashMap<String, String>();
		//3)map�� id�� pw�ֱ�
		map.put("myid",myid);
		map.put("pass", pass);
		//4)namespace�� loginCheck�ٿ��� map�� �Բ� ���ǿ� ����
		int n=session.selectOne(nameSpace+"loginCheck", map);
		//5)��ġ�� ������ 0�̸� false, �� �ܿ��� ��� true����
		return n==0?false:true;
	}
//(50)	MemberDao���� myid�� �޾� namespace�����ؼ� �����ϴ� ���� getData(String myid)�ۼ�
	public MemberDto getData(String myid)
	{
		return session.selectOne(nameSpace+"selectDataById", myid);
	}
//(51)MemberDao����  num�� �޾Ƽ� namespace�����ؼ� �����ϴ� ���� getData(int num) �ۼ�	
	public MemberDto getData(int num)
	{
		return session.selectOne(nameSpace+"selectDataByNum", num);
	}
//(54)MemberDao���� photo ��  num�� �޾Ƽ� namespace�����ؼ� �����ϴ� ���� 
//	updatePhoto(String photo,int num)	
	public void updatePhoto(String photo,int num)
	{
		//1)Map ������� map����
		Map<String, Object> map=new HashMap<String, Object>();
		//2)map�� �Է¹��� photo,num����
		map.put("photo", photo);
		map.put("num", num);
		//3)namespace�� (52)�� �����Ͽ� �ش� map�� �������ִ� ���� �ۼ� 
		session.update(nameSpace+"updatePhotoByNum", map);
	}

	/*
	 * (55)MemberDao���� photo �� myid�� �޾Ƽ� namespace�����ؼ� �����ϴ� ���� updatePhoto(String
	 * photo,String myid)�ۼ�
	 */
	public void updatePhoto(String photo,String myid)
	{
		//1)Map ������� map����
		Map<String, Object> map=new HashMap<String, Object>();
		//2)map�� �Է¹��� photo,myid����
		map.put("photo", photo);
		map.put("myid", myid);
		//3)namespace�� (53)�� �����Ͽ� �ش� map�� �������ִ� ���� �ۼ� 
		session.update(nameSpace+"updatePhotoById", map);
	}
	
	
}
