/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

/**
 *
 * @author xun yang
 */
import DataAccessObject.Dao;
import Bean.MealBean;
import Bean.CalebBean;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet{
 
    private static String VIEW_CART = "/walkin_order.jsp";
    private Dao dao;

    public AddToCart() {
        super();
        dao = new Dao();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cartAction = request.getParameter("action");
        if(cartAction == null && cartAction.equals("")){
            // System.out.println("The action is null");
        }else{
            // System.out.println("The action is not null");
            if(cartAction.equals("add")){
               MealBean meal=new MealBean();
               CalebBean user=new CalebBean();
               user.setUserid(WalkinLogin.userid);
               user.setTableid(WalkinLogin.tableid);
               System.out.println(WalkinLogin.tableid);
               meal.setId(request.getParameter("mealid"));
               String mealid=request.getParameter("mealid");
               String quantity=request.getParameter(mealid);
               Boolean isInt=false;
               try{
                  Integer.parseInt(quantity);
                  isInt=true;
                }     
                 catch (Exception e) {
                 System.err.println("An Exception was caught: " + e.getMessage());
                }
               if(isInt==true){
                  if(Integer.parseInt(quantity)>0){           
                  user.setQuantity(Integer.parseInt(quantity));
                  System.out.println("add an item!");       
                  dao.addTableCart(meal,user);
                }
                }        
                response.sendRedirect("Controller?action=walkinmenu");              
            }
            else if(cartAction.equals("confirm")){
               System.out.println("confirm items!");       
               dao.confirmCart();
               response.sendRedirect("Controller?action=walkinmenu");     
            }
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
