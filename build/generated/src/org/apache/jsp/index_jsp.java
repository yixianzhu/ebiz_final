package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <title>One step before menu</title>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"CSS/menuCSS.css\">\r\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("  <style>\r\n");
      out.write("    body{\r\n");
      out.write("      background:url(\"Pic/walkin_bg.jpg\") no-repeat center fixed;\r\n");
      out.write("      background-size: cover;\r\n");
      out.write("    }\r\n");
      out.write("   .infobox {\r\n");
      out.write("      margin: auto;\r\n");
      out.write("      padding-top: 5%;\r\n");
      out.write("    }\r\n");
      out.write("    form{\r\n");
      out.write("      border-style: solid;\r\n");
      out.write("      border-width: 5px;\r\n");
      out.write("      border-color: orange;      \r\n");
      out.write("    }\r\n");
      out.write("    .buttonwidth{\r\n");
      out.write("       width: 120px !important;\r\n");
      out.write("    }\r\n");
      out.write("    .form-horizontal{\r\n");
      out.write("        background-color: #ffffff;\r\n");
      out.write("        padding: 30px;\r\n");
      out.write("    }\r\n");
      out.write("    p{\r\n");
      out.write("      color: #000000;\r\n");
      out.write("    }\r\n");
      out.write("    h3 {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        color: #000000;\r\n");
      out.write("        margin-bottom: 7%;\r\n");
      out.write("    } \r\n");
      out.write("    footer {\r\n");
      out.write("      position: relative;\r\n");
      out.write("      margin-top: -180px; /* negative value of footer height */\r\n");
      out.write("      height: 180px;\r\n");
      out.write("      clear:both;\r\n");
      out.write("    } \r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("  <body id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\r\n");
      out.write("  <div class=\"col-sm-3\"></div>\r\n");
      out.write("  <div class=\"col-sm-6 infobox\">\r\n");
      out.write("    <form class=\"form-horizontal \" role=\"form\" action='CloginServlet'>\r\n");
      out.write("      <h3 class=\"center\">I have set the default username and password(2,2), which can allow you to log in as a manager. You can also create a new account.</h3>\r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("    <div class=\"form-group\"> \r\n");
      out.write("        <label for=\"uname\" class=\"col-sm-4 control-label\">User name*</label>\r\n");
      out.write("        <div class=\"col-sm-8\">\r\n");
      out.write("          <input type=\"text\" name='bbname' class=\"form-control\" id=\"uname\" />\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <label for=\"pass\" class=\"col-sm-4 control-label\">Password*</label>\r\n");
      out.write("        <div class=\"col-sm-8\">\r\n");
      out.write("          <input type=\"password\" name='password' class=\"form-control\" id=\"pass\" />\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <div class=\"col-sm-12 form-group\">\r\n");
      out.write("          <button class=\"btn btn-warning btn-lg center-block buttonwidth\" type=\"submit\">Let's go</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    <div><a href =\"newaccount.jsp\">Create a new account</a></div>\r\n");
      out.write("    <br/>\r\n");
      out.write("    <div><a href =\"index.html\">Back to starting page</a></div>\r\n");
      out.write("    </form>  \r\n");
      out.write("      \r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"col-sm-3\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <footer class=\"container-fluid text-center\">\r\n");
      out.write("    <p>By Xun Yang, Yixian Zhu</p>\t\t\r\n");
      out.write("  </footer>\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("  $(document).ready(function(){\r\n");
      out.write("    // Add smooth scrolling to all links in navbar + footer link\r\n");
      out.write("    $(\".navbar a, footer a[href='#myPage']\").on('click', function(event) {\r\n");
      out.write("\r\n");
      out.write("      // Prevent default anchor click behavior\r\n");
      out.write("      // event.preventDefault();\r\n");
      out.write("\r\n");
      out.write("      // Store hash\r\n");
      out.write("      var hash = this.hash;\r\n");
      out.write("\r\n");
      out.write("      // Using jQuery's animate() method to add smooth page scroll\r\n");
      out.write("      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area\r\n");
      out.write("      $('html, body').animate({\r\n");
      out.write("        scrollTop: $(hash).offset().top\r\n");
      out.write("      }, 900, function(){\r\n");
      out.write("     \r\n");
      out.write("        // Add hash (#) to URL when done scrolling (default click behavior)\r\n");
      out.write("        window.location.hash = hash;\r\n");
      out.write("      });\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    $(window).scroll(function() {\r\n");
      out.write("      $(\".slideanim\").each(function(){\r\n");
      out.write("        var pos = $(this).offset().top;\r\n");
      out.write("\r\n");
      out.write("        var winTop = $(window).scrollTop();\r\n");
      out.write("          if (pos < winTop + 600) {\r\n");
      out.write("            $(this).addClass(\"slide\");\r\n");
      out.write("          }\r\n");
      out.write("      });\r\n");
      out.write("    });\r\n");
      out.write("  })\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
