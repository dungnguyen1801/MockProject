

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Book</title>
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
        <c:if test="${empty create_message}">
            <div>
                <form action="Create" method="POST">
                    1. Enter the number:<input type="number" name="bid" required placeholder="ID"><br>
                    2. Enter the author:    <input type="text" name="bauthor" required placeholder="Author"><br>
                    3. Enter the category:  <input type="text" name="bcate" required placeholder="Category"><br>
                    4. Enter the brief:     <input type="text" name="bbrief" required placeholder="Brief"><br>
                    5. Enter the title:     <input type="text" name="btitle" required placeholder="Title"><br>
                    6. Enter the publisher: <input type="text" name="bpublisher" required placeholder="Publisher"><br>
                    7.Enter the content:
                    <br><textarea name="bcontent" placeholder="Content" cols="80" rows="8"></textarea><br>
                    <input type="submit" value="Add Book">
                </form>
            </div>
        </c:if>

        <c:if test="${not empty create_message}">
             <span style="color: red;">${create_message}</span>
        </c:if>
        <div><a href="home1.jsp">Back</a></div>
    </body>
</html>
