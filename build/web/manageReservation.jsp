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
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="CSS/manager.css">
    <script type="text/javascript">

        
    </script>
    <title>Reservations</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-center text-primary">
                    Unprocessed Reservations
                </h3>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="rese">
                        <table>                
                            <tr>
                                <td>First Name</td>
                                <td>Last Name</td>
                                <td>Phone</td>
                                <td>Email</td>
                                <td>Date</td>
                                <td>Time</td>
                                <td>Guests</td>
                                <td>Processed</td>
                            </tr> 
                            <c:forEach items="${users}" var="user">       
                                <tr>
                                    <td><c:out value="${user.fname}" /><input type="hidden" name="phone" value="${user.phone}" /></td>              
                                    <td><c:out value="${user.lname}" /></td>
                                    <td><c:out value="${user.phone}" /></td>     
                                    <td><c:out value="${user.email}" /></td>
                                    <td><c:out value="${user.date}" /></td>
                                    <td><c:out value="${user.time}" /></td>                 
                                    <td><c:out value="${user.guest}" /></td>
                                    <td><a href="Reservation?action=delete&userid=${user.phone}">Remove</a></td>
                                </tr>         
                            </c:forEach>                
                        </table>
                    </div>
                </div>
            <div class="col-md-2"></div>
        </div>
    </div>    
    <br/><br/><br/>
    <div align="center">*Remove the reservation that has been served</div>
    <br/>
    <div align="center"><a href="manager.jsp">Go back to managing interface</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href ="index.jsp">Log out</a></div>   
    <br/>
    <div align="center"></div>
</body>
</html>
