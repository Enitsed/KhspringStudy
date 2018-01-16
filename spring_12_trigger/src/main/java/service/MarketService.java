package service;

import java.util.List;

import dto.ItemDTO;
import dto.SalesDTO;
import dto.WarehouseDTO;

public interface MarketService {
	public void insertProcess(WarehouseDTO dto);

	public void salesInsertProcess(SalesDTO dto);

	public List<ItemDTO> itemSelectProcess();

	public List<String> pnameSelectProcess();
}// end interface
