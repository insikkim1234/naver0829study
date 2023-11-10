package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
//(1)@Controller 이용해 자동으로 설정파일에 bean이 등록되도록 한다
@Controller
public class ShopController {
	
	//(2)/을 맵핑해서 home.jsp로 돌아가도록 한다
	@GetMapping("/")
	public String home()
	{
		return "home";
	}

	//(3){path}을 맵핑해서 /shop/{} 안에 입력받은 경로로 이동시켜 준다
	//물론 이름 list는 상관 없음
	@GetMapping("/shop/{path}")
	public String list(@PathVariable String path,Model model)
	{
		//(4){}안의 값에 따라 원피스/슈즈/악세서리 목록을 입력받는다
		System.out.println(path);
		String shopinfo="";
		if(path.equals("list1"))
			shopinfo="원피스 상품 목록";
		else if(path.equals("list2"))
			shopinfo="슈즈 상품 목록";
		else
			shopinfo="악세서리 상품 목록";
		
		//(5) 원피스/슈즈/악세서리에 값을 리스트 형식으로 입력받는다
		List<ShopDto> list=new ArrayList<ShopDto>();
		if(path.equals("list1")) {
			list.add(new ShopDto("화이트원피스", "2.jpg", 99000));
			list.add(new ShopDto("스포티원피스", "25.jpg", 45000));
			list.add(new ShopDto("레이스원피스", "28.jpg", 68000));
			list.add(new ShopDto("청원피스", "33.jpg", 23000));			
		}else if(path.equals("list2")) {
			list.add(new ShopDto("샤넬슈즈", "12.jpg", 1500000));
			list.add(new ShopDto("구찌슈즈", "14.jpg", 980000));
			list.add(new ShopDto("플렛슈즈", "15.jpg", 33000));
		}else {
			list.add(new ShopDto("리본핀", "19.jpg", 11000));
			list.add(new ShopDto("머리띠", "30.jpg", 230000));
			list.add(new ShopDto("진주반지", "21.jpg", 55000));
			list.add(new ShopDto("머리끈", "26.jpg", 9000));
		}
		//(6) list에 상품 정보를전달/count에 상품의 갯수를 전달/shopinfo에 어떤 상품 목록인지 저장후 list1리턴
		model.addAttribute("list",list);
		model.addAttribute("count",list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
	
	//(7) /food/morning/brunch 경로를 매핑
	//물론 이름인 brunch는 상관 없다
	@GetMapping("/food/morning/brunch")
	public String brunch(Model model)
	{
		//(8)입력받은 모델에 message에 오늘의 브런치 메뉴들을 저장하고,today에 해당 페이지를 여는 시간 저장
		model.addAttribute("message", "오늘의 브런치 메뉴들");
		model.addAttribute("today", new Date());
		//(9)이미지 3개를 리스트에 저장 후 입력받은 모델에 저장 후 리턴
		List<String> list=new ArrayList<String>();
		list.add("K-039.png");
		list.add("K-041.png");
		list.add("K-042.png");
		
		model.addAttribute("list", list);
		
		return "list2";
	}
	
	//(10)/food/photo/detail 경로를 매핑
	@GetMapping("/food/photo/detail")
	public ModelAndView detail()
	{
		//(11)modelandview형식으로 시작
		ModelAndView mview=new ModelAndView();
		//(12)리스트에 사진 3개를 매핑 후 정의한 ModelAndView에 저장 후 리턴 (13)은 ShopDto로 이동
		List<String> list=new ArrayList<String>();
		list.add("1.jpg");
		list.add("8.jpg");
		list.add("9.jpg");
		mview.addObject("food", list);
		mview.addObject("name","이문희");
		mview.addObject("addr","서울시 강남구");
		
		mview.setViewName("list3");
		
		return mview;
		
	}
	//(13)servlet-context.xml을 통해서 두가지 경로 지정
	//<resources mapping="/res/**" location="/resources/" /> 
	//<resources mapping="/photo/**" location="/WEB-INF/photo/" />
	
}