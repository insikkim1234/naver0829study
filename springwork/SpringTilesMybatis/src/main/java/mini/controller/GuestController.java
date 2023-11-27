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

//(159)guestcontroller.java��
	//1)*�⺻����*
@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	@Autowired
	private NcpObjectStorageService storageService;
	//ncp����
	private String bucketName="guest-lmh";
	private String folderName="guest";
	
	//(9)GuestController�� @GetMapping("/guest/list")���� �� guest/guestlist��ȯ
	@GetMapping("/guest/list")
	public String login(Model model)
	{
		//1)��� �Խ�Ʈ�� �ο����� ����
		int totalCount=guestService.getAllGuest().size();
		//2)��� �Խ�Ʈ�� ����Ʈ�� ����
		List<GuestDto> glist=guestService.getAllGuest();
		//3)totalCount,glist�� �𵨿� �߰�
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		
		//4)guest/guestlist��ȯ
		return "guest/guestlist";
	}
	//2)@GetMapping("/guest/insert") �����ϰ� �ۼ�
	@PostMapping("/guest/insert")
		//1.dto�� upload�� ���ڷ� �ޱ�
	public String insertGuest(@ModelAttribute GuestDto dto,
			@RequestParam MultipartFile upload)
	{
		//2.���̹� ���丮���� ���ε� �� ���� ���ϸ� ��ȯ
		String guest_photo=storageService.uploadFile(bucketName, folderName, upload);
		//3.dto�� ���� ���ϸ� ����
		dto.setGuest_photo(guest_photo);
		
		//4.db�� insert
		guestService.insertGuest(dto);
		
		//5./guest/list�� �����̷�Ʈ
		return "redirect:./list";
	}
}
