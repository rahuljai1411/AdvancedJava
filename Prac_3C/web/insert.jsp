<%-- 
    Document   : insert
    Created on : Jul 29, 2024, 7:52:18 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .error {
            color: red;
        }
        .success {
            color: green;
        }
    </style>
    </head>
    <body>
        <form action="insertdb.jsp">
        <table border="0">
            <tr><th colspan="2">Purchase Product </th></tr>
            <tr><td>Product Id</td><td><input type="number" name="id"  value="id"></td></tr>
            <tr><td>Product Name</td><td><input type="text" name="p_name"  ></td></tr>
            <tr><td>Product Quantity</td><td><input type="number" name="p_quantity"  ></td></tr>
            <tr><td><input type="submit" name="submit" value="Submit"></td><td><input type="reset" name="reset" value="Reset"></td></tr>
        </table>
        </form>
   <div class="error">
        <c:if test="${not empty param.errMsg}">
            <c:out value="${param.errMsg}"/>
            <a href="index.html">Go back</a>
        </c:if>
    </div>

    <div class="success">
        <c:if test="${not empty param.susMsg}">
            <c:out value="${param.susMsg}"/>
            <a href="index.html">Go back</a>
        </c:if>
    </div>
    </body>
</html>
