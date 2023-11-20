package data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dao.PhotoDao;
import data.dto.PhotoDto;
import naver.storage.NcpObjectStorageService;

//(55)StorageRestController에 PhotoStorageController 의 기본세팅 복붙
//@Autowired
//private NcpObjectStorageService storageService;
//
//private String bucketName="bitcamp-lmh";//각자 자기 버켓 이름(강사님거)
//private String bucketFolder="photo";//포토 폴더 연결
@RestController
public class StorageRestController {
	@Autowired
	private NcpObjectStorageService storageService;
	
	@Autowired
	PhotoDao photoDao;
	
	private String bucketName="bitcamp-lmh";//각자 자기 버켓 이름(강사님거)
	private String bucketFolder="photo";//포토 폴더 연결
	
	String fileName;
	//(68)StorageRestController에 @PostMapping("/storage/addphoto")을 매핑하고
	//스토리지에 업로드 후 photo80을반환 해 주는 함수 작성
	@PostMapping("/storage/addphoto")
		//1)upload를 인자로 받기
	public String addPhoto(@RequestParam MultipartFile upload)
	{
		//2)스토리지에 업로드
		fileName=storageService.uploadFile(bucketName, bucketFolder, upload);
		//3)photo80에 80X80으로 만들어주는 네이버클라우드에서 만든 과정을 복붙
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		//4)photo80을 반환하여 예시이미지 출력
		return photo80;
	}
	//(69)웹 켜고 파일 선택해서 업로드 됐는 지 확인하기(됐으면 강사님 디비에 포토폴더에 저장된다)
	
	
	//(70)StorageRestControlleer에 @PostMapping("/storage/adddb")맵핑 후 작성
	@PostMapping("/storage/adddb")
	public void insertPhoto(@RequestParam String title)
	{
		//1)dto선언 후 dto에 title저장
		PhotoDto dto=new PhotoDto();
		dto.setTitle(title);
		
		
		//2)photo변수에 원본사진경로 저장
		String photo="https://kr.object.ncloudstorage.com/bitcamp-lmh/photo/"+fileName;
		//3)photo150변수에 150*150사진경로 저장
		String photo150="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=150&h=150&faceopt=true&ttype=jpg";
		//4)photo80변수에 80*80사진경로 저장
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		
		//5)dto에 photo,photo80,photo150 저장
		dto.setPhoto(photo);
		dto.setPhoto80(photo80);
		dto.setPhoto150(photo150);
		
		//6)db 에 dto를 insert
		photoDao.insertPhoto(dto);
		//7)다음 입력을 위해서 파일 이름 초기화
		fileName=null;
		
	}
	
	//(72)StorageRestControlleer에@GetMapping("/storage/list") 맵핑 후 작성
	@GetMapping("/storage/list")
	public List<PhotoDto> getAllStorage()
	{
		//1)getAllPhotos()반환
		return photoDao.getAllPhotos();
	}
	
	
	//(76)StorageRestController에 매핑 추가@GetMapping("/storage/delete")맵핑 후 작성
	@GetMapping("/storage/delete")
	public void deletePhoto(@RequestParam int num)
	{
		//1)num을 입력받아서 deletePhoto를 실행시킴
		photoDao.deletePhoto(num);
	}
}
















