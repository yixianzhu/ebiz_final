package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.CartBean;
import java.beans.Beans;

public final class togo_005forder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>My Order</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"CSS/general.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"CSS/togoorder_css.css\">\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  <link href=\"http://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\n");
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
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        <li><a href=\"home.html\">HOME</a></li>\n");
      out.write("        <li><a href=\"Controller?action=togomenu\">ORDER ONLINE</a></li>\n");
      out.write("        <li><a href=\"giftcards.jsp\">GIFT CARDS</a></li>\n");
      out.write("        <li><a href=\"contact.jsp\">CONTACT</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"contact\" class=\"container-fluid\">\n");
      out.write("  <h2 class=\"text-center\">MY ORDER - Seudo</h2>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-sm-6\" id=\"togo_order_table\">\n");
      out.write("      <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("          <td><strong>Category</strong></td>\n");
      out.write("          <td><strong>Name</strong></td>\n");
      out.write("          <td><strong>Quantity</strong></td>\n");
      out.write("          <td><strong>Unit Price</strong></td>\n");
      out.write("          <td><strong>Total</strong></td>\n");
      out.write("          <td><strong>Delete</strong></td>\n");
      out.write("        </tr>\n");
      out.write("        ");
      Bean.CartBean cart = null;
      synchronized (session) {
        cart = (Bean.CartBean) _jspx_page_context.getAttribute("cart", PageContext.SESSION_SCOPE);
        if (cart == null){
          cart = new Bean.CartBean();
          _jspx_page_context.setAttribute("cart", cart, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getCartSize()==0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("          <tr>\n");
          out.write("              <td colspan=\"4\">");
          out.print(cart.getCartSize());
          out.write("- Cart is currently empty -<br/>\n");
          out.write("          </tr>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("      <tr>\n");
      out.write("        <td colspan=\"2\"> </td>\n");
      out.write("        <td> </td>\n");
      out.write("        <td colspan=\"2\">Subtotal:</td>\n");
      out.write("        <td >$");
      if (_jspx_meth_c_out_5(_jspx_page_context))
        return;
      out.write("</td>\n");
      out.write("      </tr>\n");
      out.write("    </table>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"col-sm-6\">\n");
      out.write("      <form class=\"form-horizontal\" role=\"form\" method='POST' action='CartController'>\n");
      out.write("        <h3 class=\"center\">Online booking form</h3>\n");
      out.write("        <h4>Payment Information</h4><hr>\n");
      out.write("        <div class=\"form-group\"> \n");
      out.write("          <label for=\"inputNameOnCard\" class=\"col-sm-4 control-label\">Name on Card</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"nameOnCard\" class=\"form-control\" id=\"inputNameOnCard\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"inputCardNumber\" class=\"col-sm-4 control-label\">Card Number</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"cardNumber\" class=\"form-control\" id=\"inputCardNumber\" />\n");
      out.write("            <div id=\"divCardTypes\">                                              \n");
      out.write("              <img src=\"Pic/card/VISA.png\" alt=\"VISA\">                        \n");
      out.write("              <img src=\"Pic/card/MASTERCARD.png\" alt=\"MASTERCARD\">                        \n");
      out.write("              <img src=\"Pic/card/AMEX.png\" alt=\"AMEX\">                        \n");
      out.write("              <img src=\"Pic/card/DISCOVER.png\" alt=\"DISCOVER\">                         \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"selExpiryM\" class=\"col-sm-4 control-label\" id=\"lblExpiration\">Expiration Date </label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <span class=\"spnSelectParent\" id=\"spnExpiryMonthParent\">\n");
      out.write("                <select name=\"ctl00$MainContent$selExpiryM\" id=\"selExpiryM\" tabindex=\"8\" autocomplete=\"off\">\n");
      out.write("                  <option value=\"01\">01</option>\n");
      out.write("                  <option value=\"02\">02</option>\n");
      out.write("                  <option value=\"03\">03</option>\n");
      out.write("                  <option selected=\"selected\" value=\"04\">04</option>\n");
      out.write("                  <option value=\"05\">05</option>\n");
      out.write("                  <option value=\"06\">06</option>\n");
      out.write("                  <option value=\"07\">07</option>\n");
      out.write("                  <option value=\"08\">08</option>\n");
      out.write("                  <option value=\"09\">09</option>\n");
      out.write("                  <option value=\"10\">10</option>\n");
      out.write("                  <option value=\"11\">11</option>\n");
      out.write("                  <option value=\"12\">12</option>\n");
      out.write("                </select>\n");
      out.write("            </span>\n");
      out.write("            <span class=\"spnSelectParent\" id=\"spnExpiryYearParent\">\n");
      out.write("              <select name=\"ctl00$MainContent$selExpiryY\" id=\"selExpiryY\" tabindex=\"9\" autocomplete=\"off\">\n");
      out.write("                <option value=\"2016\">2016</option>\n");
      out.write("                <option value=\"2017\">2017</option>\n");
      out.write("                <option value=\"2018\">2018</option>\n");
      out.write("                <option value=\"2019\">2019</option>\n");
      out.write("                <option value=\"2020\">2020</option>\n");
      out.write("                <option value=\"2021\">2021</option>\n");
      out.write("                <option value=\"2022\">2022</option>\n");
      out.write("                <option value=\"2023\">2023</option>\n");
      out.write("                <option value=\"2024\">2024</option>\n");
      out.write("                <option value=\"2025\">2025</option>\n");
      out.write("                <option value=\"2026\">2026</option>\n");
      out.write("              </select>\n");
      out.write("            </span>  \n");
      out.write("          </div>             \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\"> \n");
      out.write("          <label for=\"inputSecurityCode\" class=\"col-sm-4 control-label\">Security Code</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"securityCode\" class=\"form-control\" id=\"inputSecurityCode\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\"> \n");
      out.write("          <label for=\"inputBillingZipCode\" class=\"col-sm-4 control-label\">Billing Zip Code</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"billingZipCode\" class=\"form-control\" id=\"inputBillingZipCode\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <h4>Contact Information</h4><hr>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"inputFirstName\" class=\"col-sm-4 control-label\">First Name</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"firstName\" class=\"form-control\" id=\"inputFirstName\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"inputLastName\" class=\"col-sm-4 control-label\">Last Name</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"lastName\" class=\"form-control\" id=\"inputLastName\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"inputEmail\" class=\"col-sm-4 control-label\">Email</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"email\" class=\"form-control\" id=\"inputEmail\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"checkbox\">               \n");
      out.write("            <label><input type=\"checkbox\"/>Yes, I want to receive messages from XXX.</label>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"inputDateTime\" class=\"col-sm-4 control-label\">Pick your time</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("              <input type=\"dateTime\" class=\"form-control\" id=\"inputDateTime\" />\n");
      out.write("          </div>        \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"inputPhoneNumber\" class=\"col-sm-4 control-label\">Phone number*</label>\n");
      out.write("          <div class=\"col-sm-8\">\n");
      out.write("            <input type=\"phoneNumber\" class=\"form-control\" id=\"inputPhoneNumber\" />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div><p>*We’ll only use this information to send your order confirmation.<br>Phone number is also used to:\n");
      out.write("          <ul>\n");
      out.write("            <li>Record your dining history</li>\n");
      out.write("            <li>Offer you special promotion if eligible</li>\n");
      out.write("            <li>Send you promotion news or account info through message</li>\n");
      out.write("            <li>More information please consult our manager</li>\n");
      out.write("          </ul></p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <div class=\"col-sm-12 form-group\">\n");
      out.write("            <button class=\"btn btn-default pull-right\" type=\"submit\">Place order</button>\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"togocheckout\"/>\n");
      out.write("            <input type=\"submit\" name=\"addToCart\" value=\"Add To Cart\"/>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </form>  \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
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
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("cartItem");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getCartItems()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("counter");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("          <form name=\"item\" method=\"POST\" action=\"CartController\">\n");
          out.write("            <tr>\n");
          out.write("              <td>");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("              <td>");
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("              <td>\n");
          out.write("                  <input type='hidden' name='itemNo' value='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartItem.itemNo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'>\n");
          out.write("                  <input type='text' name=\"quantity\" value='");
          if (_jspx_meth_c_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("' size='2'> \n");
          out.write("                  <input type=\"submit\" name=\"action\" value=\"update\">                \n");
          out.write("              </td>\n");
          out.write("              <td>$");
          if (_jspx_meth_c_out_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("              <td>$");
          if (_jspx_meth_c_out_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("              <td><input type=\"submit\" name=\"action\" value=\"delete\"></td>\n");
          out.write("            </tr>\n");
          out.write("          </form>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartItem.category}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartItem.itemName}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartItem.quantity}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartItem.price}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cartItem.subSumCost}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_out_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(_jspx_page_context);
    _jspx_th_c_out_5.setParent(null);
    _jspx_th_c_out_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.totalCost}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
    return false;
  }
}
