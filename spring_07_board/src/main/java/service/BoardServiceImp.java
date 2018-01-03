package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService {
	private BoardDAO dao;

	public BoardServiceImp() {

	}

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		return 0;
	}

	// 트랜잭션 어노테이션
	// @Transactional(rollbackFor = java.lang.Exception.class)
	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		return dao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {

	}

	@Override
	public BoardDTO contentProcess(int num) {
		return null;
	}

	@Override
	public void reStepProcess(BoardDTO dto) {

	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		return null;
	}

	@Override
	public void updateProcess(BoardDTO dto, HttpServletRequest request) {

	}

	@Override
	public void deleteProcess(int num, HttpServletRequest request) {

	}

} // end class
