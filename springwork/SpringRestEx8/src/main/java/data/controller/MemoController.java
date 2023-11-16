package data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//(6)MemoController에서 /memo/list매핑까지 생성
@Controller
public class MemoController {
	@GetMapping("/memo/list")
	public String memoList()
	{
		return "memo/list";
	}
}
