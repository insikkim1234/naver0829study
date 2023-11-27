package mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.GuestDto;
import mini.service.GuestService;
import naver.storage.NcpObjectStorageService;

//(159)guestcontroller.java에
	//1)*기본세팅*
@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	@Autowired
	private NcpObjectStorageService storageService;
	//ncp연결
	private String bucketName="guest-lmh";
	private String folderName="guest";
	
	//(9)GuestController에 @GetMapping("/guest/list")매핑 후 guest/guestlist반환
	@GetMapping("/guest/list")
	public String login(Model model)
	{
		//1)모든 게스트의 인원수를 구함
		int totalCount=guestService.getAllGuest().size();
		//2)모든 게스트를 리스트로 만듬
		List<GuestDto> glist=guestService.getAllGuest();
		//3)totalCount,glist를 모델에 추가
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		
		//4)guest/guestlist반환
		return "guest/guestlist";
	}
	//2)@GetMapping("/guest/insert") 매핑하고 작성
	@PostMapping("/guest/insert")
		//1.dto와 upload를 인자로 받기
	public String insertGuest(@ModelAttribute GuestDto dto,
			@RequestParam MultipartFile upload)
	{
		//2.네이버 스토리지에 업로드 후 랜덤 파일명 변환
		String guest_photo=storageService.uploadFile(bucketName, folderName, upload);
		//3.dto에 사진 파일명 저장
		dto.setGuest_photo(guest_photo);
		
		//4.db에 insert
		guestService.insertGuest(dto);
		
		//5./guest/list로 리다이렉트
		return "redirect:./list";
	}
}
