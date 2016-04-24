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
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="js/validateinput.js"></script>
        <script>
        function deliveryMethod1() {
          document.getElementById("receiverEmail").style.visibility = "visible";
          document.getElementById("inputReceiverEmail").required = true;
        }
        function deliveryMethod2() {
          document.getElementById("receiverEmail").style.visibility = "hidden";
          document.getElementById("inputReceiverEmail").required = false;
        }
        </script>
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

    <br/>
    <br/>
    <br/>
    <!--    card samples        card samples        card samples    -->
    <div class="container">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
      <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-top:5%">
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
      <div class="col-sm-3"></div>
    </div>

    <div id="contact" class="container-fluid">
      <div class="row">
        <div class="col-sm-6">
          <h2>GIFT CARDS</h2> 
          <p>SHARE THE Seudo EXPERIENCE</p> 
          <p id="giftcard_p">
            At Seudo, every part of the experience has been thought of and designed with care.<br/>
            As Executive Chef and Partner of Seudo, Jessica Bauer’s approach to contemporary American cuisine is refined and modern with a respect for the integrity and quality of her ingredient driven menu.<br/>
            With modern surroundings and higher hospitality, a Seudo Gift Card is perfect for business associates, friends and loved ones with an appreciation for fine dining.
          </p>
        </div>
        <div class="col-sm-6">
          <form class="form-horizontal" role="form"  action='giftCardController'>            
            <div class="row">
              <div class="column">
                <legend>To</legend>
              </div>
              <div class="column">
                <div class="col-sm-4">
                  <input type="text" placeholder="Name" class="form-control" id="inputReceiverName" name="inputReceiverName" onkeyup="checkReceiverName(); return false;" required/><span class="status10"></span>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="column">
                <legend>From</legend>
              </div>
              <div class="column">
                <div class="col-sm-4">
                  <input type="text" placeholder="Your Name" class="form-control" id="inputSenderName" name="inputSenderName" onkeyup="checkSenderName(); return false;" required/><span class="status11"></span>
                </div>
                <div class="col-sm-8">
                  <input type="email" placeholder="Your Email" class="form-control" id="inputSenderEmail" name="inputSenderEmail" onkeyup="checkSenderEmail(); return false;" required/><span class="status12"></span>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="column">
                <legend>Personal Note</legend>
              </div>
              <div class="column">
                <div>
                  <textarea class="form-control" rows="3" id="inputPersonalNote" name="inputPersonalNote"></textarea>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="column">
                <legend>Gift Type</legend>
              </div>
              <div class="radio-group column">
                <div class="radio-set row">
                  <div class="col-sm-8">
                    <label>Choose Amount
                    <div class='item-terms'>
                      <div class='term'>
                        Terms: No expiration date, service charges, or dormancy fees. This certificate will not be replaced if lost or stolen. Not redeemable for cash, except as required by law.
                      </div>
                    </div>
                    </label>
                  </div>
                  <div class="col-sm-4">
                    <i class="fa fa-dollar"></i>
                    <select class="amount" name="gift_card_amount">
                    <option value="20.00">20.00</option>
                    <option value="25.00">25.00</option>
                    <option value="30.00">30.00</option>
                    <option value="35.00">35.00</option>
                    <option value="40.00">40.00</option>
                    <option value="45.00">45.00</option>
                    <option value="50.00">50.00</option>
                    <option value="55.00">55.00</option>
                    <option value="60.00">60.00</option>
                    <option value="65.00">65.00</option>
                    <option value="70.00">70.00</option>
                    <option value="75.00">75.00</option>
                    <option value="80.00">80.00</option>
                    <option value="85.00">85.00</option>
                    <option value="90.00">90.00</option>
                    <option value="95.00">95.00</option>
                    <option selected="selected" value="100.00">100.00</option>
                    <option value="105.00">105.00</option>
                    <option value="110.00">110.00</option>
                    <option value="115.00">115.00</option>
                    <option value="120.00">120.00</option>
                    <option value="125.00">125.00</option>
                    <option value="130.00">130.00</option>
                    <option value="135.00">135.00</option>
                    <option value="140.00">140.00</option>
                    <option value="145.00">145.00</option>
                    <option value="150.00">150.00</option>
                    <option value="155.00">155.00</option>
                    <option value="160.00">160.00</option>
                    <option value="165.00">165.00</option>
                    <option value="170.00">170.00</option>
                    <option value="175.00">175.00</option>
                    <option value="180.00">180.00</option>
                    <option value="185.00">185.00</option>
                    <option value="190.00">190.00</option>
                    <option value="195.00">195.00</option>
                    <option value="200.00">200.00</option>
                    <option value="205.00">205.00</option>
                    <option value="210.00">210.00</option>
                    <option value="215.00">215.00</option>
                    <option value="220.00">220.00</option>
                    <option value="225.00">225.00</option>
                    <option value="230.00">230.00</option>
                    <option value="235.00">235.00</option>
                    <option value="240.00">240.00</option>
                    <option value="245.00">245.00</option>
                    <option value="250.00">250.00</option></select>
                  </div>
                </div>
              </div>
            </div>

            <div class="radio-group row">
              <legend>Delivery Method</legend>
              <div class="column">
                <div class="row">                    
                  <div class="col-sm-6">
                    <label class="radio-inline" >
                      <input type="radio" value="email" checked="checked" name="order_form" id="order_form_delivery_method_email" onchange="deliveryMethod1()"/>
                      Email to recipient
                    </label>
                  </div>
                  <div class="col-sm-6">
                    <label class="radio-inline" >
                      <input type="radio" value="self" name="order_form" id="order_form_delivery_method_self" onchange="deliveryMethod2()"/>Email me a printable version
                    </label>                     
                  </div>
                  <div class="col-sm-8" id="receiverEmail">   
                    <label for="order_form_recipient_email">Email To</label>               
                    <input type="email" placeholder="Email" class="form-control" id="inputReceiverEmail" name="inputReceiverEmail" onkeyup="checkReceiverEmail(); return false;" required/><span class="status13"></span> 
                  </div>
                </div>
              </div>
              <div class="checkbox" style="text-align:right">              
                <label><input type="checkbox" name="receiveEmail" value="yesplease"/>Yes, I want to receive email from Seudo.</label>
              </div>            
              <div class="form-group">
                <div class="col-sm-12 form-group" style="text-align:center; margin-top:10px">
                  <input type="hidden" name="action" value="purchaseGiftCard"/>
                  <input type="submit" name="purchaseGiftCard" value="Purchase"/>
                </div>
              </div>
            </div>
          </form>  
        </div>
      </div>
    </div>
    </body>
</html>
