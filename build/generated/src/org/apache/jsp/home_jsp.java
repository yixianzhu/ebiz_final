package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Welcome to Seudo</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/general.css\">\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>  \n");
      out.write("</head>\n");
      out.write("<body id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"#myPage\">Seudo</a>\n");
      out.write("    </div>\n");
      out.write("<!--    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        <li><a href=\"home.html\" >Home</a></li>\n");
      out.write("        <li><a href=\"Controller?action=menu\" title=\"Menu\">Menu</a></li>\n");
      out.write("        <li><a href=\"myorder.html\">MY ORDERS<span class=\"badge\">7</span></a></li> 记得改！！！！！！ \n");
      out.write("      </ul>\n");
      out.write("    </div>-->\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<!-- Services  Portal -->\n");
      out.write("<div id=\"services\" class=\"container-fluid text-center\">\n");
      out.write("  <h2>I want to</h2>\n");
      out.write("  <br>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"reservations.jsp\">\n");
      out.write("        <span class=\"glyphicon glyphicon-pushpin logo-small\"></span>\n");
      out.write("        <h4 id=\"homelogo\">RESERVATIONS</h4>\n");
      out.write("        <p>Including private dining and special events</p>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"walkin.jsp\">\n");
      out.write("        <span class=\"glyphicon glyphicon-cutlery logo-small\"></span>\n");
      out.write("        <h4 id=\"homelogo\">WALK IN</h4>\n");
      out.write("        <p>A sublime, elevated experience</p>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"Controller?action=togomenu\">\n");
      out.write("        <span class=\"glyphicon glyphicon-send logo-small\"></span>\n");
      out.write("        <h4 id=\"homelogo\">TO GO</h4>\n");
      out.write("        <p>Enjoy the Seudo delicacy in your place</p>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <br>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"Controller?action=menu\">\n");
      out.write("        <span class=\"glyphicon glyphicon-book logo-small\"></span>\n");
      out.write("        <h4 id=\"homelogo\">MENU</h4>\n");
      out.write("        <p>At the helm of our newly designed kitchen is Chef Jessica Bauer.</p>\n");
      out.write("      </a>  \n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"giftcards.jsp\">\n");
      out.write("        <span class=\"glyphicon glyphicon-gift logo-small\"></span>\n");
      out.write("        <h4 id=\"homelogo\">GIFT CARDS</h4>\n");
      out.write("        <p>Share the Seudo experience</p>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <a href=\"contact.jsp\">\n");
      out.write("        <span class=\"glyphicon glyphicon-envelope logo-small\"></span>\n");
      out.write("        <h4 id=\"homelogo\" style=\"color:#303030;\">CONTACT</h4>\n");
      out.write("        <p>If you want to know more about Seudo</p>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("  <p>By Xun Yang, Yixian Zhu</p>\t\t\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write("  // Add smooth scrolling to all links in navbar + footer link\n");
      out.write("  $(\".navbar a, footer a[href='#myPage']\").on('click', function(event) {\n");
      out.write("\n");
      out.write("    // Prevent default anchor click behavior\n");
      out.write("    // event.preventDefault();\n");
      out.write("\n");
      out.write("    // Store hash\n");
      out.write("    var hash = this.hash;\n");
      out.write("\n");
      out.write("    // Using jQuery's animate() method to add smooth page scroll\n");
      out.write("    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area\n");
      out.write("    $('html, body').animate({\n");
      out.write("      scrollTop: $(hash).offset().top\n");
      out.write("    }, 900, function(){\n");
      out.write("   \n");
      out.write("      // Add hash (#) to URL when done scrolling (default click behavior)\n");
      out.write("      window.location.hash = hash;\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("  \n");
      out.write("  $(window).scroll(function() {\n");
      out.write("    $(\".slideanim\").each(function(){\n");
      out.write("      var pos = $(this).offset().top;\n");
      out.write("\n");
      out.write("      var winTop = $(window).scrollTop();\n");
      out.write("        if (pos < winTop + 600) {\n");
      out.write("          $(this).addClass(\"slide\");\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
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
