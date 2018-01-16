package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.ItemDTO;
import dto.SalesDTO;
import dto.WarehouseDTO;

public class MarketDaoImp implements MarketDAO {
	private SqlSessionTemplate sqlSession;

	public MarketDaoImp() {

	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void inputInsertMethod(WarehouseDTO dto) {
		sqlSession.insert("mt.pins", dto);
	}

	@Override
	public int salesSelectMethod(String code) {
		return sqlSession.selectOne("mt.salesPrice", code);
	}

	@Override
	public void salesInsertMethod(SalesDTO dto) {
		sqlSession.insert("mt.salesIns", dto);

	}

	@Override
	public List<ItemDTO> itemSelectMethod() {
		return sqlSession.selectList("mt.wareSel");
	}

	@Override
	public List<String> pnameSelectMethod() {
		return sqlSession.selectList("mt.pcodeSel");
	}

}
