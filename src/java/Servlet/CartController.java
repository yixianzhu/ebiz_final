/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.CalebBean;
import DataAccessObject.togoDAO;
import DataAccessObject.emailDAO;
import Bean.CartBean;
import Bean.CartItemBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zhuyixian
 */
public class CartController extends HttpServlet {
    final private togoDAO togoDao;
    final private emailDAO emailDao;
    
    public CartController() {
        super();
        togoDao = new togoDAO();
        emailDao = new emailDAO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cartAction = request.getParameter("action");

        if(cartAction == null && cartAction.equals("")){
            // System.out.println("The action is null");
        }else{
            // System.out.println("The action is not null");
            if(cartAction.equals("add")){
                System.out.println("add an item!");
                addToCart(request);
                response.sendRedirect("Controller?action=togomenu");
            }else if(cartAction.equals("update")){
                updateCart(request);
                response.sendRedirect("togo_order.jsp");
            }else if(cartAction.equals("delete")){
                deleteCart(request);
                response.sendRedirect("togo_order.jsp");
            }else if(cartAction.equals("togocheckout")){
                CalebBean user=new CalebBean();
                user=togocheckout(request);
                request.setAttribute("user", user);
                String f="/togoreceipt.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
                rd.forward(request, response);
            }else if(cartAction.equals("set tip")){
                settip(request);
                response.sendRedirect("togo_order.jsp");
            }
        }
    }
    
    protected void addToCart(HttpServletRequest request){
        System.out.println("call addToCart function");
        HttpSession session = request.getSession();
        String strItemNo = request.getParameter("mealNo");
        String strItemName = request.getParameter("mealName");
        String strPrice = request.getParameter("mealPrice");
        String strCategory = request.getParameter("mealCategory");
        String strQuantity = request.getParameter(strItemNo);

        CartBean cartBean;

        Object objCartBean = session.getAttribute("cart");

        if(objCartBean != null){
            cartBean = (CartBean)objCartBean;
        }else{
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
            System.out.println("creat a new cartBean");
        }
        cartBean.addCartItem(strItemNo, strItemName, strPrice, strCategory, strQuantity);
        System.out.println("successfully add an item");
    }

    protected void deleteCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        String strItemNo = request.getParameter("itemNo");
        CartBean cartBean;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean != null){
            cartBean = (CartBean)objCartBean;
        }else{
            cartBean = new CartBean();
        }
        cartBean.deleteCartItem(strItemNo);

    }

    protected void updateCart(HttpServletRequest request){
        System.out.println("call update function");
        HttpSession session = request.getSession();
        String strItemNo = request.getParameter("itemNo");
        String strQuantity = request.getParameter("quantity");
        CartBean cartBean;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean != null){
            cartBean = (CartBean)objCartBean;
        }else{
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemNo, strQuantity);
    }
    
    protected CalebBean togocheckout(HttpServletRequest request) {
        System.out.println("call togo checkout function");
        CalebBean c=new CalebBean();
        HttpSession session = request.getSession();
        String strPhoneNumber = request.getParameter("inputPhoneNumber");
        String strEmail = request.getParameter("inputEmail");
        String strFirstName = request.getParameter("inputFirstName");
        String strLastName = request.getParameter("inputLastName");
        String customername = strFirstName +" "+ strLastName; 
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String orderid = date+strPhoneNumber.substring(5);
        Object objCartBean = session.getAttribute("cart");

        if(objCartBean != null){
            CartBean cartBean = (CartBean)objCartBean;
            String orderedmeals ="";
            HashMap<String, CartItemBean> alCartItems = cartBean.getAlCartItems();
            for (CartItemBean cartItem: alCartItems.values()) {
                togoDao.insertmeal(orderid, cartItem);
                orderedmeals += cartItem.getItemName();
                if(cartItem.getQuantity()>1){
                    orderedmeals += "X" + cartItem.getQuantity() + " ";
                }else{
                    orderedmeals += " ";
                }
            }
            Double tips = cartBean.getTips();
            Double charge = tips+cartBean.getTotalCost();
            c.setCost(charge);
            togoDao.insertorder(orderid, strPhoneNumber, cartBean.getTotalCost(), tips, charge);
            togoDao.tellmanager(orderid, strPhoneNumber, customername, orderedmeals);
          
        }
        CartBean cartBean = new CartBean();
        request.setAttribute("cart", cartBean);

        if(request.getParameter("receiveEmail")!=null){  
            
            emailDao.togoEmail(strEmail, customername);
        }
        System.out.println("successfully ckeckout");
    return c;
    }
    
    private void settip(HttpServletRequest request) {
        System.out.println("call togo addtip function");
        HttpSession session = request.getSession();
        String strtips = request.getParameter("tip");
        CartBean cartBean;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean != null){
            cartBean = (CartBean)objCartBean;
            cartBean.setTips(strtips);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
