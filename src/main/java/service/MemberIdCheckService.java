package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberIdCheckService {

   public boolean existMemberId(String memberId) {
      boolean memberIdExist = false;      //�������̵� ���翩��.
      
      Connection con = getConnection();      //LoginService.java ���� ����.
      MemberDAO memberDAO = MemberDAO.getInstance();
      memberDAO.setConnection(con);      //connection����
      
      String dbMemberId = memberDAO.selectMemberId(memberId);
      if(dbMemberId != null) {
         memberIdExist = true;
      }
      close(con);
      return memberIdExist;         //action���� ����
   }

}