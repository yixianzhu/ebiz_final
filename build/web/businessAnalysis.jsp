<%-- 
    Document   : businessAnalysis
    Created on : Apr 24, 2016, 4:10:43 PM
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
    <title>Business Analysis</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-center text-primary">
                    Check which meals are popular
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
                                <td>Meal ID</td>
                                
                                <td>Number of total ordering</td>
                            </tr> 
                            <c:forEach items="${histories}" var="h">       
                                <tr>
                                    <td><c:out value="${h.mealid}"/></td>              
                                    
                                    <td><c:out value="${h.quantity}"/> </td>      
                                </tr>         
                            </c:forEach>                
                        </table>
                    </div>
                </div>
            <div class="col-md-2"></div>
        </div>
    </div>    
    <br/><br/><br/>
    <div align="center"><a href="manager.jsp">Go back to managing interface</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href ="index.jsp">Log out</a></div>   
    <br/>
    <div align="center"></div>
</body>
</html>
