<%-- 
    Document   : mycart
    Created on : Mar 7, 2016, 8:20:01 PM
    Author     : xun yang
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Show All Meals</title>
<style type="text/css">
table, td, th
{
text-align: center;
border:1px solid green;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}
body
{
	text-align: center;
}

img{
    height: 20%;
      width: 20%;
      margin:0 auto;
}
</style>
</head>
<body>
    <h1>Your shopping cart</h1>
    <div id="tablediv2">
<table cellspacing="5" id="mealmenu"> 
    <tr> 
        <th scope="col">Meal Id</th> 
        <th scope="col">Name</th> 
        <th scope="col">Category</th>  
        <th scope="col">Description</th> 
        <th scope="col">Quantity</th> 
        <th scope="col">Price</th> 
        <th scope="col">Image</th>
        <th scope="col" colspan="2">Action</th>         
    </tr> 
    <c:forEach items="${meals}" var="meal">
                <tr>
                    <td><c:out value="${meal.id}" /></td>
                    <td><c:out value="${meal.name}" /></td>
                    <td><c:out value="${meal.category}" /></td>
                    <td><c:out value="${meal.description}" /></td>                     
                    <td><c:out value="${meal.quantity}" /></td>
                    <td><c:out value="${meal.price}" /></td> 
                    <td><img src="${meal.image}"/> </td>
                    <td><a href="ShowTablecart?action=delete&mealId=<c:out value="${meal.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
</table>
    </div>
   <!-- <table border=1>
        <thead>
            <tr>
                <th>Meal Id</th>
                <th>Name</th>
                <th>Category</th>  class="img-responsive" 
                <th>Description</th>       alt=""          
                <th>Quantity</th>
                <th>Price</th>
                <th>     </th>
                <th>     </th>
            </tr>
        </thead>
        <tbody>
           
        </tbody>
    </table>  -->
    <br/>
    <a href="AddToCart?action=confirm">Confirm you order</a>
    <br/>
    <br/>
    <a href="Controller?action=walkinmenu">Continue your shopping</a>
    <br/>
    <p><a href="ShowTablecart?action=clear">Clear the cart</a></p>
    <br/>
    <div><a href ="index.jsp">Log out</a></div>
</body>
</html>