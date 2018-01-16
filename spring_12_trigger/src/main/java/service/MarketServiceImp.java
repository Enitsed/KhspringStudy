package service;

import java.util.List;

import dao.MarketDAO;
import dto.ItemDTO;
import dto.SalesDTO;
import dto.WarehouseDTO;

public class MarketServiceImp implements MarketService {
	private MarketDAO dao;

	public MarketServiceImp() {

	}

	public void setDao(MarketDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertProcess(WarehouseDTO dto) {
		dao.inputInsertMethod(dto);
	}

	@Override
	public void salesInsertProcess(SalesDTO dto) {
		int price = dao.salesSelectMethod(dto.getCode());
		dto.setSaprice(price * dto.getSacnt());
		dao.salesInsertMethod(dto);
	}

	@Override
	public List<ItemDTO> itemSelectProcess() {
		return dao.itemSelectMethod();
	}

	@Override
	public List<String> pnameSelectProcess() {
		return dao.pnameSelectMethod();
	}

}
