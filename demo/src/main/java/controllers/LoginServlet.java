package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.beans.UserBean;
import models.UserModel;

import javax.servlet.http.HttpServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		UserBean bean;
		String destination = "Dashboard.jsp";

		HttpSession session = request.getSession(false);

		try {	
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			UserModel model = new UserModel();

			if(session != null){
				session.invalidate();
			}

			bean = model.getUserByCredentials(user, password);
			if(bean != null){
				session = request.getSession(true);
				session.setAttribute("userID", bean.getUsername());
			}else{
				destination = "LogFail.jsp";
			}

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			return;
		}

		// better redirect...
		//https://stackoverflow.com/questions/39140405/httpservletrequest-object-change-and-session-drops-after-redirect

		request.redirect(destination);
	}
	
}