package dao;

import dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO checkMember(MemberDTO dto);

	public void insertMember(MemberDTO dto);

}
