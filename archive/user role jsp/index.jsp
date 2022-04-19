
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
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
            Welcome to Read book Application! Please enter your username and password!
        </div>
        <div>
            <form action="Login" method="POST">
                <span>Username: </span><br> <input type="text" name="username" placeholder="Enter Username" required>
                <br>
                <span>Password: </span><br> <input type="password" name="password" placeholder="Enter Password" required>
                <br>
                <input type="submit" value="Login">
            </form>
            <span style="color: red">${login_message}</span>
        </div>
    </body>
</html>
