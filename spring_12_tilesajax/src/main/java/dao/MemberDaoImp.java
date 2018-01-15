package dao;

import java.util.HashMap;

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
	public MemberDTO checkMember(HashMap<String, String> chk) {
		return sqlSession.selectOne("member.chk", chk);
	}

}
