/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataAccessObject.Dao;
import Bean.CalebBean;
import Bean.MealBean;
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
@WebServlet(name = "TableController", urlPatterns = {"/TableController"})
public class TableController extends HttpServlet {
    private Dao dao;
    private static String CHANGE = "/meal.jsp";
    private static String LIST_MEAL = "/manager.jsp";
    private static String MENU = "/menu.jsp";
    public TableController() {
        super();
        dao = new Dao();
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

        if (action.equalsIgnoreCase("serve")){
            String mealid = request.getParameter("mealid");
            String tableid = request.getParameter("tableid");
            dao.updateTable(tableid,mealid);
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
        response.setContentType("text/html;charset=UTF-8");
        MealBean meal=new MealBean();
        CalebBean user=new CalebBean();
        user.setUserid(WalkinLogin.userid);
        user.setTableid(WalkinLogin.tableid);
        meal.setId(request.getParameter("mealid"));
        String quantity=request.getParameter("quantity");
        user.setQuantity(Integer.parseInt(quantity));
        dao.addTableCart(meal,user);
        String f= null;
        f="/Controller?action=menu";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
        rd.forward(request, response);
   //     processRequest(request, response);
 /*  String p=null;
        String hint=null;
        MealBean meal=new MealBean();
              else{
                String fieldName = item.getFieldName();
                String fieldValue = item.getString();
                switch(fieldName){
                    case "id":meal.setId(fieldValue);break;
                    case "name":meal.setName(fieldValue);break;
                    case "category":meal.setCategory(fieldValue);break;
                    case "description":meal.setDescription(fieldValue);break;
                    case "price":meal.setPrice(Double.parseDouble(fieldValue));break;
                    case "hint":hint=fieldValue;break;
                }
              }
          }
      } catch (FileUploadException e) {
          e.printStackTrace();
      } catch (Exception e) {
          e.printStackTrace();
      }
    } 
        if(hint.equals("update")){        
        dao.updateMeal(meal);       
        }
        else{    
        dao.addMeal(meal);            
        }   
        RequestDispatcher view = request.getRequestDispatcher(LIST_MEAL);
        request.setAttribute("meals", dao.getAllMeal());
        view.forward(request, response);  */
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
