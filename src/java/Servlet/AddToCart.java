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
        MealBean meal=new MealBean();
        CalebBean user=new CalebBean();
        user.setUserid(WalkinLogin.userid);
        user.setTableid(WalkinLogin.tableid);
        System.out.println(WalkinLogin.tableid);
        meal.setId(request.getParameter("mealid"));
        String mealid=request.getParameter("mealid");
    //    String quantity=request.getParameter("quantity");
        String quantity=request.getParameter(mealid);
        user.setQuantity(Integer.parseInt(quantity));

        String cartAction = request.getParameter("action");

        if(cartAction == null && cartAction.equals("")){
            // System.out.println("The action is null");
        }else{
            // System.out.println("The action is not null");
            if(cartAction.equals("add")){
                System.out.println("add an item!");
             //   addToCart(request);
            //    response.sendRedirect("Controller?action=togomenu");
        

        System.out.println(Integer.parseInt(quantity));

     //   String mealid=request.getParameter("mealid");
     //   meal.setId(mealid);
     //   String quantity=request.getParameter(mealid);
     //   user.setQuantity(Integer.parseInt(quantity));
        dao.addTableCart(meal,user);
        response.sendRedirect("Controller?action=walkinmenu");
     //   String f= null;
      //  f="/Controller?action=walkinmenu";
     //   RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
    //    rd.forward(request, response);
            }
        }
    //    RequestDispatcher view = request.getRequestDispatcher("/Controller?action=menu");
      //  request.setAttribute("meals", dao.getMyCart());
    //    view.forward(request, response);
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
