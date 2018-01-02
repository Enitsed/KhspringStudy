package part06;

import java.util.List;

public interface OrderDAO {

	public void insertmethod(OrderDTO dto);

	public List<OrderDTO> selectMethod();

} // end interface
