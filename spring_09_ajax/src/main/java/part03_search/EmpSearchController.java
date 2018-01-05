package part03_search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpSearchController {
	private EmpDAO dao;

	public EmpSearchController() {

	}

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/search.do")
	public String searchForm() {
		return "part03_search/searchForm";
	}

} // end class
