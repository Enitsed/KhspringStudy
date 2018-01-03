package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.PageDTO;
import service.BoardService;

// http://localhost:8090/myboard/list.sb
@Controller
public class BoardController {
	private BoardService service;
	private int currentpage;
	private PageDTO pdto;

	public BoardController() {

	}

	public void setService(BoardService service) {
		this.service = service;
	}

	@RequestMapping("/list.sb")
	public ModelAndView listMethod() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.listProcess(pdto));
		mav.setViewName("board/list");
		return mav;
	}

} // end class
