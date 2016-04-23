<%-- 
    Document   : giftcards
    Created on : Apr 10, 2016, 9:21:34 PM
    Author     : zhuyixian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contacts - Seudo</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/general.css">
        <link rel="stylesheet" href="CSS/giftcard.css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
        <script type='text/javascript'>
          function init_map(){
          var myOptions = {zoom:10,center:new google.maps.LatLng(40.43717250748518,-79.93825081049808),mapTypeId: google.maps.MapTypeId.ROADMAP};
          map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(40.43717250748518,-79.93825081049808)});
          infowindow = new google.maps.InfoWindow({content:'<strong></strong><br>4628 Bayard Street<br>'});
          google.maps.event.addListener(marker, 'click', function(){infowindow.open(map,marker);});
          infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
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
              <li><a href="Controller?action=menu">MENU</a></li>
              <li><a href="Controller?action=togomenu">ORDER ONLINE</a></li>
              <li><a href="giftcards.jsp">GIFT CARDS</a></li>
              <li><a href="reservations.jsp">RESERVATIONS</a></li>
              <li><a href="contact.jsp">CONTACT</a></li>
            </ul>
          </div>
        </div>
      </nav>
      <div id="contact" class="container-fluid">
        <h2 class="text-center">CONTACT</h2>
        <div class="row" align="center" style="margin-left:20%; margin-right:20%">
          <div class="col-sm-6">          
            <div><p>4628 Bayard Street | Pittsburgh, PA 15211</p></div>
            <div><p>Phone: (412) 904-4442 </p></div>
          </div>
          <div class="col-sm-6">
            <p>
              <strong>Website:</strong>
              <a href="http://www.ischool.pitt.edu/" target="_blank">http://seudopgh.com</a>
            </p>
            <p>
              <strong>Facebook:</strong>
              <a href="https://www.facebook.com/ischoolpitt/?fref=ts" target="_blank">http://facebook.com/seudo</a>
            </p>
            <p>
              <strong>Twitter (Restaurant):</strong>
              <a href="https://twitter.com/iSchool_Pitt" target="_blank">@SeudoPGH</a>
            </p>
          </div>
          <div style='overflow:hidden;height:440px;width:700px;'>
            <div id='gmap_canvas' style='height:440px;width:700px;'></div>
            <div>
              <small><a href="http://embedgooglemaps.com">embed google maps</a></small>
            </div>
            <div>
            <small><a href="http://www.autohuren.world/">auto huren</a></small>
            </div>
          </div>  
        </div>  
      </div>   
    </body>
</html>
