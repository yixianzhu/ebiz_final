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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        ");
      Bean.CalebBean cb = null;
      synchronized (session) {
        cb = (Bean.CalebBean) _jspx_page_context.getAttribute("cb", PageContext.SESSION_SCOPE);
        if (cb == null){
          cb = new Bean.CalebBean();
          _jspx_page_context.setAttribute("cb", cb, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Bean.CalebBean)_jspx_page_context.findAttribute("cb")).getStatus())));
      out.write(" Dear Manager</h1>\r\n");
      out.write("        <p style=\"font-size:160%;color:red;\">I have set the default username and password(2,2), which can allow you to log in as a manager. You can also create a new account.</p>\r\n");
      out.write("        <form method = \"post\" action=\"CloginServlet\" id=\"loginfrm\">\r\n");
      out.write("         <!--   <input type=\"hidden\" name=\"category\" value=\"manager\" /> -->\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Username</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"bbname\" id=\"username\" value=\"2\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Password</td>\r\n");
      out.write("                        <td><input type=\"password\" name=\"password\" id=\"password\" value=\"2\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td><input type=\"submit\" name=\"Login\" value=\"Login\" id=\"submit\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("         <br/><br/>\r\n");
      out.write("    <div><a href =\"newaccount.jsp\">Create a new account</a></div>\r\n");
      out.write("    <br/>\r\n");
      out.write("    </body>\r\n");
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
