

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit bookcase</title>
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
            a.button {
                -webkit-appearance: button;
                -moz-appearance: button;
                appearance: button;

                text-decoration: none;
                color: initial;
                border: 1px solid black;
                border-radius: 2px;
                background-color: #eee;
                padding-right: 3px;
                padding-left: 3px;
                padding-top: 2px;
                padding-bottom: 2px;
                font-size: 14px;
            }
        </style>
    </head>
    <body>
        <c:if test="${empty bc_message}">
            <c:if test="${empty edit_type}">
                <div>
                    1. <a href="Editbc?action=add">Add New Book</a><br>
                    2. <a href="Editbc?action=remove">Remove a Book</a><br>
                    3. <a href="Editbc?action=clear">Clear Book Case</a><br>
                </div>
            </c:if>
            <c:if test="${not empty edit_type}">
                <div>
                    <form action="Editbc" method="POST">
                        <c:if test="${edit_type == 'add'}">
                            Enter book's id: <input type="number" name="feild" placeholder="Book's id" required>
                            <input type="hidden" name="action" value="add">
                            <br><input type="submit" value="Add">
                        </c:if>
                        <c:if test="${edit_type == 'remove'}">
                            Enter book's id: <input type="number" name="feild" placeholder="Book's id" required>
                            <input type="hidden" name="action" value="remove">
                            <br><input type="submit" value="Remove">
                        </c:if>
                        <c:if test="${edit_type == 'clear'}">
                            Are you sure?
                            <input type="hidden" name="feild" value="-1">
                            <input type="hidden" name="action" value="clear">
                            <br><input type="submit" value="Yes">
                            <a href="Editbc" class="button">Cancel</a>
                        </c:if>

                    </form>
                </div>
            </c:if>
        </c:if>
        
        <c:if test="${not empty bc_message}">
            <div>${bc_message}</div>
        </c:if>

        <div><a href="home.jsp">Back</a></div>
    </body>
</html>
