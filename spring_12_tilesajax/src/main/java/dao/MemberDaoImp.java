package dao;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemberDTO;

public class MemberDaoImp implements MemberDAO {
	SqlSessionTemplate sqlSession;

	public MemberDaoImp() {
		// TODO Auto-generated constructor stub
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemberDTO checkMember(MemberDTO dto) {
		return sqlSession.selectOne("member.chk", dto);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		sqlSession.insert("member.insert", dto);
	}

}
