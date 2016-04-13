<%-- 
    Document   : meal
    Created on : Mar 7, 2016, 11:36:35 AM
    Author     : xun yang
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <style>
            .form-control{
                width:300px;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add one item</h1>
    <form role="form" action="Controller" method="POST"  enctype="multipart/form-data" name="addMeal">
    <input type="hidden" name="hint" value="<c:out value="${meal.hint}" />" />
    <div class="form-group">
      <label for="mealID">Meal ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter Meal ID" name="id" value="<c:out value="${meal.id}"/>" />
    </div>
    <div class="form-group">
      <label for="name">Meal Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Meal Name" name="name" value="<c:out value="${meal.name}"/>" />
    </div>
    <div class="form-group">
      <label for="category">Meal Category:</label>
      <input type="text" class="form-control" id="category" placeholder="Enter Meal Category" name="category" value="<c:out value="${meal.category}"/>" />
    </div>
    <div class="form-group">
      <label for="description">Meal Description:</label>
      <input type="text" class="form-control" id="description" placeholder="Enter Meal Description" name="description" value="<c:out value="${meal.description}"/>" />
    </div>
    <div class="form-group">
      <label for="price">Meal Price:</label>
      <input type="text" class="form-control" id="price" placeholder="Enter Meal Price" name="price" value="<c:out value="${meal.price}"/>" />
    </div>
    <div class="form-group">
      <label for="name">Meal Picture:</label>
      <input type="file" name="file" id="file" class="form-control"/>
    </div>
    <input type="submit" name="Submit" value="Submit">
  </form>
        <br/>
        <div><a href="meal.jsp">Add another new item.</a></div>
        <br/>
        <div><a href="manager.jsp">Go back to change other items</a></div>
        <br/>
        <div><a href ="index.jsp">Log out</a></div>
    </body>
</html>
