package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MemberIdCheckAction;
import action.MemberLoginAction;
import action.MemberLogoutAction;
import action.MemberRegistAction;
import action.MemberZipSearchAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 요청파악
		String requestURI = request.getRequestURI();
		//요청 URL : http://localhost:8088/MemberProject/login.me
		//requestURI : /MemberProject/login.me
		
		String contextPath = request.getContextPath();
		//애플리케이션 경로
		//contextgPath : /MemberProject
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command = " + command);
		
		//2. 각 요청별로 요청처리
		//다형성을 사용해서
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/login.me")) {
			action = new MemberLoginAction();		//해당 요청을 처리할 액션 생성
			
			try {
				forward = action.execute(request, response);	//요청 처리 후 포워딩 정보를 반환받음
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.me")) {
			action = new MemberLogoutAction();		//해당 요청을 처리할 액션 생성
			
			try {
				forward = action.execute(request, response);	//요청 처리 후 포워딩 정보를 반환받음
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/idCheck.me")) {
			action = new MemberIdCheckAction();		//해당 요청을 처리할 액션 생성
			
			try {
				forward = action.execute(request, response);	//요청 처리 후 포워딩 정보를 반환받음
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/zipSearch.me")) {
			action = new MemberZipSearchAction();		//해당 요청을 처리할 액션 생성
			
			try {
				forward = action.execute(request, response);	//요청 처리 후 포워딩 정보를 반환받음
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberRegist.me")) {
			action = new MemberRegistAction();		//해당 요청을 처리할 액션 생성
			
			try {
				forward = action.execute(request, response);	//요청 처리 후 포워딩 정보를 반환받음
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//3. forward 객체의 정보를 사용해서 포워딩
		if(forward != null) {
			//요청처리가 제대로 됐으면...
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getUrl());
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
