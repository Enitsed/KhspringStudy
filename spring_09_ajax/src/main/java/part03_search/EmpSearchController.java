package part03_search;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// @ResponseBody 어노테이션은 메소드에서 return 값을 json으로 리턴한다.
	// 어노테이션을 적용하기 위해서 dispatcher.xml에 mvc 네임스페이스 추가 후
	// mvc:annotation-driven 태그를 추가해야한다.
	@RequestMapping("/process.do")
	public @ResponseBody List<EmployeeDTO> searchProcess(String data) {
		return dao.search(data);
	}

} // end class
