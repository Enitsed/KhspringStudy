package part02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myinterceptor/noticeList.do
@Controller
public class NoticeController {
	@RequestMapping("/noticeList.do")
	public String process() {
		return "part02/noticeList";
	}
}
