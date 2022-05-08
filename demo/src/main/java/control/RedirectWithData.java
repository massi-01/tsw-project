package control;

import javax.servlet.http.HttpServlet;
import model.TravelModel;
import model.beans.TravelBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;;

@WebServlet("/redir")
public class RedirectWithData extends HttpServlet {

    String destination = "Dashboard.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
       
            try {
                TravelModel model = new TravelModel();
                List<TravelBean> list = model.getAll();

                session.setAttribute("catalogo", list);
                
            } catch (Exception e) {
                destination = "Error.jsp";
                request.setAttribute("error", e.getMessage());
            }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}