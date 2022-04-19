<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Book</title>
           <style>
            div{
                margin-bottom: 10px;
                margin-top: 10px;
                margin-left: 10px;
            }
            body {
                border: 2px solid black;
                margin: 25px;
            }
            table {
                border-collapse: collapse;
                margin-left: 10px;
            }
    
        </style>
    </head>
    <body>
        <c:if test="${empty delete_message}">
            <div>
                <form action="Delete" method="POST">
                    Please enter the number:<input type="number" name="bid" required placeholder="ID"><br>
                    <input type="submit" value="Delete Book">
                </form>
            </div>
        </c:if>

        <c:if test="${not empty delete_message}">
            <span style="color: red;">${delete_message}</span>
        </c:if>
        <div><a href="home1.jsp">Back</a></div>
    </body>
</html>