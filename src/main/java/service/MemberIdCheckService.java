package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberIdCheckService {

   public boolean existMemberId(String memberId) {
      boolean memberIdExist = false;      //최종아이디 존재여부.
      
      Connection con = getConnection();      //LoginService.java 에서 들고옴.
      MemberDAO memberDAO = MemberDAO.getInstance();
      memberDAO.setConnection(con);      //connection주입
      
      String dbMemberId = memberDAO.selectMemberId(memberId);
      if(dbMemberId != null) {
         memberIdExist = true;
      }
      close(con);
      return memberIdExist;         //action으로 리턴
   }

}