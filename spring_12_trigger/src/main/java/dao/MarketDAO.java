package dao;

import java.util.List;

import dto.ItemDTO;
import dto.SalesDTO;
import dto.WarehouseDTO;

public interface MarketDAO {
	public void inputInsertMethod(WarehouseDTO dto);
	public int salesSelectMethod(String code);
	public void salesInsertMethod(SalesDTO dto);
	public List<ItemDTO> itemSelectMethod();
	public List<String> pnameSelectMethod();
}//end interface
