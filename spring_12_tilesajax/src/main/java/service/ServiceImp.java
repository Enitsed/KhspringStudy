package service;

import java.util.HashMap;

import dao.MemberDaoImp;
import dto.MemberDTO;

public class ServiceImp implements Service {
	MemberDaoImp dao;

	public MemberDaoImp getDao() {
		return dao;
	}

	public void setDao(MemberDaoImp dao) {
		this.dao = dao;
	}

	public ServiceImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MemberDTO memChk(HashMap<String, String> chk) {
		// TODO Auto-generated method stub
		return dao.checkMember(chk);
	}

}
