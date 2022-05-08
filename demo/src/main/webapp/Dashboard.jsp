<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.beans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="model.TravelModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
    <head>
        <title>Dashboard</title>
        <link rel="stylesheet" href="style/style.css">
    </head>

    <body>
        <% String user = null; 
           if(session.getAttribute("userID") == null){
               response.sendRedirect("login.jsp");
           }else{
               user = (String)session.getAttribute("userID");
           }
        %>
        
        <div class="header">
            <a href="#" class="logo">WanderLust</a>
            <div class="header-right">
              <a class="active" href="#home">Home</a>
              <a href="#contact">Contatti</a>
              <a href="#cart">Carrello</a>
            </div>
          </div>
        <h3>Hi, <%out.println(user); %></h3>
            <table>
                <tr>
                    <td><p>Foto</p></td>
                    <td><p>Codice</p></td>
                    <td><p>Nome</p></td>
                    <td><p>Prezzo</p></td>
                    <td><p>Numero di giorni</p></td>
                    <td><p>Descrizione</p></td>
                </tr>

                
                <c:forEach items="${catalogo}" var="travel">
                    <tr>
                        <td><img src="data:image/jpg;base64,${travel.getBase64Foto()}" alt="test" width="220" height="351"/></td>
                        <td>${travel.getCodice()}</td>
                        <td>${travel.getNome()}</td>
                        <td>${travel.getPrezzo()}</td>
                        <td>${travel.getGiorni()}</td>
                        <td>${travel.getDescrizione()}</td>
                    </tr>
                </c:forEach>
            </table>

            <button id="myBtn">Open Modal</button>
        
            <div id="myModal" class="modal">
                <!-- <div class="modal-content"> -->
                    
                    <form class="dashboardform" action="travel" method="POST" enctype="multipart/form-data">
                        <span class="close">&times;</span>
                        <p>Codice univoco del viaggio:</p>
                        <input type="text" name="codice" placeholder="Id (6 caratteri)" minlength="6" maxlength="6"required>
                        <p>Nome del viaggio:</p>
                        <input type="text" name="nome" placeholder="Nome" minlegth="4"required>
                        <p>Prezzo in euro:</p>
                        <input type="number" name="prezzo" placeholder="Prezzo" min="1"required>
                        <p>Numero di giorni del viaggio:</p>
                        <input type="number" name="giorni" placeholder="Numero di giorni" min="1" required>
                        <p>Citt&agrave;:</p>
                        <input type="text" name="citta" placeholder="Citt&agrave;" required>
                        <p>Stato:</p>
                        <input type="text" name="stato" placeholder="Stato" required>
                        <p>Descrizione del viaggio:</p>
                        <textarea class="textbox" name="descrizione" placeholder="descrizione" minlength="2" cols="20" rows="4" required></textarea>
                        <input type="file" name="image">
                        <input type="submit" name="submit" value="Aggiungi Prodotto">
                    </form>
                <!-- </div> -->
            </div>
        
        <a href="/demo/logout">Logout</a>
        <script src="scripts/script.js"></script>
        <script>history.forward();</script>
    </body>
</html>