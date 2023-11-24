package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardFileDao;
import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
//(93) BoardFileService.java�� �⺻ ����
@Service
@AllArgsConstructor
public class BoardFileService {
	
	private BoardFileDao boardFileDao;
//(96)BoardFileService�� insertPhoto(BoardFileDto dto) �ۼ� �� dto �Է¹޾� ����	
	public void insertPhoto(BoardFileDto dto)
	{
		boardFileDao.insertPhoto(dto);
	}
//(99)BoardFileService�� getPhotoByNum(int num) �ۼ� �� num �Է¹޾� ����	
	public List<String> getPhotoByNum(int num)
	{
		return boardFileDao.getPhotoByNum(num);
	}
//(112)boardfileservice���� boardfiledao�� getFileDataByNum�޾� ����	
	public List<BoardFileDto> getFileDataByNum(int num)
	{
		return boardFileDao.getFileDataByNum(num);
	}
//(115)boardfileservice���� dao���� idx�� �Է¹޾� ����	
	public void deletePhoto(int idx)
	{
		boardFileDao.deletePhoto(idx);
	}
}
