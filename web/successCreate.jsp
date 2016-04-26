<%-- 
    Document   : successCreate
    Created on : Mar 6, 2016, 9:42:23 PM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="result.css"> 
        <title>JSP Page for successful creation</title>
        <jsp:useBean id="cb" class="Bean.CalebBean" scope="session" />
    </head>
    <body>
        <h1><jsp:getProperty name="cb" property="status" /></h1>
        <h1>Your account has been created successfully</h1>
        <%
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        %>
    </body>
</html>
