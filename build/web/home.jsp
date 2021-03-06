<%-- 
    Document   : home
    Created on : Apr 20, 2016, 11:04:47 PM
    Author     : xun yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Welcome to Seudo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="CSS/general.css">
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
        <li><a href="index.html">Back to Starting Page</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Services  Portal -->
<div id="services" class="container-fluid text-center">
  <h2>I want to</h2>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <a href="reservations.jsp">
        <span class="glyphicon glyphicon-pushpin logo-small"></span>
        <h4 id="homelogo">RESERVATIONS</h4>
        <p>Including private dining and special events</p>
      </a>
    </div>
    <div class="col-sm-4">
      <a href="walkin.jsp">
        <span class="glyphicon glyphicon-cutlery logo-small"></span>
        <h4 id="homelogo">WALK IN</h4>
        <p>A sublime, elevated experience</p>
      </a>
    </div>
    <div class="col-sm-4">
      <a href="Controller?action=togomenu">
        <span class="glyphicon glyphicon-send logo-small"></span>
        <h4 id="homelogo">TO GO</h4>
        <p>Enjoy the Seudo delicacy in your place</p>
      </a>
    </div>
  </div>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <a href="Controller?action=menu">
        <span class="glyphicon glyphicon-book logo-small"></span>
        <h4 id="homelogo">MENU</h4>
        <p>At the helm of our newly designed kitchen is Chef Jessica Bauer.</p>
      </a>  
    </div>
    <div class="col-sm-4">
      <a href="giftcards.jsp">
        <span class="glyphicon glyphicon-gift logo-small"></span>
        <h4 id="homelogo">GIFT CARDS</h4>
        <p>Share the Seudo experience</p>
      </a>
    </div>
    <div class="col-sm-4">
      <a href="contact.jsp">
        <span class="glyphicon glyphicon-envelope logo-small"></span>
        <h4 id="homelogo" style="color:#303030;">CONTACT</h4>
        <p>If you want to know more about Seudo</p>
      </a>
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
