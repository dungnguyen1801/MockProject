

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View List Book</title>
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
                margin-top: 20px;
            }
    
        </style>
    </head>
    <body>
        <c:if test="${empty book_list}">
            <div>There is not any book in application</div>
        </c:if>
        <c:if test="${not empty book_list}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Brief</th>
                        <th>Publisher</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="b" items="${book_list}">
                        <tr>
                            <td>${b.id}</td>
                            <td>${b.title}</td>
                            <td>${b.author}</td>
                            <td>${b.category}</td>
                            <td>${b.brief}</td>
                            <td>${b.publisher}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </c:if>
            <div><a href="home.jsp">Back</a></div>
    </body>
</html>
