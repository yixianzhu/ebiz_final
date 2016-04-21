<%-- 
    Document   : manageReservation
    Created on : Apr 19, 2016, 10:04:46 PM
    Author     : xun yang
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
    
</script>
<style>
    h3{
        color: red;
    }
</style>
<title>Show All Meals</title>
</head>
<body>
    <h1> Pick up your favorite food!</h1>
    <table border="2">
        <thead>
            <tr>
                <th>First Name</th>  
                <th>Last Name</th>
                <th>Phone</th>                             
                <th>Email</th>
                <th>Date</th>                
                <th>Time</th>
                <th>Guest</th
             
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
            <form method="post" action="AddToCart" id="send">
                <tr>
                    <td><c:out value="${user.fname}" /><input type="hidden" name="id" value="${meal.id}" /></td>              
                    <td><c:out value="${user.lname}" /></td>
                    <td><c:out value="${user.phone}" /></td>     
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.date}" /></td>
                    <td><c:out value="${user.time}" /></td>                 
                    <td><c:out value="${user.guest}" /></td>
                    <td><input type="submit" name="submit" value="deal with it"/></td>
                </tr>
            </form>
            </c:forEach>
        </tbody>
    </table>
    <br/>
    <div><a href="AddToCart?action=viewcart">See your cart</a></div>
    <br/>
        <div><a href ="index.jsp">Log out</a></div>
</body>
</html>
