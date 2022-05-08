package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        HttpSession session = request.getSession();
        session.removeAttribute("userID");
        session.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
