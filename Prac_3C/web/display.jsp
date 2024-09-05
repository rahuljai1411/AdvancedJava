<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/test" user="root" password="root"/>
        <sql:query dataSource="${db}" var="rst">
            select * from product_detail_15;
        </sql:query>
    <center>
        <form>
            Product Details
            <table border="1">
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Quantity</th>
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach var="row" items="${rst.rows}">
                    <tr>
                        <td><c:out value="${row.product_id}"/></td>
                        <td><c:out value="${row.product_name}"/></td>
                        <td><c:out value="${row.product_quantity}"/></td>
                        <td><a href="update.jsp?product_id=<c:out value="${row.product_id}"/>">update</a></td>
                        <td><a href="deletedb.jsp?product_id=<c:out value="${row.product_id}"/>">delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </center>
    </body>
</html>