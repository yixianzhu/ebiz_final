/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import DataAccessObject.togoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xun yang
 */
@WebServlet(name = "TogoController", urlPatterns = {"/TogoController"})
public class TogoController extends HttpServlet {
    private togoDAO dao;
    public TogoController() {
        super();
        dao = new togoDAO();
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
        
    //    processRequest(request, response);
    String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("cook")){
            String orderid = request.getParameter("orderid");
            dao.updateTempCook(orderid);
            forward = "/manager.jsp";  
        } 
        else if (action.equalsIgnoreCase("collect")){
            String orderid = request.getParameter("orderid");
            dao.updateTempCollect(orderid);
            forward = "/manager.jsp";  
        } 
        else if (action.equalsIgnoreCase("delete")){
          String orderid = request.getParameter("orderid");
            dao.deleteTemp(orderid);
            forward = "/manager.jsp";  
        } 
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
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
