package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/mytilesajax/index.do
@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String process() {
		return "index";
	}

} // end class
