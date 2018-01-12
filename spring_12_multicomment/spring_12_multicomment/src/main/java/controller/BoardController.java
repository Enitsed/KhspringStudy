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

//http://localhost:8090/mycomment/boardList.do

@Controller
public class BoardController {
	
	private BoardService service;
	private String path;

	public BoardController() {
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/boardList.do")
	public ModelAndView boardListPage() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.boardListProcess());
		mav.setViewName("boardList");
		return mav;
	}
	
	@RequestMapping(value = "/boardView.do")
	public ModelAndView boardViewPage(int bno) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", service.boardViewProcess(bno));
		mav.setViewName("boardView");
		return mav;
	}
	
	@RequestMapping(value = "/replyInsertList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto, HttpServletRequest request) {
		
		List<MultipartFile> files = rdto.getFilename();

//		파일 확인		
//		for (MultipartFile file : files) {
//			System.out.println(file.getOriginalFilename());
//		}
		
		System.out.println(files.size());
//		첨부파일 읽어오기
		if (files != null) {
			
			for (MultipartFile file : files) {
				
				String fileName = file.getOriginalFilename();
				
				UUID random = UUID.randomUUID();
				//중복파일명이 있을시 덮어씌워 전에파일이 지워지는 현상을 막기위해 난수 발생
				
//				String root = request.getSession().getServletContext().getRealPath("/");
//				String saveDirectory = root + "temp" + File.separator;
				String saveDirectory = path;
				File fe = new File(saveDirectory);
				if (!fe.exists()) {
					fe.mkdir();
				}
				
				File ff = new File(saveDirectory, random + "_" + fileName);
				
				try {
					FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
//										파일을 읽어와서,			여기에 써준다
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (rdto.getRupload() != null) {
					rdto.setRupload(rdto.getRupload() + "," + random + "_" + fileName);
				} else {
					rdto.setRupload(random + "_" + fileName);
				}
//				form 			=>				DTO				=>			Table
//							(MultipartFile)					(String)
				
			}
		}
		
//		System.out.println(rdto.getRupload());
		
		return service.replyListProcess(rdto);
	}
	
	@RequestMapping(value = "/replyDelete.do")
	public @ResponseBody List<ReplyDTO> replyDeleteListPage(ReplyDTO rdto) {
		
		return service.replyDeleteProcess(rdto);
	}
	
	@RequestMapping(value = "/replyUpdateList.do")
	public @ResponseBody List<ReplyDTO> replyUpdateListPage(ReplyDTO rdto) {
		
		return service.replyUpdateProcess(rdto);
	}

}
