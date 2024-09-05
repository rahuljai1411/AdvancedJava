/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class Page4 extends HttpServlet {

   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Page3</title>");            
        out.println("</head>");
        out.println("<body>");
        
        Cookie[] cookies = request.getCookies();
        String nm = null;
        int visitCount = 0;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("n1".equals(cookie.getName())) {
                    nm = cookie.getValue();
                }
                if ("n2".equals(cookie.getName())) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }
        
        visitCount++; // Increment the visit count
        Cookie visitCookie = new Cookie("n2", String.valueOf(visitCount));
        visitCookie.setPath("/");
        response.addCookie(visitCookie); // Update the cookie in the response
        
        out.println("<h1>Visited Count: " + visitCount + "</h1>");
        out.println("<h1>Servlet Page4 at " + nm + "</h1>");
        out.println("<a href=\"Page2\">Visit Page 2</a><br>");
        out.println("<a href=\"Page3\">Visit Page 3</a><br>");
        out.println("<a href=\"Page5\">Visit Page 5</a><br>");
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
