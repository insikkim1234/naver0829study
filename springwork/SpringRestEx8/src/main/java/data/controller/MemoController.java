package data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//(6)MemoController���� /memo/list���α��� ����
@Controller
public class MemoController {
	@GetMapping("/memo/list")
	public String memoList()
	{
		return "memo/list";
	}
}
