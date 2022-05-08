package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.UserBean;
import model.UserModel;

import javax.servlet.http.HttpServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		UserBean bean;
		String destination = "/redir";

		try {	
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession session = request.getSession(false);
			UserModel model = new UserModel();

			if(session!=null){
				session.invalidate();
			}

			bean = model.getUserByCredentials(user, password);
			if(bean != null){
				HttpSession newsession = request.getSession(true);
				newsession.setAttribute("userID", bean.getUsername());
				request.setAttribute("user", bean);
			}else{
				destination = "LogFail.jsp";
			}

		} catch (Exception e) {
			destination = "Error.jsp";
			request.setAttribute("error", e.getMessage());
		}
		
		request.getRequestDispatcher(destination).forward(request, response);
	}
	
}