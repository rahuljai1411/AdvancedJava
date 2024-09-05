<%-- 
    Document   : updatedb
    Created on : Jul 29, 2024, 7:52:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import = "java.io.* , java.util.* , java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root"/>
        <sql:update dataSource ="${dbsource}" var="count">
                UPDATE product_detail_15 SET product_name=?,product_quantity=?  where product_id="${param.product_id}";
            <sql:param value="${param.product_name}"/>
            <sql:param value="${param.quantity}"/>
        </sql:update>
                    
            <c:if test="${count>=1}">    
                <c:redirect url="display.jsp">
                    <c:param name="susMsg" value="Data inserted Successfully"/>
                </c:redirect>    
            </c:if>

    </body>
</html>
