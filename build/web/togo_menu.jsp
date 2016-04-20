<%-- 
    Document   : menu
    Created on : Apr 1, 2016, 2:20:36 PM
    Author     : xun yang
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Menu - Seudo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="CSS/general.css">
  <link rel="stylesheet" href="CSS/menu.css">
  <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  <script src="buttonscript.js"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<script  type="text/javascript">  
    $(document).ready(function(){
        $('#addToCart').click(function () { 
        $('#TotalOrder').html(function(i, val) { return val*1+1; });
        //    toastr.success('message', 'title'); });
     //  toastr.info('add one item', 'Succcessfully'); });
        toastr.success('add one item', 'Succcessfully'); });
      //   toastr.success('add one item', 'Succcessfully',position:'middle-center'); });
        //    showStickySuccessToast();});
      });
    
</script>
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
        <li><a href="home.html">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MENU <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#starters">Starters<span class="badge">5</span></a></li>
            <li><a href="#sandwiches">Sandwiches</a></li>
            <li><a href="#entries">Entries</a></li>
            <li><a href="#dessert">Dessert</a></li>
            <li><a href="#drinks">Drinks</a></li>
          </ul>
        </li>
        <li><a href="togo_order.jsp">MY ORDERS<span id="TotalOrder" class="badge">0</span></a></li>
        <li><a href="giftcards.jsp">GIFT CARDS</a></li>
        <li><a href="reservations.jsp">RESERVATIONS</a></li>
        <li><a href="contact.jsp">CONTACT</a></li>
      </ul>
    </div>
  </div>
</nav>
<div id="starters" class="container-fluid text-center">
 <h2>Starters</h2>
 <c:forEach items="${meals}" var="meal">
 <c:if test="${meal.category  == 'starter'}">         
     <div class="col-md-4 container">
      <!--<form name="modelDetail1" method="POST" action="CartController">-->
      <img class="img-responsive" src="${meal.image}" alt="${meal.name}">
      <p class="floating-left">${meal.name}</p>       
      <p class="floating-right">Price: ${meal.price}</p>
      <form class="floating-right2" id='myform' method='POST' action='CartController' >
          <input type="hidden" name="mealNo" value="${meal.id}">
          <input type="hidden" name="mealName" value="${meal.name}">
          <input type="hidden" name="mealPrice" value="${meal.price}">
          <input type="hidden" name="mealCategory" value="${meal.category}">
          <input type='button' value='-' class='qtyminus' field='${meal.id}' />
          <input type='text' name='${meal.id}' value='0' class='qty' />
          <input type='button' value='+' class='qtyplus' field='${meal.id}' />
          <input type="hidden" name="action" value="add"/>
          <input type="submit" name="addToCart" value="Add To Cart"/>
          <!-- <button type="button" id="addToCart">Add To Cart</button> -->
      </form>
      <p class="after-box">${meal.description}</p>
      <!--</form>-->
    </div>
</c:if>
</c:forEach>
</div>
<div id="sandwiches" class="container-fluid text-center">
 <h2>Sandwiches</h2>
 <c:forEach items="${meals}" var="meal">
 <c:if test="${ meal.category  == 'sandwich'}">         
     <div class="col-md-4 container">
      <img class="img-responsive" src="${meal.image}" alt="${meal.name}">
      <p class="floating-left">${meal.name}</p>       
      <p class="floating-right">Price: ${meal.price}</p>
      <form class="floating-right2" id='myform' method='POST' action='CartController' >
          <input type="hidden" name="mealNo" value="${meal.id}">
          <input type="hidden" name="mealName" value="${meal.name}">
          <input type="hidden" name="mealPrice" value="${meal.price}">
          <input type="hidden" name="mealCategory" value="${meal.category}">
          <input type='button' value='-' class='qtyminus' field='${meal.id}' />
          <input type='text' name='${meal.id}' value='0' class='qty' />
          <input type='button' value='+' class='qtyplus' field='${meal.id}' />
          <input type="hidden" name="action" value="add"/>
          <input type="submit" name="addToCart" value="Add To Cart"/>
      </form>
      <p class="after-box">${meal.description}</p>      
    </div>
