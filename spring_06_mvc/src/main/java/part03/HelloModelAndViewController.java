package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//http://127.0.0.1:8090/myweb/helloModelView.htm
@Controller
public class HelloModelAndViewController {

	@RequestMapping("/helloModelView.htm")
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "kim");
		mav.addObject("age", 20);
		mav.setViewName("view/part03/helloModelView");
		return mav;

	} // end search()

} // end class
