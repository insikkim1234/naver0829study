package mini.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardDao;
import mini.dto.BoardDto;

//(78)BoardService.java��  *�⺻����* 
@Service//bin�� �ڵ� ����ϴ� ��
@AllArgsConstructor
public class BoardService {
	
	private BoardDao boardDao;
//(79)BoardService.java�� getTotalCount()���� �� 
	//boardDao�� getTotalCount()����
	public int getTotalCount()
	{
		return boardDao.getTotalCount();
	}
//(80)BoardService.java��getList(int start,int perpage)����
	public List<BoardDto> getList(int start,int perpage)
	{
		//1)map����
		Map<String, Integer> map=new HashMap<String, Integer>();
		//2)map�� start,perpage�ֱ�
		map.put("start", start);
		map.put("perpage", perpage);
		//3)boardDao�� getList(map)����
		return boardDao.getList(map);
	}
//(81)	BoardService.java�� getMaxNum()����,
//	boardDao�� getMaxNum()����
	public int getMaxNum()
	{
		return boardDao.getMaxNum();
	}
//	(84)BoardService.java�� updateRestep(int regroup,int restep)�ۼ�
	public void updateRestep(int regroup,int restep)
	{
		//1)map �����
		Map<String, Integer> map=new HashMap<String, Integer>();
		//2)map�� regroup,restep����
		map.put("regroup", regroup);
		map.put("restep", restep);
		//3)dao�� updateRestep(map)�� ����
		boardDao.updateRestep(map);
	}
//(87)BoardService.java�� insertBoard(dto)���� �� ���� �ۼ�	
	public void insertBoard(BoardDto dto)
	{
		//1)num,regroup,restep,relevel�ۼ�
		int num=dto.getNum();//�����ϰ�� 0,����ϰ�� 0���� ū���� ����ִ�.
		int regroup=dto.getRegroup();//����� �� ���� regroup
		int restep=dto.getRestep();//����� �� ���� restep
		int relevel=dto.getRelevel();//����� �� ���� relevel
		
		//2)���� insert�Ǵ� ���� ������ ���
		if(num==0) {
			//1.�ִ��� �ѹ� ���ؼ� +1,restep,relevel�� 0���� �ʱ�ȭ
			regroup=boardDao.getMaxNum()+1;
			restep=0;
			relevel=0;
		//3)���� insert�Ǵ� ���� ����� ���
		}else {
			//1.���� �׷��� ���޹��� restep���� ū���� �ִ� �۵��� ��� +1�� ���ش�
			this.updateRestep(regroup, restep);
//			2.�׷��� ���� restep,relevel�� ���� 1�� ���Ѵ�(����� ��� �׷��� �״�� ����ϹǷ� regroup��
//					���� �ȱ��Ѵ�)
			restep=restep+1;
			relevel=relevel+1;
		}
		
		//4)���� ���� ���� regroup,restep,relevel�� �ٽ� dto�� ��´�
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//5)db insert
		boardDao.insertBoard(dto);
		
	}
//(90)BoardService.java�� updateReadCount(int num)�ۼ� �Է¹��� num�� ������ readcount�� ������Ʈ �Ѵ�
	public void updateReadCount(int num)
	{
		boardDao.updateReadCount(num);
	}
//(92)	BoardService.java�� getData(int num)�ۼ�
	public BoardDto getData(int num)
	{
		return boardDao.getData(num);
	}
//(118)boardservice.java�� updateboard�ۼ�	
	public void updateBoard(BoardDto dto)
	{
		boardDao.updateBoard(dto);
	}
//(121)boardservice.java�� deleteBoard�ۼ�	
	public void deleteBoard(int num)
	{
		boardDao.deleteBoard(num);
	}
}
