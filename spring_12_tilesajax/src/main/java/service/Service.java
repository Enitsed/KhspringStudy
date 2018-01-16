package service;

import dto.MemberDTO;

public interface Service {
	public MemberDTO memChk(MemberDTO dto);

	public void insertMember(MemberDTO dto);

}
