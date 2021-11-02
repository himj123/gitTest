package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.ZipCodeVO;

public class MemberZipSearchService {		//����Ͻ��� ���� search,login

	public ArrayList<ZipCodeVO> searchZipCodeList(String ro) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<ZipCodeVO> zipCodeList = memberDAO.selectZipCodeList(ro);		//���۸޼��� select,update
		close(con);
		
		return zipCodeList;
	}
	
}
