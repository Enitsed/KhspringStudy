package part02_daosupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

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

public class MemDaoImp extends JdbcDaoSupport implements MemDAO {

	public MemDaoImp() {

	}

	public List<MemDTO> list() {
		String sql = "select * from mem order by num desc";
		List<MemDTO> list = getJdbcTemplate().query(sql, new RowMapper<MemDTO>() {

			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));

				return dto;
			}
		});
		return list;
	}

	public void insertMethod(MemDTO dto) {
		String sql = "insert into mem values(mem_num_seq.nextval,?,?,?)";
		// 하나여도 배열에 저장해서 넘겨준다.
		Object[] args = new Object[] { dto.getName(), dto.getAge(), dto.getLoc() };
		getJdbcTemplate().update(sql, args);

	}

	public void updateMethod(MemDTO dto) {
		String sql = "update mem set name=? where num=?";
		Object[] args = new Object[] { dto.getName(), dto.getNum() };
		getJdbcTemplate().update(sql, args);

	}

	public void deleteMethod(int num) {
		String sql = "delete from mem where num=?";
		Object[] args = new Object[] { num };
		getJdbcTemplate().update(sql, args);

	}

	public MemDTO one(int num) {
		String sql = "select * from mem where num=?";
		Object[] args = new Object[] { num };
		return getJdbcTemplate().queryForObject(sql, args, new RowMapper<MemDTO>() {
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
	}

	public int countMethod() {
		String sql = "select count(*) from mem";

		// select의 결과값이 하나일때는 queryForObject
		// select의 결과값이 여러개일때는 query
		return getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {

				return rs.getInt(1);
			}
		});
	}

}
