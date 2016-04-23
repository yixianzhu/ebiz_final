<%-- 
    Document   : receipt
    Created on : Apr 21, 2016, 10:30:18 AM
    Author     : xun yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="Bean.CalebBean" scope="session"/>
<jsp:setProperty name="user" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Receipt:</h1>
        <p> The total cost of this time is <jsp:getProperty name="user" property="cost" /> </p>
        
        <div><a href="manager.jsp">Go back to management page</a></div>
    </body>
</html>
