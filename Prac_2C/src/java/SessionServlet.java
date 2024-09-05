/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class SessionServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session Information</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession(true);
            String sessionId = null;

            Integer visitCount = (Integer) session.getAttribute("visitCount");
            if (visitCount == null) {
                visitCount = 0;
            }
            visitCount++;            
            if(session.isNew()){
            sessionId = request.getParameter("text");
            session.setAttribute("SessionId", sessionId);
            session.setAttribute("visitCount", visitCount);
            out.println("<h1>wELCOME FOR THE FIRST TIME</h1>");  
            }else{
            sessionId=(String) session.getAttribute("SessionId");
            out.println("<h1>WELCOME AGAIN</h1>");
            out.println("<h1>VISITED COUNT: " + visitCount + "</h1>");  
            }

            out.println("<h1>Session ID: " + sessionId + "</h1>");  
            out.println("<h1>Session Time: " + new java.util.Date(session.getCreationTime()) + "</h1>");
            out.println("<h1>Session count: " + visitCount + "</h1>");
            out.println("<a href=\"Page2\">Visit Page 2</a><br>");
            out.println("<a href=\"Page3\">Visit Page 3</a><br>");
            out.println("<a href=\"Page4\">Visit Page 4</a><br>");
            out.println("<p><a href=\"LogoutServlet\">Logout</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
