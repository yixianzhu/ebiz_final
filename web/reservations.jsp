<%-- 
    Document   : reservations
    Created on : Apr 10, 2016, 9:44:04 PM
    Author     : zhuyixian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reservations</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/general.css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <style>
          h3 {
              text-align: center;
              color: #5E5E5E;
              margin-bottom: 7%;
          } 
        </style>
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
            <li><a href="giftcards.jsp">GIFT CARDS</a></li>
            <li><a href="contact.jsp">CONTACT</a></li>
          </ul>
        </div>
      </div>
    </nav>


    <div id="contact" class="container-fluid">
      <h2 class="text-center">RESERVATIONS</h2>
      <div class="row">
        <div class="col-sm-7">
          <p>Seudo is open seven days a week for Lunch and Dinner.</p>
          <p>Our hours of operation are 5:00pm – 10:00pm Monday – Thursday, 5:00pm – 11:00pm Friday and Saturday and 5:00pm – 9:00pm on Sunday. 
              Valet Parking, $6, beginning at 6:00pm. Paid parking is available in our garage before 6:00pm.</p>
          <p>We will be closed on the following days and holidays:
            <ul>
              <li>Super Bowl Sunday</li>
              <li>Memorial Day</li>
              <li>Labor Day</li>
              <li>Thanksgiving Day</li>
              <li>Christmas Eve</li>
              <li>Christmas Day</li>
              <li>New Year’s Day</li>
            </ul></p>    
          <p>To make a reservation please call (412) 904-4442, or simply use the convenient form located on this page. 
              If your party consists of greater than six guests, please call to secure your reservation. 
          </p>
          <p>Our restaurant is two level. Please contact us if there are mobility concerns in your party, 
              as we do not have an elevator. We ask that dress attire be business casual or better. 
              We are located right next to the top station of the Duquesne Incline. 
              Thank you for choosing Seudo.
          </p>
          <p>For group reservation inquiries, give us a call or email <a href="mailto:someone@example.com?Subject=Hello%20again" target="_top">events@xxx.com</a>.</p>
        </div>
        <div class="col-sm-5">

          <form class="form-horizontal" method="post" action="Reservation" role="form">
        <h3 class="center">Online Reservation form</h3>
        <div class="form-group"> 
          <label for="inputFirstName" class="col-sm-4 control-label">First Name</label>
          <div class="col-sm-8">
            <input name="fname" type="text" class="form-control" id="inputFirstName" />
          </div>
        </div>

        <div class="form-group">
          <label for="inputLastName" class="col-sm-4 control-label">Last Name</label>
          <div class="col-sm-8">
            <input name="lname" type="text" class="form-control" id="inputLastName" />
          </div>
        </div>

        <div class="form-group">
          <label for="inputPhoneNumber" class="col-sm-4 control-label">Phone number</label>
          <div class="col-sm-8">
            <input name="phone" type="text" class="form-control" id="inputPhoneNumber" />
          </div>
        </div>

        <div class="form-group">
          <label for="inputEmail" class="col-sm-4 control-label">Email</label>
          <div class="col-sm-8">
            <input name="email" type="text" class="form-control" id="inputEmail" />
          </div>
        </div>
        
        <div class="form-group">
          <label for="inputDate" class="col-sm-4 control-label">Date</label>
          <div class="col-sm-8">
            <input name="date" type="date" class="form-control" id="inputDate" />
          </div>
        </div>
        
        <div class="form-group">
          <label for="inputDateTime" class="col-sm-4 control-label">Pick your time</label>
          <div class="col-sm-8">
            <select name="time" class="form-control">
              <option value="5 pm">5 pm</option>
              <option value="5:30 pm">5:30 pm</option>
              <option value="6 pm">6 pm</option>
              <option value="6:30 pm">6:30 pm</option>
              <option value="7 pm">7 pm</option>
              <option value="7:30 pm">7:30 pm</option>
              <option value="8 pm">8 pm</option>
              <option value="8:30 pm">8:30 pm</option>
            </select>
          </div>        
        </div>

        <div class="form-group">
          <label for="inputGuestNumber" class="col-sm-4 control-label">Number of guests</label>
          <div class="col-sm-8">
            <select name="guest" class="form-control">
              <option value="1">1 person</option>
              <option value="1">2 people</option>
              <option value="3to4">3 to 4 people</option>
              <option value="5to6">5 to 6 people</option>
              <option value="morethan6">more than 6 people</option>
            </select>
          </div>        
        </div>

   <!--     <div class="form-group">
          <div class="col-sm-offset-2 col-sm-12">
            <div class="checkbox">               
              <label><input type="checkbox"/>Yes, I want to receive email messages from XXX.</label>
            </div>
          </div>
        </div>  -->

        <div class="form-group">
          <div class="col-sm-12 form-group">
            <button class="btn btn-default pull-right" type="submit">Send</button>
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
