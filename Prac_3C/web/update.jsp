<%-- 
    Document   : update
    Created on : Jul 29, 2024, 7:52:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root"/>
        <sql:query dataSource ="${dbsource}" var="result">
         SELECT * from product_detail_15 where product_id = ?; 
        <sql:param value = "${param.product_id}"/>
        </sql:query>
        <center>
        <form action="updatedb.jsp" method="post">
            <table border="1" width="40%">
                <caption>Update Product</caption>
                <tr>   
                <th>Product Name</th>
                <th>Quantity</th>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                       <center><td><input type="TEXT" value="${row.product_id}" name="product_id" >
                        <input type="text" value="${row.product_name}" name="product_name" ></td></center>
                        <td><input type="text" value="${row.product_quantity}" name="quantity" ></td>
                        
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="update" >
                <a href="index.html">Return Home</a>
        </form>
    </center> 
    </body>
</html>
