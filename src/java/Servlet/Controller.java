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
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.*;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
@MultipartConfig
public class Controller extends HttpServlet{
    private static String CHANGE = "/meal.jsp";
    private static String LIST_MEAL = "/manager.jsp";
    private static String WALKINMENU = "/walkin_menu.jsp";
    private static String TOGOMENU = "/togo_menu.jsp";
    private static String MENU = "/menu.jsp";
    private Dao dao;

    public Controller() {
        super();
        dao = new Dao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            String mealId = request.getParameter("mealId");
            dao.deleteMeal(mealId);
            forward = LIST_MEAL;
            request.setAttribute("meals", dao.getAllMeal());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = CHANGE;
            String mealId = request.getParameter("mealId");
            MealBean meal = dao.getMealById(mealId);
            meal.setHint("update");
            request.setAttribute("meal", meal);
        
        } else if (action.equalsIgnoreCase("listMeal")){
            forward = LIST_MEAL;
            request.setAttribute("meals", dao.getAllMeal());
        } 
        else if (action.equalsIgnoreCase("walkinmenu")){
            forward = WALKINMENU;
            CalebBean cb=new CalebBean();
             cb= dao.getUserbean();
            request.setAttribute("meals", dao.getAllMeal());
            request.setAttribute("cb",cb);
        }else if (action.equalsIgnoreCase("togomenu")){
            forward = TOGOMENU;
            request.setAttribute("meals", dao.getAllMeal());
        }else if (action.equalsIgnoreCase("menu")){
            forward = MENU;
            request.setAttribute("meals", dao.getAllMeal());
        }else {
            forward = CHANGE;
            
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String p=null;
        String hint=null;
        MealBean meal=new MealBean();
        Boolean isDouble=false;
        Boolean check=false;
        System.out.println(isMultipart);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory); 
        try {
          System.out.println("request: "+request);
          System.out.println("request end");
          List items = upload.parseRequest(request);
          Iterator iterator = items.iterator();
          while (iterator.hasNext()) {
              FileItem item = (FileItem) iterator.next();
              if (!item.isFormField()) {
                  String fileName = item.getName();
                  String root = getServletContext().getRealPath("/");
                  String work= root.substring(0,root.indexOf("build"));
                  System.out.println("hi");
            File path = new File(work + "/web/images");
                  if (!path.exists()) {
                      boolean status = path.mkdirs();
                  }
                  File uploadedFile = new File(path + "/" + fileName);
                  System.out.println(uploadedFile.getAbsolutePath());
                  item.write(uploadedFile);
                  p="images/"+fileName;
                  System.out.println(p);
                  meal.setImage(p);
              }
              else{
                String fieldName = item.getFieldName();
                String fieldValue = item.getString();
                switch(fieldName){
                    case "id":meal.setId(fieldValue);break;
                    case "name":meal.setName(fieldValue);break;
                    case "category":meal.setCategory(fieldValue);break;
                    case "description":meal.setDescription(fieldValue);break;
                    case "price":
                    //    meal.setPrice(Double.parseDouble(fieldValue));
                        try{
                        Double.parseDouble(fieldValue);
                        isDouble=true;
                        }     
                        catch (Exception e) {
                        System.err.println("An Exception was caught: " + e.getMessage());
                        }
                  if(isDouble==true){
                  if(Double.parseDouble(fieldValue)>0){           
                  meal.setPrice(Double.parseDouble(fieldValue));
                  check=true;
                }
                }        
                        break;
                    case "hint":hint=fieldValue;break;
                }
              }
          }
      } catch (FileUploadException e) {
         System.err.println("An Exception was caught: " + e.getMessage());
      } catch (Exception e) {
         System.err.println("An Exception was caught: " + e.getMessage());
      }
    }
        System.out.println(hint);
        if(check==true){
        if(hint.equals("update")){        
        dao.updateMeal(meal);       
        }
        else{    
        dao.addMeal(meal);            
        }   
        }
     //   response.sendRedirect(CHANGE); 
        RequestDispatcher view = request.getRequestDispatcher(CHANGE);
     //   request.setAttribute("meals", dao.getAllMeal());
        view.forward(request, response);
    }
}
