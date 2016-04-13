<%-- 
    Document   : togo_order
    Created on : Apr 11, 2016, 4:31:47 PM
    Author     : zhuyixian
--%>

<%@page import="Bean.CartBean"%>
<%@page import="java.beans.Beans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>My Order</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="CSS/general.css">
  <link rel="stylesheet" href="CSS/togoorder_css.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">Seudo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="home.html">HOME</a></li>
        <li><a href="Controller?action=togomenu">ORDER ONLINE</a></li>
        <li><a href="giftcards.jsp">GIFT CARDS</a></li>
        <li><a href="contact.jsp">CONTACT</a></li>
      </ul>
    </div>
  </div>
</nav>


<div id="contact" class="container-fluid">
  <h2 class="text-center">MY ORDER - Seudo</h2>
  <div class="row">
    <div class="col-sm-6" id="togo_order_table">
      <table border="1">
        <tr>
          <td><strong>Category</strong></td>
          <td><strong>Name</strong></td>
          <td><strong>Quantity</strong></td>
          <td><strong>Unit Price</strong></td>
          <td><strong>Total</strong></td>
          <td><strong>Delete</strong></td>
        </tr>
        <jsp:useBean id="cart" scope="session" class="Bean.CartBean" />
        <c:if test="${cart.getCartSize()==0}">
          <tr>
              <td colspan="4"><%=cart.getCartSize()%>- Cart is currently empty -<br/>
          </tr>
        </c:if>
        <c:forEach var="cartItem" items="${cart.getCartItems()}" varStatus="counter">
          <form name="item" method="POST" action="CartController">
            <tr>
              <td><c:out value="${cartItem.category}"/></td>
              <td><c:out value="${cartItem.itemName}"/></td>
              <td>
                  <input type='hidden' name='itemNo' value='${cartItem.itemNo}'>
                  <input type='text' name="quantity" value='<c:out value="${cartItem.quantity}"/>' size='2'> 
                  <input type="submit" name="action" value="update">                
              </td>
              <td>$<c:out value="${cartItem.price}"/></td>
              <td>$<c:out value="${cartItem.subSumCost}"/></td>
              <td><input type="submit" name="action" value="delete"></td>
            </tr>
          </form>
        </c:forEach>
      <tr>
        <td colspan="2"> </td>
        <td> </td>
        <td colspan="2">Subtotal:</td>
        <td >$<c:out value="${cart.totalCost}"/></td>
      </tr>
    </table>
    </div>

    <div class="col-sm-6">
      <form class="form-horizontal" role="form">
        <h3 class="center">Online booking form</h3>
        <h4>Payment Information</h4><hr>
        <div class="form-group"> 
          <label for="inputNameOnCard" class="col-sm-4 control-label">Name on Card</label>
          <div class="col-sm-8">
            <input type="nameOnCard" class="form-control" id="inputNameOnCard" />
          </div>
        </div>

        <div class="form-group">
          <label for="inputCardNumber" class="col-sm-4 control-label">Card Number</label>
          <div class="col-sm-8">
            <input type="cardNumber" class="form-control" id="inputCardNumber" />
            <div id="divCardTypes">                                              
              <img src="Pic/card/VISA.png" alt="VISA">                        
              <img src="Pic/card/MASTERCARD.png" alt="MASTERCARD">                        
              <img src="Pic/card/AMEX.png" alt="AMEX">                        
              <img src="Pic/card/DISCOVER.png" alt="DISCOVER">                         
            </div>
          </div>
        </div>

        <div class="form-group">
          <label for="selExpiryM" class="col-sm-4 control-label" id="lblExpiration">Expiration Date </label>
          <div class="col-sm-8">
            <span class="spnSelectParent" id="spnExpiryMonthParent">
                <select name="ctl00$MainContent$selExpiryM" id="selExpiryM" tabindex="8" autocomplete="off">
                  <option value="01">01</option>
                  <option value="02">02</option>
                  <option value="03">03</option>
                  <option selected="selected" value="04">04</option>
                  <option value="05">05</option>
                  <option value="06">06</option>
                  <option value="07">07</option>
                  <option value="08">08</option>
                  <option value="09">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                </select>
            </span>
            <span class="spnSelectParent" id="spnExpiryYearParent">
              <select name="ctl00$MainContent$selExpiryY" id="selExpiryY" tabindex="9" autocomplete="off">
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
              </select>
            </span>  
          </div>             
        </div>

        <div class="form-group"> 
          <label for="inputSecurityCode" class="col-sm-4 control-label">Security Code</label>
          <div class="col-sm-8">
            <input type="securityCode" class="form-control" id="inputSecurityCode" />
          </div>
        </div>

        <div class="form-group"> 
          <label for="inputBillingZipCode" class="col-sm-4 control-label">Billing Zip Code</label>
          <div class="col-sm-8">
            <input type="billingZipCode" class="form-control" id="inputBillingZipCode" />
          </div>
        </div>

        <h4>Contact Information</h4><hr>
        <div class="form-group">
          <label for="inputFirstName" class="col-sm-4 control-label">First Name</label>
          <div class="col-sm-8">
            <input type="firstName" class="form-control" id="inputFirstName" />
          </div>
        </div>

        <div class="form-group">
          <label for="inputLastName" class="col-sm-4 control-label">Last Name</label>
          <div class="col-sm-8">
            <input type="lastName" class="form-control" id="inputLastName" />
          </div>
        </div>

        <div class="form-group">
          <label for="inputEmail" class="col-sm-4 control-label">Email</label>
          <div class="col-sm-8">
            <input type="email" class="form-control" id="inputEmail" />
          </div>
        </div>
        <div class="checkbox">               
            <label><input type="checkbox"/>Yes, I want to receive messages from XXX.</label>
        </div>

        <div class="form-group">
          <label for="inputDateTime" class="col-sm-4 control-label">Pick your time</label>
          <div class="col-sm-8">
              <input type="dateTime" class="form-control" id="inputDateTime" />
          </div>        
        </div>


        <div class="form-group">
          <label for="inputPhoneNumber" class="col-sm-4 control-label">Phone number*</label>
          <div class="col-sm-8">
            <input type="phoneNumber" class="form-control" id="inputPhoneNumber" />
          </div>
        </div>

        <div><p>*We’ll only use this information to send your order confirmation.<br>Phone number is also used to:
          <ul>
            <li>Record your dining history</li>
            <li>Offer you special promotion if eligible</li>
            <li>Send you promotion news or account info through message</li>
            <li>More information please consult our manager</li>
          </ul></p>
        </div>



        <div class="form-group">
          <div class="col-sm-12 form-group">
            <button class="btn btn-default pull-right" type="submit">Place order</button>
          </div>
        </div>
      </form>  
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>By Xun Yang, Yixian Zhu</p>		
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Prevent default anchor click behavior
    // event.preventDefault();

    // Store hash
    var hash = this.hash;

    // Using jQuery's animate() method to add smooth page scroll
    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
    $('html, body').animate({
      scrollTop: $(hash).offset().top
    }, 900, function(){
   
      // Add hash (#) to URL when done scrolling (default click behavior)
      window.location.hash = hash;
    });
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})
</script>

</body>
</html>

