package part05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemInsertController {
	MemDAO dao;

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	public MemInsertController() {

	}

	@RequestMapping(value = "/memInsert.htm", method = RequestMethod.GET)
	public String form() {
		return "view/part05/memForm";
	} // end form()

	@RequestMapping(value = "/memInsert.htm", method = RequestMethod.POST)
	public String process(MemDTO dto) {
		dao.insertMethod(dto);
		return "redirect:/memList.htm";
	} // end process()

} // end class
