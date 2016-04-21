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
  <script src="js/validateinput.js"></script>
  <script src="js/jquery.js" type="text/javascript"></script>

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
        <li><a href="home.jsp">HOME</a></li>
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
        <td colspan="4">Subtotal:</td>
        <td colspan="2">$<c:out value="${cart.totalCost}"/></td>
      </tr>
      <tr>
         <form name="item" method="POST" action="CartController">
        <td colspan="4">Tip:</td>
        <td colspan="2">
            $<input type='text' name="tip" value='<c:out value="${cartItem.tip}"/>'  size='2' >
            <input type="submit" name="action" value="set tip"/>
            <!--<input type="submit" name="addTip" value="Add"/>-->
<!--            <button onclick="getElementById('totalcost').innerHTML=<c:out value="${cart.totalCost}+parseInt(getElementById('tips').value)"/>">Add</button>-->
        </td>  
        </form>
      </tr>
      <tr>
        <td colspan="4"></td>
        <td>Total:</td>
        <td colspan="2" id="totalcost"><c:out value="${cart.totalCost+cart.tips}"/></td>
      </tr>
    </table>
    </div>

    <div class="col-sm-6">
      <form class="form-horizontal" role="form" method='POST' action='CartController'>
        <h4>Payment Information</h4><hr>
        <div class="form-group"> 
          <label for="inputNameOnCard" class="col-sm-4 control-label">Name on Card</label>
          <div class="col-sm-8">
            <input type="nameOnCard" class="form-control" id="inputNameOnCard" onkeyup="checkCardName(); return false;" required/><span class="status1"></span>
          </div>
        </div>

        <div class="form-group">
          <label for="inputCardNumber" class="col-sm-4 control-label">Card Number</label>
          <div class="col-sm-8">
            <input type="cardNumber" class="form-control" id="inputCardNumber" onkeyup="checkCardNumber(); return false;" required/><span class="status2"></span>
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
            <input type="securityCode" class="form-control" id="inputSecurityCode" id="inputSecurityNumber" onkeyup="checkSecurityNumber(); return false;" required/><span class="status3"></span>
          </div>
        </div>

        <div class="form-group"> 
          <label for="inputBillingZipCode" class="col-sm-4 control-label">Billing Zip Code</label>
          <div class="col-sm-8">
            <input type="billingZipCode" class="form-control" id="inputBillingZipCode" onkeyup="checkZipCode(); return false;" required/><span class="status4"></span>
          </div>
        </div>

        <h4>Contact Information</h4><hr>
        <div class="form-group">
          <label for="inputFirstName" class="col-sm-4 control-label">First Name</label>
          <div class="col-sm-8">
            <input type="firstName" class="form-control" id="inputFirstName" name="inputFirstName" onkeyup="checkFirstName(); return false;" required/><span class="status5"></span>
          </div>
        </div>

        <div class="form-group">
          <label for="inputLastName" class="col-sm-4 control-label">Last Name</label>
          <div class="col-sm-8">
            <input type="lastName" class="form-control" id="inputLastName" name="inputLastName" onkeyup="checkLastName(); return false;" required/><span class="status6"></span>
          </div>
        </div>

        <div class="form-group">
          <label for="inputEmail" class="col-sm-4 control-label">Email</label>
          <div class="col-sm-8">
            <input type="email" class="form-control" id="inputEmail" name="inputEmail" onkeyup="checkEmail(); return false;" required/><span class="status7"></span>
          </div>
        </div>
        <div class="checkbox" style="text-align:right">              
            <label><input type="checkbox" name="receiveEmail" value="yesplease"/>Yes, I want to receive email from Seudo.</label>
        </div>

        <div class="form-group">
          <label for="inputDateTime" class="col-sm-4 control-label">Pick your time</label>
          <div class="col-sm-8">
              <input type="dateTime" class="form-control" id="inputDateTime" />
          </div>        
        </div>

        <div class="form-group">
          <label for="inputPhoneNumber" class="col-sm-4 control-label">
            <span data-toggle="tooltip" data-placement="bottom" title="Click to see why we need phone number">
              <button type="button" class="btn btn-link" data-toggle="collapse tooltip" data-target="#phoneexplain" style="color:#6B6B6B; text-decoration: underline; font-size:110%">Phone number</button>
            </span>
          </label>
          <div class="col-sm-8">
            <input type="phoneNumber" class="form-control" id="inputPhoneNumber" name="inputPhoneNumber" onkeyup="checkPhoneNumber(); return false;" required/><span class="status9"></span>
          </div>
          <div id="phoneexplain" class="collapse">
    <p>*We’ll only use this information to send your order confirmation.<br/>Phone number is also used to:
          <ul>
            <li>Record your dining history</li>
            <li>Offer you special promotion if eligible</li>
            <li>Send you promotion news or account info through message</li>
            <li>More information please consult our manager</li>
          </ul></p>
  </div>
        </div>

        <div class="form-group">
          <div class="col-sm-12 form-group" style="text-align:center; margin-top:10px">
            <input type="hidden" id="togotips" />
            <input type="hidden" id="togototal" />
            <input type="hidden" name="action" value="togocheckout"/>
            <input type="submit" name="addToCart" value="Place order"/>
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

