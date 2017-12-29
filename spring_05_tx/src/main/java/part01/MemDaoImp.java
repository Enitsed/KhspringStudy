package part01;

import org.mybatis.spring.SqlSessionTemplate;

public class MemDaoImp implements MemDAO {
	private SqlSessionTemplate sqlSession;

	public MemDaoImp() {

	}

	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("", dto);
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

} // end class
