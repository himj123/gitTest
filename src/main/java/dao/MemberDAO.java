package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import vo.MemberVO;
import vo.ZipCodeVO;

//DAO(Data Access Object) : DBMS로 SQL 구문을 전송하는 클래스
public class MemberDAO {
	private Connection con;
	// singleton 패턴

	private static MemberDAO instance;

	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;

	}

	public MemberVO selectLoginMember(String memberId, String memberPassword) {
		MemberVO memberVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE memberId = ? AND memberPassword = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPassword);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberAddr1(rs.getString("memberAddr1"));
				memberVO.setMemberAddr2(rs.getString("memberAddr2"));
				memberVO.setMemberAge(rs.getInt("memberAge"));
				memberVO.setMemberCountry(rs.getNString("memberCountry"));
				memberVO.setMemberEmail(rs.getNString("memberEmail"));
				memberVO.setMemberGender(rs.getNString("memberGender"));
				memberVO.setMemberId(rs.getNString("memberId"));
				memberVO.setMemberName(rs.getNString("memberName"));
				memberVO.setMemberPassword(rs.getNString("memberPassword"));
				memberVO.setMemberTel(rs.getNString("memberTel"));
				memberVO.setZipCode(rs.getNString("zipCode"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();// finally에서 사용한거 close
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return memberVO;
	}

	public String selectMemberId(String memberId) {
		// TODO Auto-generated method stub
		String dbMemberId = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT memberId FROM member WHERE memberId = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId); // ?갯수만큼

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbMemberId = rs.getNString("memberId");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();// finally에서 사용한거 close
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dbMemberId;
	}

	public ArrayList<ZipCodeVO> selectZipCodeList(String ro) {
		// TODO Auto-generated method stub
		ArrayList<ZipCodeVO> zipCodeList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM zipCodeTable WHERE ro LIKE ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + ro + "%");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				zipCodeList = new ArrayList<ZipCodeVO>();
				ZipCodeVO zipCodeVO = null;
				
				do {
					zipCodeVO = new ZipCodeVO();
					zipCodeVO.setBunzi(rs.getString("bunzi"));
					zipCodeVO.setDou(rs.getString("do"));
					zipCodeVO.setGu(rs.getString("gu"));
					zipCodeVO.setSi(rs.getString("si"));
					zipCodeVO.setRo(rs.getString("ro"));					
					zipCodeVO.setZipCode(rs.getString("zipCode"));
					zipCodeVO.setZipCodeId(rs.getInt("zipCodeId"));
					
					zipCodeList.add(zipCodeVO);
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return zipCodeList;
	}

	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(memberId, memberName, memberAge, memberEmail,"
				+ "zipCode, memberAddr1, memberAddr2, memberTel, memberGender, memberCountry,"
				+ "memberPassword) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getMemberId());
			pstmt.setString(2, memberVO.getMemberName());
			pstmt.setInt(3, memberVO.getMemberAge());
			pstmt.setString(4, memberVO.getMemberEmail());
			pstmt.setString(5, memberVO.getZipCode());
			pstmt.setString(6, memberVO.getMemberAddr1());
			pstmt.setString(7, memberVO.getMemberAddr2());
			pstmt.setString(8, memberVO.getMemberTel());
			pstmt.setString(9, memberVO.getMemberGender());
			pstmt.setString(10, memberVO.getMemberCountry());
			pstmt.setString(11, memberVO.getMemberPassword());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		
		return insertCount;
	}

}