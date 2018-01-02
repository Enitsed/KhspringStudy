package part06;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class OrderDaoImp implements OrderDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public OrderDaoImp() {

	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insertmethod(OrderDTO dto) {
		sqlSessionTemplate.insert("order.ins", dto);
	}

	@Override
	public List<OrderDTO> selectMethod() {
		return sqlSessionTemplate.selectList("order.all");
	}

} // end class