</c:if>
</c:forEach>
</div>

<div id="entries" class="container-fluid text-center">
 <h2>Entries</h2>
 <c:forEach items="${meals}" var="meal">
 <c:if test="${ meal.category  == 'entry'}">         
     <div class="col-md-4 container">
      <img class="img-responsive" src="${meal.image}" alt="${meal.name}">
      <p class="floating-left">${meal.name}</p>       
      <p class="floating-right">Price: ${meal.price}</p>
      <form class="floating-right2" id='myform' method='POST' action='CartController' >
          <input type="hidden" name="mealNo" value="${meal.id}">
          <input type="hidden" name="mealName" value="${meal.name}">
          <input type="hidden" name="mealPrice" value="${meal.price}">
          <input type="hidden" name="mealCategory" value="${meal.category}">
          <input type='button' value='-' class='qtyminus' field='${meal.id}' />
          <input type='text' name='${meal.id}' value='0' class='qty' />
          <input type='button' value='+' class='qtyplus' field='${meal.id}' />
          <input type="hidden" name="action" value="add"/>
          <input type="submit" name="addToCart" value="Add To Cart"/>
      </form>
      <p class="after-box">${meal.description}</p>      
    </div>
</c:if>
</c:forEach>
</div>

<div id="dessert" class="container-fluid text-center">
 <h2>Dessert</h2>
 <c:forEach items="${meals}" var="meal">
 <c:if test="${ meal.category  == 'dessert'}">         
     <div class="col-md-4 container">
      <img class="img-responsive" src="${meal.image}" alt="${meal.name}">
      <p class="floating-left">${meal.name}</p>       
      <p class="floating-right">Price: ${meal.price}</p>
      <form class="floating-right2" id='myform' method='POST' action='CartController' >
          <input type="hidden" name="mealNo" value="${meal.id}">
          <input type="hidden" name="mealName" value="${meal.name}">
          <input type="hidden" name="mealPrice" value="${meal.price}">
          <input type="hidden" name="mealCategory" value="${meal.category}">
          <input type='button' value='-' class='qtyminus' field='${meal.id}' />
          <input type='text' name='${meal.id}' value='0' class='qty' />
          <input type='button' value='+' class='qtyplus' field='${meal.id}' />
          <input type="hidden" name="action" value="add"/>
          <input type="submit" name="addToCart" value="Add To Cart"/>
      </form>
      <p class="after-box">${meal.description}</p>      
    </div>
</c:if>
</c:forEach>
</div>

<div id="drink" class="container-fluid text-center">
 <h2>Drinks</h2>
 <c:forEach items="${meals}" var="meal">
 <c:if test="${ meal.category  == 'drink'}">         
     <div class="col-md-4 container">
      <img class="img-responsive" src="${meal.image}" alt="${meal.name}">
      <p class="floating-left">${meal.name}</p>       
      <p class="floating-right">Price: ${meal.price}</p>
      <form class="floating-right2" id='myform' method='POST' action='CartController' >
          <input type="hidden" name="mealNo" value="${meal.id}">
          <input type="hidden" name="mealName" value="${meal.name}">
          <input type="hidden" name="mealPrice" value="${meal.price}">
          <input type="hidden" name="mealCategory" value="${meal.category}">
          <input type='button' value='-' class='qtyminus' field='${meal.id}' />
          <input type='text' name='${meal.id}' value='0' class='qty' />
          <input type='button' value='+' class='qtyplus' field='${meal.id}' />
          <input type="hidden" name="action" value="add"/>
          <input type="submit" name="addToCart" value="Add To Cart"/>
      </form>
      <p class="after-box">${meal.description}</p>      
    </div>
</c:if>
</c:forEach>
</div>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
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