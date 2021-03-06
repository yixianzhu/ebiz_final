<%-- 
    Document   : staff
    Created on : Mar 30, 2016, 9:22:31 AM
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
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Yx Restaurant Homepage </title>
        <style type="text/css">
table, td, th
{
border:1px solid red;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}
body
{
	text-align: center;
}
.container
{
	margin-left: auto;
	margin-right: auto;
	width: 40em;
}
h2
{
	font-family: 'Oxygen', sans-serif;
	color:#1E90FF;
}
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
    $("#tablediv2").hide();
    $("#tablediv3").hide();
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
        
           $.get('PopulateTable',function(responseJson) {
               setTimeout(refreshTable, 2000);
        	   if(responseJson!=null){
                   
            	   $("#mealtable1").find("tr:gt(0)").remove(); //remove all rows except the first
            	   var table1 = $("#mealtable1");
                  $("#mealtable2").find("tr:gt(0)").remove(); //remove all rows except the first
            	  var table2 = $("#mealtable2");var table3 = $("#mealtable3");
                  $("#mealtable4").find("tr:gt(0)").remove(); 
            	  var table4 = $("#mealtable4");
                  $("#mealtable5").find("tr:gt(0)").remove(); 
            	  var table5 = $("#mealtable5");
                  $("#mealtable6").find("tr:gt(0)").remove(); 
            	  var table6 = $("#mealtable6");
                  
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
                               else if (value['tableid']=='3'){
                               rowNew.appendTo(table3); 
                               }
                               else if (value['tableid']=='4'){
                               rowNew.appendTo(table4); 
                               }
                               else if (value['tableid']=='5'){
                               rowNew.appendTo(table5); 
                               }
                               else if (value['tableid']=='6'){
                               rowNew.appendTo(table6); 
                               }
	               });
                }
            });
}
function showTogo(){
        
           $.get('TogoOrder',function(responseJson) {
               setTimeout(showTogo, 2000);
        	   if(responseJson!=null){                   
            	   $("#togo").find("tr:gt(0)").remove(); //remove all rows except the first
            	   var pick = $("#togo");          
	               $.each(responseJson, function(key,value) {                          
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
        
	
           $.get('ManageMenu',function(responseJson) {           
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
	                       rowNew.appendTo(table1);                     	                       
	               });
                }
            });
          
 }
</script>
    </head>
    <body>
        <nav class="navbar navbar-default">
         <div class="container-fluid">
           <div class="navbar-header">
            <a class="navbar-brand" href="#">Seudo</a>
            <div><a href ="index.html">Back to starting page</a></div>
           </div>
           <ul class="nav navbar-nav">
             <li class="active"><a href="#">Home</a></li>
             <li id="showTable"><a href="#">Table Order</a></li>
             <li id="showTogo"><a href="#">Pick-up Order</a></li>
             <li id="menu"><a href="#">Manage the menu</a></li>
             <li id="showReservation"><a href="Reservation?action=see">Reservation<span id="notification" class="badge"></span></a></li>
           </ul>
         </div>
        </nav>
   <div class="container">
      
    <br/>
    <br/>

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
                <input type="text" class="form-control" id="id" placeholder="Enter your ID" name="employeeid" size="4"/>
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
                <input type="text" class="form-control" id="employeeid" placeholder="Enter your ID" name="employeeid" size="4"/>
              </div>
            <input type="submit" name="Submit" value="Check out for table 2">
          </form>
        </div> 
        <div class="col-md-6 container">
          <h2>Table 3</h2>
          <table cellspacing="5" id="mealtable3"> 
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
            <input type="hidden" name="tableid" value="3" />
              <div class="form-group">
                <label for="id">Employee ID:</label>
                <input type="text" class="form-control" id="employeeid" placeholder="Enter your ID" name="employeeid" size="4"/>
              </div>
            <input type="submit" name="Submit" value="Check out for table 3">
          </form>
        </div> 
          <div class="col-md-6 container">
          <h2>Table 4</h2>
          <table cellspacing="5" id="mealtable4"> 
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
            <input type="hidden" name="tableid" value="4" />
              <div class="form-group">
                <label for="id">Employee ID:</label>
                <input type="text" class="form-control" id="employeeid" placeholder="Enter your ID" name="employeeid" size="4"/>
              </div>
            <input type="submit" name="Submit" value="Check out for table 4">
          </form>
        </div> 
          <div class="col-md-6 container">
          <h2>Table 5</h2>
          <table cellspacing="5" id="mealtable5"> 
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
            <input type="hidden" name="tableid" value="5" />
              <div class="form-group">
                <label for="id">Employee ID:</label>
                <input type="text" class="form-control" id="employeeid" placeholder="Enter your ID" name="employeeid" size="4"/>
              </div>
            <input type="submit" name="Submit" value="Check out for table 5">
          </form>
        </div> 
          <div class="col-md-6 container">
          <h2>Table 6</h2>
          <table cellspacing="5" id="mealtable6"> 
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
            <input type="hidden" name="tableid" value="6" />
              <div class="form-group">
                <label for="id">Employee ID:</label>
                <input type="text" class="form-control" id="employeeid" placeholder="Enter your ID" name="employeeid" size="4"/>
              </div>
            <input type="submit" name="Submit" value="Check out for table 6">
          </form>
        </div> 
      </div>
    </div>

<div id="tablediv2">
<table cellspacing="5" id="mealmenu"> 
    <tr>         
        <th scope="col">Meal ID</th> 
        <th scope="col">Name</th> 
        <th scope="col">Category</th>  
        <th scope="col">Description</th> 
        <th scope="col">Price</th> 
         <th scope="col">Image</th> 
        <th scope="col" colspan="2">Action</th>         
    </tr> 
</table>
    <br/> <br/>
    <div>
    <button onclick="location.href='Controller?action=insert'" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add and item</button>
    </div>
</div>
<div id="tablediv3">
<table cellspacing="5" id="togo"> 
    <tr>         
        <th scope="col">Order ID</th> 
        <th scope="col">Customer Name</th> 
        <th scope="col">Phone</th>  
        <th scope="col">Order Time</th> 
        <th scope="col">Order content</th> 
        <th scope="col" colspan="2">Cooked</th> 
        <th scope="col" colspan="2">Taken-away</th>
        <th scope="col">Action</th>         
    </tr> 
</table>
    <br/> <br/>
    
</div>
   </div>
    </body>
</html>

