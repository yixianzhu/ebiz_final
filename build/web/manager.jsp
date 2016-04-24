<%-- 
    Document   : index
    Created on : Mar 29, 2016, 11:01:29 PM
    Author     : xun yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="CSS/manager.css">
        <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>        
        <title>Seudo</title>
        <style type="text/css">
/*table, td, th
{
border:1px solid red;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}*/
/*body
{
	text-align: center;
}*/
/*.container
{
	margin-left: auto;
	margin-right: auto;
	width: 40em;
}*/
/*h2
{
	font-family: 'Oxygen', sans-serif;
	color:#1E90FF;
}*/
img{
    height: 100%;
      width: 100%;
      margin:0 auto;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    var notify='notify';
    console.log(notify);
    showNotification();
           //      $.get('ReservationNotification',{notification:notify},function(responseText) { 
                 //   $.get('ReservationNotification',function(responseText) { 
                //        $('#notification').text(responseText);         
                //    });

   // $("#tablediv").hide();
    $("#tablediv2").hide();
    $("#tablediv3").hide();
   // showMenu();
    refreshTable();
    $("#showTable").click(function(event){
    $("#tablediv2").hide();
    $("#tablediv3").hide();
    refreshTable();
    $("#tablediv").show();
    });
    $("#showTogo").click(function(event){
    $("#tablediv").hide();
    $("#tablediv2").hide();
    showTogo();
    $("#tablediv3").show();
    });
    $("#menu").click(function(event){
    $("#tablediv").hide();
    $("#tablediv3").hide();
    showMenu();
    $("#tablediv2").show();
    });
    });
    function showNotification(){
         $.get('ReservationNotification',function(responseText) { 
             setTimeout(showNotification, 2000);
                        $('#notification').text(responseText);         
                    });
    }

    function refreshTable(){
        
	// $("#tablediv").hide();
   //  $("#showTable").click(function(event){
           $.get('PopulateTable',function(responseJson) {
               setTimeout(refreshTable, 2000);
        	   if(responseJson!=null){
                   
            	   $("#mealtable1").find("tr:gt(0)").remove(); //remove all rows except the first
            	   var table1 = $("#mealtable1");
                  $("#mealtable2").find("tr:gt(0)").remove(); //remove all rows except the first
            	  var table2 = $("#mealtable2");
	               $.each(responseJson, function(key,value) { 
                               if(value['status']=='Not served'){
	               	       var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td><a href=\"TableController?action=serve&tableid="+value['tableid']+"&mealid="+value['id']+"\">Serve it</a></td></tr>");
                           }
                               else if(value['status']=='served'){
                                var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");    
                               }
                               rowNew.children().eq(0).text(value['tableid']); 
	                       rowNew.children().eq(1).text(value['id']); 
	                       rowNew.children().eq(2).text(value['name']); 
                               rowNew.children().eq(3).text(value['category']);
	                       rowNew.children().eq(4).text(value['quantity']); 
                               rowNew.children().eq(5).text(value['price']); 
                               rowNew.children().eq(6).text(value['status']);
                                 
                               if (value['tableid']=='1'){
                               rowNew.appendTo(table1); 
                               }
                               else if (value['tableid']=='2'){
                               rowNew.appendTo(table2); 
                               }
	               });
                }
            });
}
function showTogo(){
        
	// $("#tablediv").hide();
   //  $("#showTable").click(function(event){
           $.get('TogoOrder',function(responseJson) {
               setTimeout(showTogo, 2000);
        	   if(responseJson!=null){
                   
            	   $("#togo").find("tr:gt(0)").remove(); //remove all rows except the first
            	   var pick = $("#togo");
             //     $("#mealtable2").find("tr:gt(0)").remove(); //remove all rows except the first
            //	  var table2 = $("#mealtable2");
	               $.each(responseJson, function(key,value) { 
                           //    if(value['status']=='Not served'){
	               	       var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td><a href=\"TogoController?action=cook&orderid="+value['orderid']+"\">Finish</a></td><td></td><td><a href=\"TogoController?action=collect&orderid="+value['orderid']+"\">Finish</a></td><td><a href=\"TogoController?action=delete&orderid="+value['orderid']+"\">Delete</a></td></tr>");
                               rowNew.children().eq(0).text(value['orderid']); 
	                       rowNew.children().eq(1).text(value['cname']); 
	                       rowNew.children().eq(2).text(value['phone']); 
                               rowNew.children().eq(3).text(value['orderTime']);
	                       rowNew.children().eq(4).text(value['orderContent']); 
                               if (value['cooked']=='false'){
                               rowNew.children().eq(5).text('No'); }
                               else if (value['cooked']=='true'){
                               rowNew.children().eq(5).text('Yes'); }
                               if (value['collected']=='false'){
                               rowNew.children().eq(7).text('No'); }
                               else if (value['collected']=='true'){
                               rowNew.children().eq(7).text('Yes'); }                         
                              rowNew.appendTo(pick); 
	               });
                }
            });
}
    function showMenu(){
        
	// $("#tablediv").hide();
   //  $("#showTable").click(function(event){
           $.get('ManageMenu',function(responseJson) {
            //   setTimeout(showMenu, 2000);
        	   if(responseJson!=null){
            	   $("#mealmenu").find("tr:gt(0)").remove(); //remove all rows except the first
            	   var table1 = $("#mealmenu");
	               $.each(responseJson, function(key,value) {
                              console.log(value['image']);	              
                       var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td><img src=\""+value['image']+"\"/></td><td><a href=\"Controller?action=edit&mealId="+value['id']+"\">update</a></td><td><a href=\"Controller?action=delete&mealId="+value['id']+"\">delete</a></td></tr>");
                       
	                       rowNew.children().eq(0).text(value['id']); 
	                       rowNew.children().eq(1).text(value['name']); 
	                       rowNew.children().eq(2).text(value['category']); 
                               rowNew.children().eq(3).text(value['description']);
	                       rowNew.children().eq(4).text(value['price']); 
                         //      rowNew.children().eq(5).text("<a href=\"Controller?action=edit&mealId="+value['id']+"\">Update</a>");
                     //    if (value['category']=='starter'){
	                       rowNew.appendTo(table1);
                      //     }
	                       
	               });
                }
            });
          //   $("#tablediv").show();      
          //  });
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
        <li class="active"><a href="#">Home</a></li>
        <li id="showTable"><a href="#">Table Order</a></li>
        <li id="showTogo"><a href="#">Pick-up Order</a></li>
        <li id="menu"><a href="#">Manage Menus</a></li>
        <li id="showReservation"><a href="Reservation?action=see">Reservations<span id="notification" class="label label-warning">!</span></a></li>
        <li><a href="#">Staff</a></li>
        <li><a href="#">Business Analysis</a></li>
      </ul>
    </div>
   </div>
  </nav>
  <div class="container-fluid text-center">
    <div id="tablediv">
      <div class="row">
        <div class="col-md-6 container">
          <h2>Table 1</h2>
          <table cellspacing="5" id="mealtable1"> 
              <tr> 
                <th scope="col">Table Id</th> 
                <th scope="col">Meal Id</th> 
                <th scope="col">Name</th> 
                <th scope="col">Category</th>  
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
                <th scope="col">Status</th>        
                <th scope="col">Action</th>         
              </tr> 
          </table>

          <form role="form" action="Checkout" method="POST" name="checkout">
              <input type="hidden" name="tableid" value="1" />
              <div class="form-group">
                <label for="mealID">Employee ID:</label>
                <input type="text" class="form-control" id="id" placeholder="Enter your ID" name="employeeid"/>
              </div>
          <input type="submit" name="Submit" value="Check out for table 1">
          </form>
        </div>

        <div class="col-md-6 container">
          <h2>Table 2</h2>
          <table cellspacing="5" id="mealtable2"> 
            <tr> 
              <th scope="col">Table Id</th> 
              <th scope="col">Meal Id</th> 
              <th scope="col">Name</th> 
              <th scope="col">Category</th> 
              <th scope="col">Quantity</th>
              <th scope="col">Price</th>
              <th scope="col">Status</th>        
              <th scope="col">Action</th>         
            </tr> 
          </table>
          <form role="form" action="Checkout" method="POST" name="checkout">
            <input type="hidden" name="tableid" value="2" />
              <div class="form-group">
                <label for="id">Employee ID:</label>
                <input type="text" class="form-control" id="employeeid" placeholder="Enter your ID" name="employeeid"/>
              </div>
            <input type="submit" name="Submit" value="Check out for table 2">
          </form>
        </div> 
      </div>
    </div>

    <div id="tablediv2" class="container-fluid">
      <br/> <br/>
      <h2 class="text-center">Manage menus</h2>
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
          <table class="rese text-center" id="mealmenu"> 
              <tr>         
                <td scope="col">Meal ID</td> 
                <td scope="col">Name</td> 
                <td scope="col">Category</td>  
                <td scope="col">Description</td> 
                <td scope="col">Price</td> 
                <td scope="col">Image</td> 
                <td scope="col" colspan="2">Action</td>         
              </tr> 
          </table>
        </div>
        <div class="col-md-2"></div>
      </div><br/><br/>
      <div>
        <button onclick="location.href='Controller?action=insert'" type="button" class="btn btn-primary">
          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add and item
        </button>
      </div>
    </div>


    <div id="tablediv3" class="container-fluid">
      <br/><br/>
      <h2 class="text-center">Pick-up Order</h2>
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
          <table class="rese text-center" id="togo">      
            <tr>         
              <td scope="col">Order ID</td> 
              <td scope="col">Customer Name</td> 
              <td scope="col">Phone</td>  
              <td scope="col">Order Time</td> 
              <td scope="col">Order content</td> 
              <td scope="col" colspan="2">Cooked</td> 
              <td scope="col" colspan="2">Taken-away</td>
              <td scope="col">Action</td>                 
            </tr> 
          </table>
        </div>
        <div class="col-md-2"></div>
      </div><br/><br/>
    </div>
  </body>
</html>
