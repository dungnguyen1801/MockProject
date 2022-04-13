

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
        </style>
    </head>
    <body>
        <div>
            Please enter the book's id:
            <form action="Read" method="POST">
                <input type="number" name="book_id" required>
                <input type="submit" value="Read">
            </form>
        </div>
        <div><a href="home.jsp">Back</a></div>
    </body>
</html>
