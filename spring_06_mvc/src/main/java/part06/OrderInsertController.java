package part06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//http://localhost:8090/myweb/orderInsert.htm
@Controller
public class OrderInsertController {
	private OrderDAO dao;

	public OrderInsertController() {

	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/orderInsert.htm", method = RequestMethod.GET)
	public String form() {
		return "view/part06/form";
	}

	@RequestMapping(value = "/orderInsert.htm", method = RequestMethod.POST)
	public String submit(OrderDTO dto) {
		dao.insertmethod(dto);
		return "redirect:/orderList.htm";
	}

} // end class
