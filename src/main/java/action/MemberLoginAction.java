package action;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.ActionForward;
import vo.MemberVO;

public class MemberLoginAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��û ó���� ���ְ� ������ ������ �������ִ� ����
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		
		LoginService loginService = new LoginService();
		
		MemberVO loginMember = loginService.getLoginMember(memberId, memberPassword);

		ActionForward forward = null;
		
		if(loginMember != null) {				
			//������ �̿��� �α��� ó��
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			forward = new ActionForward();
			forward.setUrl("index.jsp");
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('��������')");
			out.println("history.back()");	//history.go(-1) ������ ���������� �̵�
			out.println("</script>");
		}
		return forward;
	}

}
