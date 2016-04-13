<%-- 
    Document   : mlogin
    Created on : Mar 6, 2016, 9:42:43 PM
    Author     : xun yang
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="cb" class="Bean.CalebBean" scope="session" />
        
    </head>
    <body>
        <h1><jsp:getProperty name="cb" property="status" /> Dear Manager</h1>
        <p style="font-size:160%;color:red;">I have set the default username and password(2,2), which can allow you to log in as a manager. You can also create a new account.</p>
        <form method = "post" action="CloginServlet" id="loginfrm">
         <!--   <input type="hidden" name="category" value="manager" /> -->
            <table border="1">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="bbname" id="username" value="2"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" id="password" value="2"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Login" value="Login" id="submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
         <br/><br/>
    <div><a href ="newaccount.jsp">Create a new account</a></div>
    <br/>
    </body>
</html>