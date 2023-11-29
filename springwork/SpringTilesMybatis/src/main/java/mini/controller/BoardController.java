package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mini.dao.MemberDao;
import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
import mini.service.BoardAnswerService;
import mini.service.BoardFileService;
import mini.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardFileService boardFileService;
	//(142)boardController�� answerService���� 
	@Autowired
	private BoardAnswerService answerService;
	
	@Autowired
	private MemberDao memberDao;
	
	//(8)BoardController�� @GetMapping("/board/list")���� �� board/boardlist��ȯ
	@GetMapping("/board/list")
	//(106)boardController.java�� @GetMapping("/board/list")�κп� ����¡�ϴ� ���� �ۼ�
		//1)���ڷ� currentPage���� �ǵ� ����Ʈ���� 1�̴�
	public String list(Model model,@RequestParam(defaultValue = "1") int currentPage)
	{
		
		//2)����¡ó��
		  //1.����¡ ó���� �ʿ��� ������
		  int perPage=5; //���������� �������� �Խñ��� ����
		  int totalCount=0; //�� ���ñ��� ����
		  int totalPage;//����������
		  int startNum;//���������� �������� ���� ���۹�ȣ
		  int perBlock=5; //�Ѻ��� �������� �������� ����
		  int startPage; //������ �������� �������� ���۹�ȣ
		  int endPage;

		  //2.�� �۰���
		  totalCount=boardService.getTotalCount();

		  //3.����������,�������� ������ �����ǿø�
		  		//�ѰԽñ��� 37-�������� 3-12.3333....13������
		  		//totalcount�� perpage�� �����µ� ���°� ������ ������������ �ѱ�
		  totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);

		  //4.������ ������������ ��������
		  startPage=(currentPage-1)/perBlock*perBlock+1;
		  endPage=startPage+perBlock-1;

		  //5.endPage�� totalPage�� �����ʵ��� �Ѵ�
		  //endpage �� ��Ż���������� ũ�ٸ� �������� endpage�� totalpage���� ���
		  if(endPage>totalPage)
		   endPage=totalPage;

		  //6.���������� �ҷ��� ���� ��ȣ
		  //���� 10�������̶�� 1�� 0~9 2�� 10~19
		  //1������:0~2(3�������Ƿ�) 2������:11~20 3������:31-40
		  startNum=(currentPage-1)*perPage;
		

		  //7.�� �������� ���� ��ȣ
		  int no=totalCount-(currentPage-1)*perPage;
		  
		  //8.�ش��������� ������ �Խ��� ���
		  List<BoardDto> list=boardService.getList(startNum, perPage);
		  
		  //9.�� dto�� ÷�ε� ������ ���� ����
		  for(BoardDto dto:list)
		  {
			  int pcount=boardFileService.getPhotoByNum(dto.getNum()).size();
			  dto.setPhotocount(pcount);
			  
			  //��� ���� ����
			  int acount=answerService.getAnswerBoard(dto.getNum()).size();
			  dto.setAcount(acount);
		  }
		  
		  //10.request �� ���� ����
		  model.addAttribute("list",list);
		  model.addAttribute("totalCount",totalCount);
		  model.addAttribute("totalPage",totalPage);
		  model.addAttribute("startPage",startPage);
		  model.addAttribute("endPage",endPage);
		  model.addAttribute("currentPage",currentPage);  
		  model.addAttribute("no",no);  
		  //11.board/boardlist��ȯ
		return "board/boardlist";
	}
	//(100)BoardController.java�� 
	//@GetMapping("/board/form")���� �� board/boardform����
	//�����϶� ����϶� ��� ȣ��,������� ���� ����Ʈ�� 1�̰�  currentpage�� �����ֵ�����
	@GetMapping("/board/form")
	public String form(
			// 1)���� ����,�����϶��� ���� �ȳѾ���Ƿ� defaultValue�� ����ȴ�
			Model model,
			
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel)
	{//2)�𵨿� �ش� ��Ʈ����Ʈ���� Ű:�� ���·� �߰�
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("num", num);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		
		//3)����� ���(num>0) �߰��� ���� ���� �� �𵨿� �߰�
		String subject="";
		if(num>0)
			subject=boardService.getData(num).getSubject();
		
		
		model.addAttribute("subject", subject);
		
		//4)board/boardform��ȯ
		return "board/boardform";
	}
	
	//(104)BoardController.java�� @PostMapping("/board/addboard")���� �� �ۼ�
	@PostMapping("/board/addboard")
		//1)���ڷ� dto,currentPage,upload,request,session�ޱ�
	public String addBoard(
			@ModelAttribute BoardDto dto,
			@RequestParam int currentPage,
			@RequestParam List<MultipartFile> upload,
			HttpServletRequest request,
			HttpSession session)
	{
		//2)������/resources/upload�� ���ε�
		String path=request.getSession()
				.getServletContext().getRealPath("/resources/upload");
		//3)���̺� ������ �α�������
		String myid=(String)session.getAttribute("myid");
		String writer=(String)session.getAttribute("myname");
		//4)dto�� �ֱ�
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		//5)�ϴ� BoardDto���� ����
		boardService.insertBoard(dto);
		
		//6)num�� �Ѿ�Դ��� Ȯ��
		System.out.println("num="+dto.getNum());
		
		//7)������ ���ε�
		//1.���� ���ε带 ������ �ܿ� ����Ʈ�� ù ����Ÿ�� ���ϸ��� ���ڿ��� �ȴ�
		//�� ���ε����� ��쿡�� db�� �����Ѵ�
		if(!upload.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile multi:upload)
			{
				//2.���� ���ϸ��� ����
				String fileName=UUID.randomUUID().toString();
				//3.(path+"/"+fileName)�� ���ε�
				try {
					multi.transferTo(new File(path+"/"+fileName));
				//4.fdto�� ����� ������ ���� db�� insert�Ѵ�
					BoardFileDto fdto=new BoardFileDto();
					fdto.setNum(dto.getNum());//boarddb�� ��� insert�� num��
					fdto.setPhotoname(fileName);
				//5.insertPhoto���� ����		
					boardFileService.insertPhoto(fdto);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//8)������ ���� 1�������� ����� ���� ���� �������� �̵��Ѵ�
		return "redirect:list?currentPage="+currentPage;
	}
	//(108)boardcontroller.java�� @GetMapping("/board/content") ���� �� �ۼ�
		//1)model,num,currentPage�� ���ڷ� �ޱ�
	@GetMapping("/board/content")
	public String getContent(Model model,
			@RequestParam int num,
			@RequestParam(defaultValue="1") int currentPage)
	{
		//2)��ȸ�� ����
		boardService.updateReadCount(num);
		//3)num�� �ش��ϴ� dto���
		BoardDto dto=boardService.getData(num);
		//4)�����ʻ��� ��������
		String profile_photo=memberDao.getData(dto.getMyid()).getPhoto();
		//5)������� ���� ����
		List<String> photos=boardFileService.getPhotoByNum(num);
		dto.setPhotocount(photos.size());//��������
		dto.setPhotoNames(photos);//���� ���ϸ��
		
		//6)model�� ����
		model.addAttribute("profile_photo", profile_photo);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		//7)board/content��ȯ
		return "board/content";
	}
	//(122)boardController.java���� @GetMapping("/board/delete")�ۼ�
	@GetMapping("/board/delete")
		//1)���ڷ� num,currentPage�ޱ�
	public String deleteBoard(
			@RequestParam int num,
			@RequestParam int currentPage)
	{
		//2)num�� �ش��ϴ� Ʃ�� ����
		boardService.deleteBoard(num);
		
		//3)���� �־��� ���(���� 3�������� 3)���� ���ư�
		return "redirect:./list?currentPage="+currentPage;
	}
	//(123)boardController.java����@GetMapping("/board/updateform") �ۼ�
	@GetMapping("/board/updateform")
		//1)���ڷ� num,currentpage,��Ƽ� ���� �� �ޱ�
	public String updateForm(Model model,
			@RequestParam int num,
			@RequestParam int currentPage)
	{
		//2)dto,flist�����
		BoardDto dto=boardService.getData(num);
		List<BoardFileDto> flist=boardFileService.getFileDataByNum(num);
		
		//3)�𵨿� currentPage,dto,flist������
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("dto", dto);
		model.addAttribute("flist", flist);
		
		//4)board/updateform��ȯ
		return "board/updateform";
	}
	//(125)boardcontroller.java��@GetMapping("/board/delphoto")���� �� �ۼ�
	@GetMapping("/board/delphoto")
	//1)���ڷ� idx�� ����
	@ResponseBody public void deletePhoto(@RequestParam int idx)
	{
		//2)�ش� ���� ����
		boardFileService.deletePhoto(idx);
	}
	
	//(103)boardcontroller�� @PostMapping("/board/updateboard")���� �� ���� ��� �����ϴ� ���� �ۼ�
	
		@PostMapping("/board/updateboard")
		//1)���ڷ� dto,currentPage,upload,request,session�ޱ�
		public String updateBoard(
				@ModelAttribute BoardDto dto,
				@RequestParam int currentPage,
				@RequestParam List<MultipartFile> upload,
				HttpServletRequest request,
				HttpSession session)
		{
		//2)���� ���ε��� ��α��ϱ�/resources/upload
			String path=request.getSession()
					.getServletContext().getRealPath("/resources/upload");
			
			
		//3)dto�� �Է��ϰ� updateBoard()����
			boardService.updateBoard(dto);
			
			
		//4)������ ���ε�
			//1.���� ���ε带 ������ ��� ����Ʈ�� ù ����Ÿ�� ���ϸ��� ���ڿ��� �ȴ�
			//�� ���ε����� ��쿡�� db�� �����Ѵ�
			if(!upload.get(0).getOriginalFilename().equals("")) {
				for(MultipartFile multi:upload)
				{
					//2.���� ���ϸ��� ����
					String fileName=UUID.randomUUID().toString();
					//3.(path+"/"+fileName)��ο����ε�
					try {
						multi.transferTo(new File(path+"/"+fileName));
					//4.fdto�� ����� ������ ���� db�� insert�Ѵ�
						BoardFileDto fdto=new BoardFileDto();
						fdto.setNum(dto.getNum());
						fdto.setPhotoname(fileName);
					//5.insertPhoto���� ����	
						boardFileService.insertPhoto(fdto);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		//5)���� �� ���뺸��� �̵� 
			return "redirect:./content?currentPage="+currentPage+"&num="+dto.getNum();
		}
}
