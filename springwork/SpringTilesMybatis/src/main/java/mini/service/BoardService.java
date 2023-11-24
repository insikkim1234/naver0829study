package mini.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardDao;
import mini.dto.BoardDto;

//(78)BoardService.java에  *기본세팅* 
@Service//bin에 자동 등록하는 것
@AllArgsConstructor
public class BoardService {
	
	private BoardDao boardDao;
//(79)BoardService.java에 getTotalCount()생성 후 
	//boardDao의 getTotalCount()실행
	public int getTotalCount()
	{
		return boardDao.getTotalCount();
	}
//(80)BoardService.java에getList(int start,int perpage)생성
	public List<BoardDto> getList(int start,int perpage)
	{
		//1)map생성
		Map<String, Integer> map=new HashMap<String, Integer>();
		//2)map에 start,perpage넣기
		map.put("start", start);
		map.put("perpage", perpage);
		//3)boardDao의 getList(map)실행
		return boardDao.getList(map);
	}
//(81)	BoardService.java에 getMaxNum()생성,
//	boardDao의 getMaxNum()실행
	public int getMaxNum()
	{
		return boardDao.getMaxNum();
	}
//	(84)BoardService.java에 updateRestep(int regroup,int restep)작성
	public void updateRestep(int regroup,int restep)
	{
		//1)map 만들기
		Map<String, Integer> map=new HashMap<String, Integer>();
		//2)map에 regroup,restep저장
		map.put("regroup", regroup);
		map.put("restep", restep);
		//3)dao에 updateRestep(map)을 전성
		boardDao.updateRestep(map);
	}
//(87)BoardService.java에 insertBoard(dto)복붙 후 절차 작성	
	public void insertBoard(BoardDto dto)
	{
		//1)num,regroup,restep,relevel작성
		int num=dto.getNum();//새글일경우 0,답글일경우 0보다 큰값이 들어있다.
		int regroup=dto.getRegroup();//답글을 단 글의 regroup
		int restep=dto.getRestep();//답글을 단 글의 restep
		int relevel=dto.getRelevel();//답글을 단 글의 relevel
		
		//2)만약 insert되는 글이 새글의 경우
		if(num==0) {
			//1.최대의 넘버 구해서 +1,restep,relevel은 0으로 초기화
			regroup=boardDao.getMaxNum()+1;
			restep=0;
			relevel=0;
		//3)만약 insert되는 글이 답글의 경우
		}else {
			//1.같은 그룹중 전달받은 restep보다 큰값이 있는 글들은 모두 +1을 해준다
			this.updateRestep(regroup, restep);
//			2.그러고 나서 restep,relevel에 각각 1씩 더한다(답글인 경우 그룹은 그대로 사용하므로 regroup은
//					따로 안구한다)
			restep=restep+1;
			relevel=relevel+1;
		}
		
		//4)각각 새로 구한 regroup,restep,relevel을 다시 dto에 담는다
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//5)db insert
		boardDao.insertBoard(dto);
		
	}
//(90)BoardService.java에 updateReadCount(int num)작성 입력받은 num과 동일한 readcount를 업데이트 한다
	public void updateReadCount(int num)
	{
		boardDao.updateReadCount(num);
	}
//(92)	BoardService.java에 getData(int num)작성
	public BoardDto getData(int num)
	{
		return boardDao.getData(num);
	}
//(118)boardservice.java에 updateboard작성	
	public void updateBoard(BoardDto dto)
	{
		boardDao.updateBoard(dto);
	}
//(121)boardservice.java에 deleteBoard작성	
	public void deleteBoard(int num)
	{
		boardDao.deleteBoard(num);
	}
}
