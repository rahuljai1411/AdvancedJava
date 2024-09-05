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
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement pst = conn.prepareStatement("select * from regisrtation_15 where name=?");
       
        pst.setString(1, s1); // Set the parameter value for the PreparedStatement
       
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (rs.getString("password").equals(s2)) {
                out.print("Login successful..!!");
            } else {
                out.print("Wrong password..!!");
                %><jsp:include page="register.html"></jsp:include><%
            }
        } else {
            out.print("User name does not exist!!");
            %><jsp:include page="register.html"></jsp:include><%
        }

        // Close resources
        rs.close();
        pst.close();
        conn.close();
    } catch (Exception e) {
        out.print("Exception: " + e);
    }
    %>  
</body>
</html>
