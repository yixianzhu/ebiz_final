/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.MealBean;
import Bean.TogoBean;
import DataAccessObject.togoDAO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xun yang
 */
@WebServlet(name = "TogoOrder", urlPatterns = {"/TogoOrder"})
public class TogoOrder extends HttpServlet {
    private togoDAO togoDAO;
    public TogoOrder() {
    togoDAO = new togoDAO();
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
       List<TogoBean> togoOrder=new ArrayList<TogoBean>();
		togoOrder=togoDAO.getAllOrders();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(togoOrder, new TypeToken<List<MealBean>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
                System.out.println(jsonArray);
		response.getWriter().print(jsonArray);
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
