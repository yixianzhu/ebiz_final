package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Yx Restaurant Homepage </title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("table, td, th\n");
      out.write("{\n");
      out.write("border:1px solid green;\n");
      out.write("font-family: 'Oxygen', sans-serif;\n");
      out.write("}\n");
      out.write("th\n");
      out.write("{\n");
      out.write("background-color:green;\n");
      out.write("color:white;\n");
      out.write("}\n");
      out.write("body\n");
      out.write("{\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write(".container\n");
      out.write("{\n");
      out.write("\tmargin-left: auto;\n");
      out.write("\tmargin-right: auto;\n");
      out.write("\twidth: 40em;\n");
      out.write("}\n");
      out.write("h4\n");
      out.write("{\n");
      out.write("\tfont-family: 'Oxygen', sans-serif;\n");
      out.write("\tcolor:#1E90FF;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function() {\n");
      out.write("    $(\"#tablediv\").hide();\n");
      out.write("    $(\"#tablediv2\").hide();\n");
      out.write("    $(\"#showTable\").click(function(event){\n");
      out.write("    $(\"#tablediv2\").hide();\n");
      out.write("    refreshTable();\n");
      out.write("    $(\"#tablediv\").show();\n");
      out.write("    });\n");
      out.write("    $(\"#menu\").click(function(event){\n");
      out.write("    $(\"#tablediv\").hide();\n");
      out.write("    showMenu();\n");
      out.write("    $(\"#tablediv2\").show();\n");
      out.write("    });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    function refreshTable(){\n");
      out.write("        \n");
      out.write("\t// $(\"#tablediv\").hide();\n");
      out.write("   //  $(\"#showTable\").click(function(event){\n");
      out.write("           $.get('PopulateTable',function(responseJson) {\n");
      out.write("               setTimeout(refreshTable, 2000);\n");
      out.write("        \t   if(responseJson!=null){\n");
      out.write("            \t   $(\"#mealtable\").find(\"tr:gt(0)\").remove(); //remove all rows except the first\n");
      out.write("            \t   var table1 = $(\"#mealtable\");\n");
      out.write("\t               $.each(responseJson, function(key,value) { \n");
      out.write("\t               \t       var rowNew = $(\"<tr><td></td><td></td><td></td><td></td><td><a href=\\\"http://www.google.com\\\">Delete</a></td></tr>\");\n");
      out.write("\t                       rowNew.children().eq(0).text(value['id']); \n");
      out.write("\t                       rowNew.children().eq(1).text(value['name']); \n");
      out.write("\t                       rowNew.children().eq(2).text(value['category']); \n");
      out.write("\t                       rowNew.children().eq(3).text(value['price']); \t                 \n");
      out.write("\t                       rowNew.appendTo(table1);\n");
      out.write("\t               });\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("          //   $(\"#tablediv\").show();      \n");
      out.write("          //  });\n");
      out.write("               \n");
      out.write("\t      \n");
      out.write("}\n");
      out.write("    function showMenu(){\n");
      out.write("        \n");
      out.write("\t// $(\"#tablediv\").hide();\n");
      out.write("   //  $(\"#showTable\").click(function(event){\n");
      out.write("           $.get('ManageMenu',function(responseJson) {\n");
      out.write("            //   setTimeout(showMenu, 2000);\n");
      out.write("        \t   if(responseJson!=null){\n");
      out.write("            \t   $(\"#mealmenu\").find(\"tr:gt(0)\").remove(); //remove all rows except the first\n");
      out.write("            \t   var table1 = $(\"#mealmenu\");\n");
      out.write("\t               $.each(responseJson, function(key,value) {\n");
      out.write("                              console.log(value['image']);\n");
      out.write("\t               //     var rowNew = $(\"<tr><td></td><td></td><td></td><td></td><td><a href=\\\"http://www.google.com\\\">Delete\"+value['id']+ \"</a></td></tr>\");\n");
      out.write("                       var rowNew = $(\"<tr><td></td><td></td><td></td><td></td><td></td><td><img src=\\\"\"+value['image']+\"\\\"/></td><td><a href=\\\"Controller?action=edit&mealId=\"+value['id']+\"\\\">update</a></td><td><a href=\\\"Controller?action=delete&mealId=\"+value['id']+\"\\\">delete</a></td></tr>\");\n");
      out.write("                       \n");
      out.write("\t                       rowNew.children().eq(0).text(value['id']); \n");
      out.write("\t                       rowNew.children().eq(1).text(value['name']); \n");
      out.write("\t                       rowNew.children().eq(2).text(value['category']); \n");
      out.write("                               rowNew.children().eq(3).text(value['description']);\n");
      out.write("\t                       rowNew.children().eq(4).text(value['price']); \n");
      out.write("                         //      rowNew.children().eq(5).text(\"<a href=\\\"Controller?action=edit&mealId=\"+value['id']+\"\\\">Update</a>\");\n");
      out.write("\t                       rowNew.appendTo(table1);\n");
      out.write("\t               });\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("          //   $(\"#tablediv\").show();      \n");
      out.write("          //  });\n");
      out.write("               \n");
      out.write("\t      \n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("         <div class=\"container-fluid\">\n");
      out.write("           <div class=\"navbar-header\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Yx Restaurant</a>\n");
      out.write("           </div>\n");
      out.write("           <ul class=\"nav navbar-nav\">\n");
      out.write("             <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("             <li id=\"showTable\"><a href=\"#\">Table Order</a></li>\n");
      out.write("             <li id=\"menu\"><a href=\"#\">Manage the menu</a></li>\n");
      out.write("             <li><a href=\"#\">Manage staff</a></li>\n");
      out.write("             <li><a href=\"#\">View trend</a></li>\n");
      out.write("           </ul>\n");
      out.write("         </div>\n");
      out.write("        </nav>\n");
      out.write("       <div class=\"container\">\n");
      out.write("       <h3>Manage your business</h3>\n");
      out.write("       <p>In our application, you can.....</p>\n");
      out.write("  <!--     <input type=\"button\" value=\"Show Table\" id=\"showTable\"/>  -->\n");
      out.write("<br/>\n");
      out.write("<br/>\n");
      out.write("<div id=\"tablediv\">\n");
      out.write("<table cellspacing=\"5\" id=\"mealtable\"> \n");
      out.write("    <tr> \n");
      out.write("        <th scope=\"col\">Table Id</th> \n");
      out.write("        <th scope=\"col\">Name</th> \n");
      out.write("        <th scope=\"col\">Category</th>         \n");
      out.write("        <th scope=\"col\">Price</th>        \n");
      out.write("        <th scope=\"col\">Action</th>         \n");
      out.write("    </tr> \n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("<div id=\"tablediv2\">\n");
      out.write("<table cellspacing=\"5\" id=\"mealmenu\"> \n");
      out.write("    <tr> \n");
      out.write("        <th scope=\"col\">Meal Id</th> \n");
      out.write("        <th scope=\"col\">Name</th> \n");
      out.write("        <th scope=\"col\">Category</th>  \n");
      out.write("        <th scope=\"col\">Description</th> \n");
      out.write("        <th scope=\"col\">Price</th> \n");
      out.write("        <th scope=\"col\">Image</th>\n");
      out.write("        <th scope=\"col\" colspan=\"2\">Action</th>         \n");
      out.write("    </tr> \n");
      out.write("</table>\n");
      out.write("    <br/> <br/>\n");
      out.write("    <div>\n");
      out.write("    <button onclick=\"location.href='Controller?action=insert'\" type=\"button\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-plus\" aria-hidden=\"true\"></span> Add and item</button>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("       </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
