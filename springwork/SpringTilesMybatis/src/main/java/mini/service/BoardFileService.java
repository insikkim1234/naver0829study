package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardFileDao;
import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
//(93) BoardFileService.java에 기본 세팅
@Service
@AllArgsConstructor
public class BoardFileService {
	
	private BoardFileDao boardFileDao;
//(96)BoardFileService에 insertPhoto(BoardFileDto dto) 작성 후 dto 입력받아 전송	
	public void insertPhoto(BoardFileDto dto)
	{
		boardFileDao.insertPhoto(dto);
	}
//(99)BoardFileService에 getPhotoByNum(int num) 작성 후 num 입력받아 전송	
	public List<String> getPhotoByNum(int num)
	{
		return boardFileDao.getPhotoByNum(num);
	}
//(112)boardfileservice에서 boardfiledao에 getFileDataByNum받아 저장	
	public List<BoardFileDto> getFileDataByNum(int num)
	{
		return boardFileDao.getFileDataByNum(num);
	}
//(115)boardfileservice에서 dao에서 idx를 입력받아 삭제	
	public void deletePhoto(int idx)
	{
		boardFileDao.deletePhoto(idx);
	}
}
