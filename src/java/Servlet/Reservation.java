/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataAccessObject.ReservationDao;
import Bean.CalebBean;
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
@WebServlet(name = "Reservation", urlPatterns = {"/Reservation"})
public class Reservation extends HttpServlet {
    private ReservationDao dao;

    public Reservation() {
        super();
        dao = new ReservationDao();
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
     //   processRequest(request, response);
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("see")){
            forward = "manageReservation.jsp";
            request.setAttribute("users", dao.getAllReservation());
        } 
        else if (action.equalsIgnoreCase("delete")){
            forward = "manageReservation.jsp";
            String phone=request.getParameter("userid");
            dao.deleteReservation(phone);
            request.setAttribute("users", dao.getAllReservation());
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
     response.setContentType("text/html;charset=UTF-8");     
        CalebBean user=new CalebBean();      
        user.setFname(request.getParameter("fname"));
        user.setLname(request.getParameter("lname"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        user.setTime(request.getParameter("time"));
        user.setGuest(request.getParameter("guest"));
        user.setDate(request.getParameter("date"));
        dao.addReservation(user);
        String f= null;
        f="/home.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
        rd.forward(request, response);
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
