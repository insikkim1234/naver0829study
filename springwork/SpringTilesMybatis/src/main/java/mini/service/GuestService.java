package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.GuestDao;
import mini.dto.GuestDto;
//(148)GuestService.java에 기본 세팅
@Service
@AllArgsConstructor
public class GuestService {
	
	private GuestDao guestDao;
//(158)GuestService.java에 위 에 3개 호출하는 함수 작성	
	public void insertGuest(GuestDto dto)
	{
		guestDao.insertGuest(dto);
	}
	
	public List<GuestDto> getAllGuest()
	{
		return guestDao.getAllGuest();
	}
	
	public void deleteGuest(int guest_num)
	{
		guestDao.deleteGuest(guest_num);
	}
}
