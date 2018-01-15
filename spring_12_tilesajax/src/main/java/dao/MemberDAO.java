package dao;

import java.util.HashMap;

import dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO checkMember(HashMap<String, String> chk);

}
