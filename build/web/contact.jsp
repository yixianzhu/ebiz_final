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
        <br/><br/><br/>
        <div><p>Open time: 5pm - 11pm (Monday to Sunday) </p></div>
        <div><p>Phone: 412-626-1506 </p></div>
        <div><p>Location: </p></div>
        <script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
        <div style='overflow:hidden;height:440px;width:700px;'>
        <div id='gmap_canvas' style='height:440px;width:700px;'></div><div><small>
        <a href="http://embedgooglemaps.com">embed google maps</a></small>
        </div>
        <div><small><a href="http://www.autohuren.world/">auto huren</a></small></div></div>
        <script type='text/javascript'>
          function init_map(){
          var myOptions = {zoom:10,center:new google.maps.LatLng(40.43717250748518,-79.93825081049808),mapTypeId: google.maps.MapTypeId.ROADMAP};
          map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(40.43717250748518,-79.93825081049808)});
          infowindow = new google.maps.InfoWindow({content:'<strong></strong><br>4628 Bayard Street<br>'});
          google.maps.event.addListener(marker, 'click', function(){infowindow.open(map,marker);});
          infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
    </body>
</html>
