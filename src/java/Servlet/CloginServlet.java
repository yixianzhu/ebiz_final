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
import Bean.CalebBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CloginServlet", urlPatterns = {"/CloginServlet"})

public class  CloginServlet extends HttpServlet {
    public static String userid=null;
    private Connection conn;
    private Statement st;
    private ResultSet rs = null;
    private String check=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");     
        HttpSession session=request.getSession(true);
        CalebBean cb = new CalebBean();
        session.setAttribute("cb",cb);
        Boolean valid = false;
        String p=request.getParameter("password");
        String u=request.getParameter("bbname");
    //    String category=request.getParameter("category");
        String uname=null;
        String category=null;
        try{Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM userinfo WHERE user_name = "+"'"+
                    u+"'");
            rs =  st.executeQuery(q1);
            while(rs.next()){          
                check = rs.getString("PASS");
                uname=rs.getString("name");
                category=rs.getString("category");
                valid=true;
            }            
        }
        catch( ClassNotFoundException cnfe)
        {
            System.err.println("A ClassNotFoundException was caught: " + cnfe.getMessage());
        }
        catch (SQLException se)
        {          
            System.err.println("A SQLException was caught: " + se.getMessage()); 
        }    
         if(p.equals(check) && valid==true){    
            cb.setStatus("Login successfully!");
            cb.setName(uname);
            cb.setUserid(u);
            userid=u;
            String f=null;           
            if(category.equals("customer")){
            f="/staff.jsp";
            }
            else{
            f="/manager.jsp";             
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
            rd.forward(request, response);
            }
            else{
            cb.setStatus("Fail to log in, please try again!");
            String f2="/index.jsp";
        //    if(category.equals("customer")){
         //   f2="/clogin.jsp";
         //   }
         //   else{
         //   f2="/mlogin.jsp";             
         //   }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(f2);                       
            rd.forward(request, response);
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
