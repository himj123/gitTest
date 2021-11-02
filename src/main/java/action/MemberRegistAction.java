package action;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberRegistService;
import vo.ActionForward;
import vo.MemberVO;

public class MemberRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String memberAge = request.getParameter("memberAge");
		String memberEmail = request.getParameter("memberEmail");
		String memberZipCode = request.getParameter("memberZipCode");
		String memberAddr1 = request.getParameter("memberAddr1");
		String memberAddr2 = request.getParameter("memberAddr2");
		String memberTel = request.getParameter("memberTel");
		String memberGender = request.getParameter("memberGender");
		String memberCountry = request.getParameter("memberCountry");
		String memberPasswd = request.getParameter("memberPasswd1");
		
		//DTO(Data Transfer Object)
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberAddr1(memberAddr1);
		memberVO.setMemberAddr2(memberAddr2);
		memberVO.setMemberAge(Integer.parseInt(memberAge));
		memberVO.setMemberCountry(memberCountry);
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberGender(memberGender);
		memberVO.setMemberId(memberId);
		memberVO.setMemberName(memberName);
		memberVO.setMemberPassword(memberPasswd);
		memberVO.setMemberTel(memberTel);
		memberVO.setZipCode(memberZipCode);
		
		MemberRegistService memberRegistService = new MemberRegistService();
		boolean registSuccess = memberRegistService.registMember(memberVO);
		
		ActionForward forward = null;
		if(registSuccess) {
			forward = new ActionForward();
			forward.setUrl("loginForm.html");
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");			
			out.println("history.back()");			
			out.println("</script>");
		}
		
		return forward;
	}

}
