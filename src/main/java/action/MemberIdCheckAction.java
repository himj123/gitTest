package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberIdCheckService;
import vo.ActionForward;

public class MemberIdCheckAction implements Action {      //service에서 받아옴

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String memberId = request.getParameter("memberId");
      
      MemberIdCheckService memberIdcheckService = new MemberIdCheckService();
      
      boolean memberIdExist = memberIdcheckService.existMemberId(memberId);
      
      request.setAttribute("memberId", memberId);      //화면에 ~~아이디를 알아야함으로 아이디 공유
      request.setAttribute("memberIdExist", memberIdExist);
      ActionForward forward = new ActionForward();
      forward.setUrl("idCheck.jsp");
      return forward;
   }

}