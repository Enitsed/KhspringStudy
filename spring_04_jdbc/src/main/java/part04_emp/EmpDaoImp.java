package part04_emp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

/*
 * Template 클래스
 * 1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
 * 2. JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
 * 3. 예로 Jdbc인 경우 JdbcTemplate클래스를 제공하고 있으며, JdbcTemplate클래스를
 *    사용함으로써 try~cath~finally 및커넥션 관리를 위한 중복된 코드를 줄이거나
 *    없앨 수 있다.
 *    
 *                             Java JDBC              Spring JDBC
 *    select                 executeQuery( )         query( )
 *    insert, update, delete   executeUpdate( )        update( )
 */

public class EmpDaoImp implements EmpDAO {

	private SqlSessionTemplate sqlSession;

	public EmpDaoImp() {

	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<EmpDTO> list() {
		return sqlSession.selectList("emp.all");
	}

	@Override
	public void insertMethod(EmpDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMethod(EmpDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMethod(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public EmpDTO one(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countMethod() {
		// TODO Auto-generated method stub
		return 0;
	}

}
