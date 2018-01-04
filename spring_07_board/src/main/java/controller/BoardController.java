package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardService;

// http://localhost:8090/myboard/list.sb
@Controller
public class BoardController {
	private BoardService service;
	private int currentPage;
	private PageDTO pdto;

	public BoardController() {

	}

	public void setService(BoardService service) {
		this.service = service;
	}

	@RequestMapping("/list.sb")
	public ModelAndView listMethod(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = service.countProcess();
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0) {
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}

			pdto = new PageDTO(currentPage, totalRecord);
			mav.addObject("pv", pdto);
			mav.addObject("aList", service.listProcess(pdto));
		}

		mav.setViewName("board/list");
		return mav;
	} // end listMethod()

	@RequestMapping("/view.sb")
	public ModelAndView viewMethod(int currentPage, int num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.contentProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/view");
		return mav;
	} // end viewMethod()

	@RequestMapping(value = "/write.sb", method = RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv, BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		if (dto.getRef() != 0) {
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto", dto);
		}
		mav.setViewName("board/write");
		return mav;
	} // end writeMethod()

	@RequestMapping(value = "/write.sb", method = RequestMethod.POST)
	public String writeProMethod(BoardDTO dto, HttpServletRequest request) {
		MultipartFile file = dto.getFilename();
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			// 중복 파일명을 처리하기위해 난수 발생
			UUID random = UUID.randomUUID();
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root);
			// root+"temp/"
			String saveDirectory = root + "temp" + File.separator;
			File fe = new File(saveDirectory);
			if (!fe.exists())
				fe.mkdir();
			File ff = new File(saveDirectory, random + "_" + fileName);

			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			dto.setUpload(random + "_" + fileName);
		}

		dto.setIp(request.getRemoteAddr());

		// 답변글이면
		if (dto.getRef() != 0) {
			service.reStepProcess(dto);
		} else {
			// 제목글이면
			service.insertProcess(dto);
		}

		return "redirect:/list.sb";
	} // end writeProMethod()

	@RequestMapping("/contentdownload.sb")
	public ModelAndView downMethod(int num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", num);
		mav.setViewName("download");
		return mav;

		/////////////////////////////// 뷰 ///// 모델명 /모델값
		// return new ModelAndView("download", "num", num);
	} // end downMethod()

	@RequestMapping(value = "/update.sb", method = RequestMethod.GET)
	public ModelAndView updateMethod(int num, int currentPage) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.updateSelectProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/update");
		return mav;
	} // end updateMethod()

	@RequestMapping(value = "/update.sb", method = RequestMethod.POST)
	public ModelAndView updateProc(BoardDTO dto, int currentPage, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		service.updateProcess(dto, request);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/list.sb");
		return mav;
	} // end updateProc()

	@RequestMapping(value = "/delete.sb", method = RequestMethod.GET)
	public ModelAndView deleteMethod(int num, int currentPage, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		service.deleteProcess(num, request);
		PageDTO pv = new PageDTO(currentPage, service.countProcess());
		mav.addObject("currentPage", pv.getTotalPage());
		mav.setViewName("redirect:/list.sb");
		return mav;
	} // end deleteMethod()

} // end class
