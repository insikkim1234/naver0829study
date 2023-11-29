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
	//(142)boardController에 answerService선언 
	@Autowired
	private BoardAnswerService answerService;
	
	@Autowired
	private MemberDao memberDao;
	
	//(8)BoardController에 @GetMapping("/board/list")매핑 후 board/boardlist반환
	@GetMapping("/board/list")
	//(106)boardController.java의 @GetMapping("/board/list")부분에 페이징하는 쿼리 작성
		//1)인자로 currentPage받을 건데 디폴트값은 1이다
	public String list(Model model,@RequestParam(defaultValue = "1") int currentPage)
	{
		
		//2)페이징처리
		  //1.페이징 처리에 필요한 변수들
		  int perPage=5; //한페이지당 보여지는 게시글의 갯수
		  int totalCount=0; //총 개시글의 개수
		  int totalPage;//총페이지수
		  int startNum;//각페이지당 보여지는 글의 시작번호
		  int perBlock=5; //한블럭당 보여지는 페이지의 개수
		  int startPage; //각블럭당 보여지는 페이지의 시작번호
		  int endPage;

		  //2.총 글개수
		  totalCount=boardService.getTotalCount();

		  //3.총페이지수,나머지가 있으면 무조건올림
		  		//총게시글이 37-한페이지 3-12.3333....13페이지
		  		//totalcount를 perpage로 나누는데 남는게 있으면 다음페이지로 넘김
		  totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);

		  //4.각블럭의 시작페이지와 끝페이지
		  startPage=(currentPage-1)/perBlock*perBlock+1;
		  endPage=startPage+perBlock-1;

		  //5.endPage는 totalPage를 넘지않도록 한다
		  //endpage 가 토탈페이지보다 크다면 마지막에 endpage를 totalpage까지 출력
		  if(endPage>totalPage)
		   endPage=totalPage;

		  //6.각페이지당 불러올 글의 번호
		  //만약 10개기준이라면 1페 0~9 2페 10~19
		  //1페이지:0~2(3페이지므로) 2페이지:11~20 3페이지:31-40
		  startNum=(currentPage-1)*perPage;
		

		  //7.각 페이지의 시작 번호
		  int no=totalCount-(currentPage-1)*perPage;
		  
		  //8.해당페이지에 보여줄 게시판 목록
		  List<BoardDto> list=boardService.getList(startNum, perPage);
		  
		  //9.각 dto에 첨부된 사진의 갯수 저장
		  for(BoardDto dto:list)
		  {
			  int pcount=boardFileService.getPhotoByNum(dto.getNum()).size();
			  dto.setPhotocount(pcount);
			  
			  //댓글 갯수 저장
			  int acount=answerService.getAnswerBoard(dto.getNum()).size();
			  dto.setAcount(acount);
		  }
		  
		  //10.request 에 담을 값들
		  model.addAttribute("list",list);
		  model.addAttribute("totalCount",totalCount);
		  model.addAttribute("totalPage",totalPage);
		  model.addAttribute("startPage",startPage);
		  model.addAttribute("endPage",endPage);
		  model.addAttribute("currentPage",currentPage);  
		  model.addAttribute("no",no);  
		  //11.board/boardlist반환
		return "board/boardlist";
	}
	//(100)BoardController.java에 
	//@GetMapping("/board/form")매핑 후 board/boardform리턴
	//새글일때 답글일때 모두 호출,목록으로 갈때 디폴트는 1이고  currentpage로 갈수있도록함
	@GetMapping("/board/form")
	public String form(
			// 1)인자 결정,새글일때는 값이 안넘어오므로 defaultValue가 적용된다
			Model model,
			
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel)
	{//2)모델에 해당 어트리뷰트값을 키:값 형태로 추가
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("num", num);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		
		//3)답글일 경우(num>0) 추가로 제목 얻어온 후 모델에 추가
		String subject="";
		if(num>0)
			subject=boardService.getData(num).getSubject();
		
		
		model.addAttribute("subject", subject);
		
		//4)board/boardform반환
		return "board/boardform";
	}
	
	//(104)BoardController.java에 @PostMapping("/board/addboard")매핑 후 작성
	@PostMapping("/board/addboard")
		//1)인자로 dto,currentPage,upload,request,session받기
	public String addBoard(
			@ModelAttribute BoardDto dto,
			@RequestParam int currentPage,
			@RequestParam List<MultipartFile> upload,
			HttpServletRequest request,
			HttpSession session)
	{
		//2)파일을/resources/upload에 업로드
		String path=request.getSession()
				.getServletContext().getRealPath("/resources/upload");
		//3)테이블에 저장할 로그인정보
		String myid=(String)session.getAttribute("myid");
		String writer=(String)session.getAttribute("myname");
		//4)dto에 넣기
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		//5)일단 BoardDto먼저 저장
		boardService.insertBoard(dto);
		
		//6)num값 넘어왔는지 확인
		System.out.println("num="+dto.getNum());
		
		//7)사진들 업로드
		//1.사진 업로드를 안했을 겨우 리스트의 첫 데이타의 파일명이 빈문자열이 된다
		//즉 업로드했을 경우에만 db에 저장한다
		if(!upload.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile multi:upload)
			{
				//2.랜덤 파일명을 생성
				String fileName=UUID.randomUUID().toString();
				//3.(path+"/"+fileName)에 업로드
				try {
					multi.transferTo(new File(path+"/"+fileName));
				//4.fdto를 만들고 파일은 따로 db에 insert한다
					BoardFileDto fdto=new BoardFileDto();
					fdto.setNum(dto.getNum());//boarddb에 방금 insert된 num값
					fdto.setPhotoname(fileName);
				//5.insertPhoto구문 실행		
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
		
		//8)새글인 경우는 1페이지로 답글인 경우는 보던 페이지로 이동한다
		return "redirect:list?currentPage="+currentPage;
	}
	//(108)boardcontroller.java에 @GetMapping("/board/content") 매핑 후 작성
		//1)model,num,currentPage를 인자로 받기
	@GetMapping("/board/content")
	public String getContent(Model model,
			@RequestParam int num,
			@RequestParam(defaultValue="1") int currentPage)
	{
		//2)조회수 증가
		boardService.updateReadCount(num);
		//3)num에 해당하는 dto얻기
		BoardDto dto=boardService.getData(num);
		//4)프로필사진 가져오기
		String profile_photo=memberDao.getData(dto.getMyid()).getPhoto();
		//5)사진들과 사진 갯수
		List<String> photos=boardFileService.getPhotoByNum(num);
		dto.setPhotocount(photos.size());//사진갯수
		dto.setPhotoNames(photos);//사진 파일명들
		
		//6)model에 저장
		model.addAttribute("profile_photo", profile_photo);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		//7)board/content반환
		return "board/content";
	}
	//(122)boardController.java에서 @GetMapping("/board/delete")작성
	@GetMapping("/board/delete")
		//1)인자로 num,currentPage받기
	public String deleteBoard(
			@RequestParam int num,
			@RequestParam int currentPage)
	{
		//2)num에 해당하는 튜플 삭제
		boardService.deleteBoard(num);
		
		//3)원래 있었던 목록(원래 3페이지면 3)으로 돌아감
		return "redirect:./list?currentPage="+currentPage;
	}
	//(123)boardController.java에서@GetMapping("/board/updateform") 작성
	@GetMapping("/board/updateform")
		//1)인자로 num,currentpage,담아서 보낼 모델 받기
	public String updateForm(Model model,
			@RequestParam int num,
			@RequestParam int currentPage)
	{
		//2)dto,flist만들기
		BoardDto dto=boardService.getData(num);
		List<BoardFileDto> flist=boardFileService.getFileDataByNum(num);
		
		//3)모델에 currentPage,dto,flist보내기
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("dto", dto);
		model.addAttribute("flist", flist);
		
		//4)board/updateform반환
		return "board/updateform";
	}
	//(125)boardcontroller.java에@GetMapping("/board/delphoto")매핑 후 작성
	@GetMapping("/board/delphoto")
	//1)인자로 idx를 받음
	@ResponseBody public void deletePhoto(@RequestParam int idx)
	{
		//2)해당 사진 삭제
		boardFileService.deletePhoto(idx);
	}
	
	//(103)boardcontroller에 @PostMapping("/board/updateboard")매핑 후 새글 답글 저장하는 쿼리 작성
	
		@PostMapping("/board/updateboard")
		//1)인자로 dto,currentPage,upload,request,session받기
		public String updateBoard(
				@ModelAttribute BoardDto dto,
				@RequestParam int currentPage,
				@RequestParam List<MultipartFile> upload,
				HttpServletRequest request,
				HttpSession session)
		{
		//2)파일 업로드할 경로구하기/resources/upload
			String path=request.getSession()
					.getServletContext().getRealPath("/resources/upload");
			
			
		//3)dto를 입력하고 updateBoard()실행
			boardService.updateBoard(dto);
			
			
		//4)사진들 업로드
			//1.사진 업로드를 안했을 경우 리스트의 첫 데이타의 파일명이 빈문자열이 된다
			//즉 업로드했을 경우에만 db에 저장한다
			if(!upload.get(0).getOriginalFilename().equals("")) {
				for(MultipartFile multi:upload)
				{
					//2.랜덤 파일명을 생성
					String fileName=UUID.randomUUID().toString();
					//3.(path+"/"+fileName)경로에업로드
					try {
						multi.transferTo(new File(path+"/"+fileName));
					//4.fdto를 만들고 파일은 따로 db에 insert한다
						BoardFileDto fdto=new BoardFileDto();
						fdto.setNum(dto.getNum());
						fdto.setPhotoname(fileName);
					//5.insertPhoto구문 실행	
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
			
		//5)수정 후 내용보기로 이동 
			return "redirect:./content?currentPage="+currentPage+"&num="+dto.getNum();
		}
}
