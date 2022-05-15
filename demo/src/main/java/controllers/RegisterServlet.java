package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserModel;

import javax.servlet.http.HttpServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String page = "UserRegistered.jsp";

		try {	
			String user = request.getParameter("username");
			String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");

            UserModel newUser = new UserModel();
            newUser.RegisterUser(user, password, firstname, lastname);
			response.sendRedirect("UserRegistered.jsp");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}
	
}