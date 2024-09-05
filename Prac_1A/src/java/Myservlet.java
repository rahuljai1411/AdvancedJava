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

/**
 *
 * @author Admin
 */
public class Myservlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Myservlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            int n1=Integer.parseInt(request.getParameter("s1"));
            int n2=Integer.parseInt(request.getParameter("s2"));
            int r;
            
            String op=request.getParameter("Value");
            
            if("+".equals(op)){
                r=n1+n2;
                out.println("<H1>Addition : "+n1+" + "+n2+"="+r+"</H1>");
            }
            else if("-".equals(op)){
                r=n1-n2;
                out.println("<H1>Subtraction : "+n1+" - "+n2+"="+r+"</H1>");
            }
            else if("*".equals(op)){
                r=n1*n2;
                out.println("<H1>Multiplication : "+n1+" * "+n2+"="+r+"</H1>");
            }
            else if("/".equals(op)){
                r=n1/n2;
                out.println("<H1>Division : "+n1+" / "+n2+"="+r+"</H1>");
            }
            
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
