<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Content</title>
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
        <c:if test="${empty update_message}">
            <div>
                <form action="Update" method="POST">
                    Enter the number:<input type="number" name="bid" required placeholder="ID"><br>
                    Enter the content:
                    <br><textarea name="bcontent" placeholder="Content" cols="80" rows="8"></textarea><br>
                    <input type="submit" value="Update">
                </form>
            </div>
        </c:if>
        
        <c:if test="${not empty update_message}">
             <span style="color: red;">${update_message}</span>
        </c:if>
        <div><a href="home1.jsp">Back</a></div>
    </body>
</html>