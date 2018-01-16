package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.SalesDTO;
import dto.WarehouseDTO;
import service.MarketService;

// http://localhost:8090/mytrigger/productIns.do
// http://localhost:8090/mytrigger/salesIns.do
@Controller
public class MarketController {
	private MarketService service;

	public MarketController() {

	}

	public void setService(MarketService service) {
		this.service = service;
	}

	@RequestMapping("/productIns.do")
	public ModelAndView inputForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.pnameSelectProcess());
		mav.setViewName("productForm");
		return mav;
	}

	@RequestMapping("/productPro.do")
	public String inputProcess(WarehouseDTO dto) {
		service.insertProcess(dto);
		return "redirect:/itemList.do";
	}

	@RequestMapping("/salesIns.do")
	public ModelAndView salesForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.pnameSelectProcess());
		mav.setViewName("salesForm");
		return mav;
	}

	@RequestMapping("/salesPro.do")
	public String salesProcess(SalesDTO dto) {
		service.salesInsertProcess(dto);
		return "redirect:/itemList.do";
	}

	@RequestMapping("/itemList.do")
	public ModelAndView listProcess() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aList", service.itemSelectProcess());
		mav.setViewName("itemList");
		return mav;
	}

}
