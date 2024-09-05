<%-- 
    Document   : Registration
    Created on : Jul 15, 2024, 8:04:52 AM
    Author     : Admin
--%>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%
        String s1 = request.getParameter("name");
         String s2 = request.getParameter("password");
          String s3 = request.getParameter("repassword");
           String s4 = request.getParameter("email");
            String s5 = request.getParameter("country");
            if(s2.equals(s3))
            {
                try{
                //database connectivity code
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                PreparedStatement pst = conn.prepareStatement("insert into regisrtation_15 values(?,?,?,?)");
                pst.setString(1,s1);
                pst.setString(2,s2);
                pst.setString(3,s4);
                pst.setString(4,s5);
                
                int rows = pst.executeUpdate();
                if(rows==1)
                {
                    out.println("Registeration Successful...!");
                }
                else{
                    out.println("Registeration failed...! Try again");
                %>
                <jsp:include page="Register.html"></jsp:include>              
                <%
                }
                }
                catch(Exception e){
                    out.print("Exception : "+e);
                }
            }
            else
            {
            out.print("password mismatch re enter all details again");
            
              %>
              <jsp:include page="Register.html"></jsp:include>     
             <%
                 }
         %>>
    </body>
</html>
