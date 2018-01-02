package part05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//http://localhost:8090/myweb/memList.htm

@Controller
public class MemListController {
	private MemDAO dao;

	public MemListController() {

	}

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/memList.htm")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", dao.listMethod());
		mav.setViewName("view/part05/memList");
		return mav;
	}

} // end class
