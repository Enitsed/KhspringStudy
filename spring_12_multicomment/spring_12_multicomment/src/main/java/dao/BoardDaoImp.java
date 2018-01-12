package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardDaoImp implements BoardDAO {
	
	private SqlSessionTemplate sqlSessionTemp;

	public BoardDaoImp() {
	}
	
	public void setSqlSessionTemp(SqlSessionTemplate sqlSessionTemp) {
		this.sqlSessionTemp = sqlSessionTemp;
	}

	@Override
	public List<BoardDTO> boardListMethod() {
		return sqlSessionTemp.selectList("board.b_list");
	}

	@Override
	public BoardDTO boardviewMethod(int bno) {
		return sqlSessionTemp.selectOne("board.b_view", bno);
	}

	@Override
	public void replyInsertMethod(ReplyDTO rdto) {
		sqlSessionTemp.insert("reply.r_insert", rdto);
	}

	@Override
	public List<ReplyDTO> replyListMethod(int bno) {
		return sqlSessionTemp.selectList("reply.r_list", bno);
	}

	@Override
	public void replyDeleteMethod(int rno) {
		sqlSessionTemp.delete("reply.r_delete", rno);
	}

	@Override
	public void replyUpdateMethod(ReplyDTO rdto) {
		sqlSessionTemp.update("reply.r_update", rdto);
	}

}
