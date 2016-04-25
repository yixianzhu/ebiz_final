<%-- 
    Document   : mlogin
    Created on : Mar 6, 2016, 9:42:43 PM
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
  </style>
</head>
  <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
  <div class="col-sm-3"></div>
  <div class="col-sm-6 infobox">
    <form class="form-horizontal " role="form" action='CloginServlet'>
      <h3 class="center">I have set the default username and password(2,2), which can allow you to log in as a manager. You can also create a new account.</h3>
   
  
    <div class="form-group"> 
        <label for="uname" class="col-sm-4 control-label">User name*</label>
        <div class="col-sm-8">
          <input type="text" name='bbname' class="form-control" id="uname" />
        </div>
      </div>

      <div class="form-group">
        <label for="pass" class="col-sm-4 control-label">Password*</label>
        <div class="col-sm-8">
          <input type="password" name='password' class="form-control" id="pass" />
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-12 form-group">
          <button class="btn btn-warning btn-lg center-block buttonwidth" type="submit">Let's go</button>
        </div>
      </div>
    <div><a href ="newaccount.jsp">Create a new account</a></div>
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