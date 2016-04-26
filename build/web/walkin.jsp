<%-- 
    Document   : walkin
    Created on : Apr 20, 2016, 11:21:51 PM
    Author     : xun yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>One step before menu</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="CSS/menuCSS.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="js/validateinput.js"></script>
  <style>
    body{
      background:url("Pic/walkin_bg.jpg") no-repeat center fixed;
      background-size: cover;
    }
   .infobox {
      margin: auto;
      padding-top: 5%;
    }
    form{
      border-style: solid;
      border-width: 5px;
      border-color: orange;      
    }
    .buttonwidth{
       width: 120px !important;
    }
    .form-horizontal{
        background-color: #ffffff;
        padding: 30px;
    }
    p{
      color: #000000;
    }
    h3 {
        text-align: center;
        color: #000000;
        margin-bottom: 7%;
    } 
    footer {
      position: relative;
      margin-top: -180px; /* negative value of footer height */
      height: 180px;
      clear:both;
    } 
    .status19{
            color:red;
            font-size: 80%;
          }
  </style>
</head>
  <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
  <div class="col-sm-3"></div>
  <div class="col-sm-6 infobox">
    <form class="form-horizontal " role="form" action='WalkinLogin'>
      <h3 class="center">One step before menu. Please enter:</h3>
    <div class="form-group"> 
        <label for="inputTableNumber" class="col-sm-4 control-label">Table number*</label>
        <div class="col-sm-8">
            <select name="table" class="form-control">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
            </select>
       </div>       
      </div>

      <div class="form-group">
        <label for="inputPhoneNumber" class="col-sm-4 control-label">Phone number*</label>
        <div class="col-sm-8">
          <input type="text" name='phone' class="form-control" id="inputWalkinPhoneNumber" onkeyup="checkWalkinPhoneNumber(); return false;" required/><span class="status19"></span>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-12 form-group">
          <button class="btn btn-warning btn-lg center-block buttonwidth" type="submit">Let's go</button>
        </div>
      </div>

      <div>
       *Phone number is used to:
        <ul>
          <li>Record your dining history</li>
          <li>Offer you special promotion if eligible</li>
          <li>Send you promotion news or account info through message</li>
          <li>More information please consult our manager</li>
        </ul>
      </div>
      <div><a href ="home.jsp">Back to home page</a></div>
    </form>  
  </div>
  <div class="col-sm-3"></div>




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
