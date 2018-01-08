package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.LibmapDTO;
import service.LibServiceImp;

// http://localhost:8090/mymap/map.do

@Controller
public class MapController {
	private LibServiceImp service;

	public MapController() {

	}

	public void setService(LibServiceImp service) {
		this.service = service;
	};

	@RequestMapping("/map.do")
	public String mapForm() {
		return "map";
	}

	@RequestMapping("/libmap.do")
	public ModelAndView libraryMap(int pageNo, int pageSize, String keyword) {
		ModelAndView mav = new ModelAndView();
		int countAll = service.f_countAllProcess(keyword);
		int totalPage = countAll / pageSize;
		if ((countAll % pageSize) > 0)
			totalPage++;

		/*
		 * int totalPage=(countAll/pageSize) +(countAll%pageSize==0?0:1);
		 */

		List<LibmapDTO> aList = service.f_listProcess(pageNo, pageSize, keyword);
		mav.addObject("aList", aList);
		mav.addObject("pageNo", pageNo);
		mav.addObject("totalPage", totalPage);
		mav.setViewName("jsonView");
		return mav;
	}// end libraryMap( )

} // end class
