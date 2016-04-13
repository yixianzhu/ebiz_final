<%-- 
    Document   : giftcards
    Created on : Apr 10, 2016, 9:21:34 PM
    Author     : zhuyixian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gift Cards - Seudo</title>
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
            <li><a href="home.html">HOME</a></li>
            <li><a href="Controller?action=menu">MENU</a></li>
            <li><a href="Controller?action=togomenu">ORDER ONLINE</a></li>
            <li><a href="giftcards.jsp">GIFT CARDS</a></li>
            <li><a href="reservations.jsp">RESERVATIONS</a></li>
            <li><a href="contact.jsp">CONTACT</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <br>
    <br>
    <br>
    <!--    card samples        card samples        card samples    -->
    <div class="container">

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
          <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="Pic/giftcard1.jpeg" alt="giftcard1">
          </div>

          <div class="item">
            <img src="Pic/giftcard2.jpeg" alt="giftcard2">
          </div>

          <div class="item">
            <img src="Pic/giftcard3.jpeg" alt="giftcard3">
          </div>

          <div class="item">
            <img src="Pic/giftcard4.jpeg" alt="giftcard4">
          </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>

    <div id="contact" class="container-fluid">
      <h1>GIFT CARDS</h1> 
      <p>SHARE THE Seudo EXPERIENCE</p> 
      <div class="row">
        <div class="col-sm-6">
          <p>At Seudo, every part of the experience has been thought of and designed with care. 
              As Executive Chef and Partner of Seudo, 
              Jessica Bauer’s approach to contemporary American cuisine is refined 
              and modern with a respect for the integrity and quality of her ingredient driven menu. 
              With modern surroundings and higher hospitality, 
              an Seudo Gift Card is perfect for business associates, 
              friends and loved ones with an appreciation for fine dining.
          </p>
        </div>
        <div class="col-sm-6">
          <form class="form-horizontal" role="form">
            <div class="form-group"> 
              <label for="inputFirstName" class="col-sm-4 control-label">Choose Amount</label>
              <div class="col-sm-8">
                  <span class="input-group-addon">$</span>
                  <select class="form-control">
                    <option value="50">50</option>
                    <option value="100">100</option>
                    <option value="150">150</option>
                    <option value="200">200</option>
                    <option value="300">300</option>
                    <option value="500">500</option>
                  </select>
              </div>
            </div>

             <div class="form-group">
                <label for="inputLastName" class="col-sm-4 control-label">Last Name</label>
                <div class="col-sm-8">
                  <input type="lastName" class="form-control" id="inputLastName" />
                </div>
              </div>

              <div class="form-group">
                <label for="inputPhoneNumber" class="col-sm-4 control-label">Phone number</label>
                <div class="col-sm-8">
                  <input type="phoneNumber" class="form-control" id="inputPhoneNumber" />
                </div>
              </div>

              <div class="form-group">
                <label for="inputEmail" class="col-sm-4 control-label">Email</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" id="inputEmail" />
                </div>
              </div>

              <div class="form-group">
                <label for="inputDateTime" class="col-sm-4 control-label">Pick your time</label>
                <div class="col-sm-8">
                    <input type="dateTime" class="form-control" id="inputDateTime" />
                </div>        
              </div>

              <div class="form-group">
                <div class="col-sm-12 form-group">
                  <button class="btn btn-default pull-right" type="submit">Send</button>
                </div>
              </div>
          </form>  
        </div>
      </div>
    </div>
    </body>
</html>
