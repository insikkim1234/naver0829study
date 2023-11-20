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

//(55)StorageRestController�� PhotoStorageController �� �⺻���� ����
//@Autowired
//private NcpObjectStorageService storageService;
//
//private String bucketName="bitcamp-lmh";//���� �ڱ� ���� �̸�(����԰�)
//private String bucketFolder="photo";//���� ���� ����
@RestController
public class StorageRestController {
	@Autowired
	private NcpObjectStorageService storageService;
	
	@Autowired
	PhotoDao photoDao;
	
	private String bucketName="bitcamp-lmh";//���� �ڱ� ���� �̸�(����԰�)
	private String bucketFolder="photo";//���� ���� ����
	
	String fileName;
	//(68)StorageRestController�� @PostMapping("/storage/addphoto")�� �����ϰ�
	//���丮���� ���ε� �� photo80����ȯ �� �ִ� �Լ� �ۼ�
	@PostMapping("/storage/addphoto")
		//1)upload�� ���ڷ� �ޱ�
	public String addPhoto(@RequestParam MultipartFile upload)
	{
		//2)���丮���� ���ε�
		fileName=storageService.uploadFile(bucketName, bucketFolder, upload);
		//3)photo80�� 80X80���� ������ִ� ���̹�Ŭ���忡�� ���� ������ ����
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		//4)photo80�� ��ȯ�Ͽ� �����̹��� ���
		return photo80;
	}
	//(69)�� �Ѱ� ���� �����ؼ� ���ε� �ƴ� �� Ȯ���ϱ�(������ ����� ��� ���������� ����ȴ�)
	
	
	//(70)StorageRestControlleer�� @PostMapping("/storage/adddb")���� �� �ۼ�
	@PostMapping("/storage/adddb")
	public void insertPhoto(@RequestParam String title)
	{
		//1)dto���� �� dto�� title����
		PhotoDto dto=new PhotoDto();
		dto.setTitle(title);
		
		
		//2)photo������ ����������� ����
		String photo="https://kr.object.ncloudstorage.com/bitcamp-lmh/photo/"+fileName;
		//3)photo150������ 150*150������� ����
		String photo150="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=150&h=150&faceopt=true&ttype=jpg";
		//4)photo80������ 80*80������� ����
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		
		//5)dto�� photo,photo80,photo150 ����
		dto.setPhoto(photo);
		dto.setPhoto80(photo80);
		dto.setPhoto150(photo150);
		
		//6)db �� dto�� insert
		photoDao.insertPhoto(dto);
		//7)���� �Է��� ���ؼ� ���� �̸� �ʱ�ȭ
		fileName=null;
		
	}
	
	//(72)StorageRestControlleer��@GetMapping("/storage/list") ���� �� �ۼ�
	@GetMapping("/storage/list")
	public List<PhotoDto> getAllStorage()
	{
		//1)getAllPhotos()��ȯ
		return photoDao.getAllPhotos();
	}
	
	
	//(76)StorageRestController�� ���� �߰�@GetMapping("/storage/delete")���� �� �ۼ�
	@GetMapping("/storage/delete")
	public void deletePhoto(@RequestParam int num)
	{
		//1)num�� �Է¹޾Ƽ� deletePhoto�� �����Ŵ
		photoDao.deletePhoto(num);
	}
}
















