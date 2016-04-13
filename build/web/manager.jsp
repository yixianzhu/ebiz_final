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
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Yx Restaurant Homepage </title>
        <style type="text/css">
table, td, th
{
border:1px solid green;
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
h4
{
	font-family: 'Oxygen', sans-serif;
	color:#1E90FF;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#tablediv").hide();
    $("#tablediv2").hide();
    $("#showTable").click(function(event){
    $("#tablediv2").hide();
    refreshTable();
    $("#tablediv").show();
    });
    $("#menu").click(function(event){
    $("#tablediv").hide();
    showMenu();
    $("#tablediv2").show();
    });
    });

    function refreshTable(){
        
	// $("#tablediv").hide();
   //  $("#showTable").click(function(event){
           $.get('PopulateTable',function(responseJson) {
               setTimeout(refreshTable, 2000);
        	   if(responseJson!=null){
            	   $("#mealtable").find("tr:gt(0)").remove(); //remove all rows except the first
            	   var table1 = $("#mealtable");
	               $.each(responseJson, function(key,value) { 
	               	       var rowNew = $("<tr><td></td><td></td><td></td><td></td><td><a href=\"http://www.google.com\">Delete</a></td></tr>");
	                       rowNew.children().eq(0).text(value['id']); 
	                       rowNew.children().eq(1).text(value['name']); 
	                       rowNew.children().eq(2).text(value['category']); 
	                       rowNew.children().eq(3).text(value['price']); 	                 
	                       rowNew.appendTo(table1);
	               });
                }
            });
          //   $("#tablediv").show();      
          //  });
               
	      
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
	               //     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td><a href=\"http://www.google.com\">Delete"+value['id']+ "</a></td></tr>");
                       var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td><img src=\""+value['image']+"\"/></td><td><a href=\"Controller?action=edit&mealId="+value['id']+"\">update</a></td><td><a href=\"Controller?action=delete&mealId="+value['id']+"\">delete</a></td></tr>");
                       
	                       rowNew.children().eq(0).text(value['id']); 
	                       rowNew.children().eq(1).text(value['name']); 
	                       rowNew.children().eq(2).text(value['category']); 
                               rowNew.children().eq(3).text(value['description']);
	                       rowNew.children().eq(4).text(value['price']); 
                         //      rowNew.children().eq(5).text("<a href=\"Controller?action=edit&mealId="+value['id']+"\">Update</a>");
	                       rowNew.appendTo(table1);
	               });
                }
            });
          //   $("#tablediv").show();      
          //  });
               
	      
}
</script>
    </head>
    <body>
        <nav class="navbar navbar-default">
         <div class="container-fluid">
           <div class="navbar-header">
            <a class="navbar-brand" href="#">Yx Restaurant</a>
           </div>
           <ul class="nav navbar-nav">
             <li class="active"><a href="#">Home</a></li>
             <li id="showTable"><a href="#">Table Order</a></li>
             <li id="menu"><a href="#">Manage the menu</a></li>
             <li><a href="#">Manage staff</a></li>
             <li><a href="#">View trend</a></li>
           </ul>
         </div>
        </nav>
       <div class="container">
       <h3>Manage your business</h3>
       <p>In our application, you can.....</p>
  <!--     <input type="button" value="Show Table" id="showTable"/>  -->
<br/>
<br/>
<div id="tablediv">
<table cellspacing="5" id="mealtable"> 
    <tr> 
        <th scope="col">Table Id</th> 
        <th scope="col">Name</th> 
        <th scope="col">Category</th>         
        <th scope="col">Price</th>        
        <th scope="col">Action</th>         
    </tr> 
</table>
</div>
<div id="tablediv2">
<table cellspacing="5" id="mealmenu"> 
    <tr> 
        <th scope="col">Meal Id</th> 
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
       </div>
    </body>
</html>
