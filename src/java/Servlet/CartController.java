/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.CartBean;
import java.io.IOException;
import java.io.PrintWriter;
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
            System.out.println("The action is null");
        }else{
            System.out.println("The action is not null");
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
        System.out.println(strItemName+" "+strCategory+" "+strItemNo+" "+strPrice+" "+strQuantity);

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
