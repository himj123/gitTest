package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate(); //技记 康开俊 历厘等 葛电 加己阑 力芭

		ActionForward forward = new ActionForward();
		forward.setUrl("index.jsp");
		forward.setRedirect(true);
		
		return forward;
	}

}
