package part04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//http://127.0.0.1:8090/myweb/mem.htm

@Controller
public class HelloCommandController {

	// 인자가 하나일 경우 value= 는 없어도 된다.
	@RequestMapping(value = "/mem.htm", method = RequestMethod.GET)
	public String form() {
		return "view/part04/memForm";
	} // end form()

	// // 위의 메소드와 아래의 메소드는 get, post로 구분한다.
	// @RequestMapping(value = "/mem.htm", method = RequestMethod.POST)
	// public ModelAndView submit(String name, int age) {
	// ModelAndView mav = new ModelAndView();
	// mav.addObject("name", name);
	// mav.addObject("age", age);
	// mav.setViewName("view/part04/memPro");
	// return mav;
	// } // end submit()

	// @RequestMapping(value = "/mem.htm", method = RequestMethod.POST)
	// public String submit(MemDTO dto) {
	// // dto의 값을 받을 멤버변수의 이름과 form에서 전송하는 데이터의 이름이 같게 해야한다. (dto에서 setter 필수)
	// // 일일이 데이터를 매핑 하지 않아도 자동으로 dto에 매핑이 된다.
	// return "view/part04/memPro";
	// }

	@RequestMapping(value = "/mem.htm", method = RequestMethod.POST)
	public String submit(@ModelAttribute("dto") MemDTO dto) {
		// @ModelAttribute 안에 있는 이름으로 객체를 참조하라는 의미
		return "view/part04/memPro";
	}
} // end class
