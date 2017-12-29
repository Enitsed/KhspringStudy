package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://127.0.0.1:8090/myweb/hello.htm
@Controller
public class HelloController {

	@RequestMapping("/hello.htm")
	public String search() {
		return "view/part01/hello";
	} // end search();

} // end class
