package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.ReplyDTO;
import service.BoardService;

// http://localhost:8090/mycomment/boardList.do
@Controller
public class BoardController {
	private BoardService service;
	private String path;

	public BoardController() {

	}

	public void setService(BoardService service) {
		this.service = service;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@RequestMapping("/boardList.do")
	public ModelAndView boardListPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.boardListProcess());
		mav.setViewName("boardList");
		return mav;
	}

	@RequestMapping("/boardView.do")
	public ModelAndView boardViewPage(int bno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", service.boardViewProcess(bno));
		mav.setViewName("boardView");
		return mav;
	}

	@RequestMapping("/replyInsertList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto, HttpServletRequest request) {
		return service.replyListProcess(rdto);
	}

	@RequestMapping("/replyDelete.do")
	public @ResponseBody List<ReplyDTO> replyDeleteListPage(ReplyDTO rdto) {
		return service.replyDeleteProcess(rdto);
	}

} // end class
