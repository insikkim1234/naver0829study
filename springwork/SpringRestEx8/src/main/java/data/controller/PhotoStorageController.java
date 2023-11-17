package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import naver.storage.NcpObjectStorageService;

//(46)data.controller -PhotoStorageController.java생성 후 기본 세팅
//*기본 세팅*
//컨트롤러 롬복
//
//@Autowired
//private NcpObjectStorageService storageService;
//
//연결할 naverstorage의 이름(강사님것)
//private String bucketName="bitcamp-lmh";
//
//bitcamp-lmh의 포토 폴더 연결
//private String bucketFolder="photo";
@Controller
public class PhotoStorageController {

	@Autowired
	private NcpObjectStorageService storageService;
	
	private String bucketName="bitcamp-lmh";//각자 자기 버켓 이름(강사님거)
	private String bucketFolder="photo";//포토 폴더 연결
	
	//(47)photoStorageController에서 
	//@GetMapping("/storage/form")으로 매핑 후storage/testform 반환
	@GetMapping("/storage/form")
	public String form()
	{
		return "storage/testform";
	}
	//(48)photoStorageController에서 @PostMapping("/storage/upload")으로 매핑 후 반환
	//상세내용은 나중에 작성
	@PostMapping("/storage/upload")
	public String upload(Model model,@RequestParam MultipartFile upload)
	{
		//(51)@PostMapping("/storage/upload")밑에 쿼리 작성
		//1)버켓에 업로드후 랜덤 파일명 리턴받기
		String fileName=storageService.uploadFile(bucketName, bucketFolder, upload);
		//2)원본사진경로
		String photo="https://kr.object.ncloudstorage.com/bitcamp-lmh/photo/"+fileName;
		//3)150*150
		String photo150="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=150&h=150&faceopt=true&ttype=jpg";
		//4)80*80
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		System.out.println(photo80.length());
		//5)모델에 2,3,4추가
		model.addAttribute("photo", photo);
		model.addAttribute("photo80", photo80);
		model.addAttribute("photo150", photo150);
		//6)storage/testresult반환
		return "storage/testresult";
	}
	
	//(54)@GetMapping("/storage/common")해당 주소로 맵핑되면 commondb.jsp반환
	@GetMapping("/storage/common")
	public String common()
	{
		return "storage/commondb";
	}

}






















