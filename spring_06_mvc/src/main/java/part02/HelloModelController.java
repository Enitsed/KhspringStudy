package part02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//http://127.0.0.1:8090/myweb/view/part02/helloModel.htm

@Controller
public class HelloModelController {

	@RequestMapping("/view/part02/helloModel.htm")
	public Model search() {
		Model model = new ExtendedModelMap();
		model.addAttribute("id", "korea");
		return model;
	}

} // end class
