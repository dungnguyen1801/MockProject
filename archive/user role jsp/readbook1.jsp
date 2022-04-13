

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Book</title>
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
            h3 {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <c:if test="${empty book_read}">
            <div>This book is not exist!</div>
        </c:if>
        <c:if test="${not empty book_read}">
            <h3>${book_read.title}</h3>
            <div>${book_read.content}</div>
        </c:if>
            <div><a href="home.jsp">Back</a></div>
    </body>
</html>
