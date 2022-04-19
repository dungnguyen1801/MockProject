
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
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
        <div>${total_result}</div>
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
        <div><a href="home.jsp">Back</a></div>
    </body>
</html>
