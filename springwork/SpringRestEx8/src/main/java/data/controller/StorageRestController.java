package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
