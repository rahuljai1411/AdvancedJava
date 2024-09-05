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
        
        <c:if test="${empty param.id or empty param.p_name or empty param.p_quantity}">
            <c:redirect url="insert.jsp">
                <c:param name="errMsg" value="Enter product details"/>
            </c:redirect>        
        </c:if>  
        
        
        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root"/>
        <sql:update dataSource="${db}" var="rst">
            INSERT INTO product_detail_15 values(?,?,?);
            <sql:param value="${param.id}"/>
            <sql:param value="${param.p_name}"/>
            <sql:param value="${param.p_quantity}"/>
        </sql:update>
            
            <c:if test="${rst>=1}">    
                <c:redirect url="insert.jsp">
                    <c:param name="susMsg" value="Data inserted Successfully"/>
                </c:redirect>    
            </c:if>    
    </body>
</html>
