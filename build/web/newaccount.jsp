<%-- 
    Document   : newaccount
    Created on : Mar 6, 2016, 9:42:43 PM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="result.css"> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Dear, fill out the form to create a new account!</h1>
        <form method = "post" action="CreateAccount" id="c">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="bbname" id="username" /></td>
                    </tr>
                    <tr>
                        <td>Your Real Full name:</td>
                        <td><input type="text" name="fname" id="realname" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" id="password" /></td>
                    </tr>
                    <tr>
                        <td>Account Type:</td>
                        <td><select type="text" name="category" id="category">
                        <option value="customer">Manager</option>
                        <option value="manager">Staff</option>  
                        </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="create" id="submit" /></td>
                    </tr>
                </tbody>
            </table>
            <p><a href ="index.jsp">Back to the first page</a></p>
        </form>
    </body>
</html>
