package part01_template;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemDaoImp implements MemDAO {
	private JdbcTemplate jdbcTemplate;

	public MemDaoImp() {

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<MemDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMethod(MemDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMethod(MemDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMethod(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemDTO one(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countMethod() {
		// TODO Auto-generated method stub
		return 0;
	}

}
