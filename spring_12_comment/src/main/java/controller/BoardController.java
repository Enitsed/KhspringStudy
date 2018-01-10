package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
		// mav.setViewName("boardView");
		mav.setViewName("boardView2");
		return mav;
	}

	@RequestMapping("/replyInsertList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto, HttpServletRequest request) {
		// 여기서는 path의 경로 c:/temp/를 이용하기 때문에 request가 필요없다

		MultipartFile file = rdto.getFilename();
		/*
		 * System.out.println(file.getOriginalFilename());
		 * System.out.println(rdto.getReplyer());
		 * System.out.println(rdto.getReplytext());
		 */

		ModelAndView mav = new ModelAndView();

		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename(); // 선택된 첨부파일을 가지고 올 때 db table에 저장하기 위해.

			// 중복파일명을 처리하기 위해 난수 발생
			UUID random = UUID.randomUUID();

			String root = path;

			String saveDirectory = root + File.separator;

			File fe = new File(saveDirectory);

			if (!fe.exists()) // 파일이 존재하지 않으면 위 경로대로 directory를 생성하고
				fe.mkdir();

			File ff = new File(saveDirectory, random + "_" + fileName); // 발생된 난수번호 값으로 파일을 저장한다(이름만).

			try {
				// 파일내용들을 버퍼에 저장 하는단계
				// file.getInputStream="파일의 내용", new FileOutputStream(파일이름에 해당하는 곳에 buffer에
				// 저장되었던 파일 내용을 저장한다.)
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// rdto에 있는 rupload에 첨부파일을 넣어주면 된다.
			rdto.setRupload(random + "_" + fileName); // varchar2에 있는 컬럼에다가 String의 데이터를 넣을 수 있다.
		}

		return service.replyListProcess(rdto);
	}

	@RequestMapping("/replyDelete.do")
	public @ResponseBody List<ReplyDTO> replyDeleteListPage(ReplyDTO rdto) {
		return service.replyDeleteProcess(rdto);
	}

	@RequestMapping("/replyUpdate.do")
	public @ResponseBody List<ReplyDTO> replyUpdateListPage(ReplyDTO rdto) {
		return service.replyUpdateProcess(rdto);
	}

} // end class
