package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.TravelModel;
import data.beans.TravelBean;


@WebServlet("/travel")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
  maxFileSize = 1024 * 1024 * 4, 
  maxRequestSize = 1024 * 1024 * 5 * 5)
public class TravelServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        String jspPage = "Dashboard.jsp";

        try {
            TravelModel travel = new TravelModel();

            if(request.getParameter("submit") != null){
                
                String codice = request.getParameter("codice");
                String nome = request.getParameter("nome");
                Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                int giorni = Integer.parseInt(request.getParameter("giorni"));
                String citta = request.getParameter("citta");
                String stato = request.getParameter("stato");
                String descrizione = request.getParameter("descrizione");
                InputStream foto = null; // input stream of the upload file
            
                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("image");
                if (filePart != null) {
                    // obtains input stream of the upload file
                    foto = filePart.getInputStream();
                }
                
                travel.insertNewTravel(codice, nome, prezzo, giorni, citta, stato, descrizione, foto);
            }

            List<TravelBean> listOfTravels = travel.getAll();
            request.setAttribute("catalogo", listOfTravels);
            
        } catch (Exception e) {
            jspPage = "Error.jsp";
            request.setAttribute("error", e.getMessage());
        }

        request.getRequestDispatcher(jspPage).include(request, response);
    }
}
