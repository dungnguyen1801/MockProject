

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
            div{
                margin-bottom: 10px;
                margin-top: 10px;
                margin-left: 10px;
            }
        </style>
    </head>
    <body style="border: 2px solid black; margin: 25px;">
        <div>
            Hello ${user}, Please select function below
        </div>
        <div>
            1. <a href="Create">Add New Book</a><br>
            2. <a href="Update">Update Book's Content</a><br>
            3. <a href="Delete">Delete Book</a><br>
            4. <a href="Logout">Logout</a><br>
        </div>
    </body>
</html>
