

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Book</title>
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
        </style>
    </head>
    <body>
        <c:if test="${empty search_type}">
            <div>
                1. <a href="Search?type=name">By Name</a><br>
                2. <a href="Search?type=author">By Author</a><br>
                3. <a href="Search?type=category">By Category</a><br>
            </div>
        </c:if>
        <c:if test="${not empty search_type}">
            <div>
                <form action="Search" method="POST">
                    <c:if test="${search_type == 'name'}">
                        Enter book's name: <input type="text" name="content" placeholder="Book's name" required>
                        <input type="hidden" name="type" value="name">
                    </c:if>
                    <c:if test="${search_type == 'author'}">
                        Enter book's author: <input type="text" name="content" placeholder="Book's author" required>
                        <input type="hidden" name="type" value="author">
                    </c:if>
                    <c:if test="${search_type == 'category'}">
                        Enter book's category: <input type="text" name="content" placeholder="Book's category" required>
                        <input type="hidden" name="type" value="category">
                    </c:if>
                    <br><input type="submit" value="Search">
                </form>
            </div>
        </c:if>
        <div><a href="home.jsp">Back</a></div>
    </body>
</html>
