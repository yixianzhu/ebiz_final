/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataAccessObject.giftcardDAO;
import DataAccessObject.emailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zhuyixian
 */
public class giftCardController extends HttpServlet {
    final private giftcardDAO giftcardDao;
    final private emailDAO emailDao;
    
    public giftCardController() {
        super();
        giftcardDao = new giftcardDAO();
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
        String giftcardAction = request.getParameter("action");

        if(giftcardAction == null && giftcardAction.equals("")){
            System.out.println("The action is null");
        }else{
            System.out.println("The action is not null");
            if(giftcardAction.equals("purchaseGiftCard")){
                System.out.println("purchase Gift Card starts!");
                purchaseGiftCard(request);
                response.sendRedirect("giftcards.jsp");
            }else{
                response.sendRedirect("home.html");
            }
        }
    }

    private void purchaseGiftCard(HttpServletRequest request) {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String receiverName = request.getParameter("inputReceiverName");
        String senderName = request.getParameter("inputSenderName");
        // String receiverName = request.getParameter("inputReName");
        String senderEmail = request.getParameter("inputSenderEmail");
        String senderEmailUserName = senderEmail.substring(0,senderEmail.indexOf('@'));
        String personalNote = request.getParameter("inputPersonalNote");
        String strAmount = request.getParameter("gift_card_amount");
        String purchaseid = date+senderEmailUserName;
        System.out.println(receiverName+" "+senderName+" "+senderEmail+" "+personalNote+" amount: "+strAmount);
        String receiverEmail;
        String order_form = request.getParameter("order_form");
        System.out.println(order_form);
        if(order_form.equals("email")){
            System.out.println("send the gift card to receiver");
            receiverEmail = request.getParameter("inputReceiverEmail");
            System.out.println(receiverEmail);
            giftcardDao.recordPurchse(purchaseid, senderName, senderEmail, receiverName, receiverEmail, strAmount);
        }else if(order_form.equals("self")){
            System.out.println("send the gift card to sender");
            receiverEmail = senderEmail;
            giftcardDao.recordPurchse(purchaseid, senderName, senderEmail, receiverName, receiverEmail, strAmount);
        }else{
            System.out.println("didn't get radio button's value");
        }

        if(request.getParameter("receiveEmail")!=null){               
            emailDao.togoEmail(senderEmail, senderName);
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
