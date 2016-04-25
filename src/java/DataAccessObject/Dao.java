/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

/**
 *
 * @author xun yang
 */
import Bean.CalebBean;
import Bean.MealBean;
import Servlet.WalkinLogin;
import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
   private Connection connection;

    public Dao() {
        connection = DatabaseConnection.getConnection();
    }
    public CalebBean getUserbean(){
      CalebBean c=new CalebBean();
      try {
         Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select quantity from tablecart where phone='"+WalkinLogin.userid+"'");
        int total=0;
            while (rs.next()) {
                total=total+rs.getInt("quantity");
            }
            c.setOrder(total);
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }
      return c;
    }
    public void addMeal(MealBean meal) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into finalmeal(id,name,category,description,price,imagepath) values (?, ?, ?, ? ,?,?)");
            preparedStatement.setString(1, meal.getId());
            preparedStatement.setString(2, meal.getName());
            preparedStatement.setString(3, meal.getCategory());
            preparedStatement.setString(4, meal.getDescription());
            preparedStatement.setDouble(5, meal.getPrice());
             preparedStatement.setString(6, meal.getImage());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }

    public void deleteMeal(String mealId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from finalmeal where id=?");            
            preparedStatement.setString(1, mealId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }

    public void updateMeal(MealBean meal) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update finalmeal set name=?, category=?, calories=?, price=?" +
                            "where id=?");          
            preparedStatement.setString(1, meal.getName());
            preparedStatement.setString(2, meal.getCategory());
            preparedStatement.setString(3, meal.getDescription());
            preparedStatement.setDouble(4, meal.getPrice());
            preparedStatement.setString(5, meal.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
          System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    
    public void updateTable(String tableid, String mealid) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update confirmedcart set status='served'" +
                            "where tableid=? and mealid=?");          
            preparedStatement.setString(1, tableid);
            preparedStatement.setString(2, mealid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
          System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    public void cancelTable() {   
    }
    

    public List<MealBean> getAllMeal() {
        List<MealBean> meals = new ArrayList<MealBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from finalmeal");
            while (rs.next()) {
                MealBean meal = new MealBean();
                meal.setId(rs.getString("id"));
                meal.setName(rs.getString("name"));
                meal.setCategory(rs.getString("category"));
                meal.setDescription(rs.getString("description"));
                meal.setPrice(rs.getDouble("price"));
                meal.setImage(rs.getString("imagepath"));
                meals.add(meal);
            }
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return meals;
    }
    

    public MealBean getMealById(String mealId) {
        MealBean meal = new MealBean();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from finalmeal where id=?");
            preparedStatement.setString(1, mealId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
               meal.setId(rs.getString("id"));
               meal.setName(rs.getString("name"));
               meal.setCategory(rs.getString("category"));
               meal.setDescription(rs.getString("description"));
               meal.setPrice(rs.getDouble("price"));
               meal.setImage(rs.getString("imagepath"));
            }
        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return meal;
    }  
    public void addTableCart(MealBean meal, CalebBean user) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select price from finalmeal where id='"+meal.getId()+"'");
            double subtotal=0;
            while (rs.next()) {
                subtotal=rs.getDouble("price")* user.getQuantity();
            }
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tablecart(tableid,phone,mealid,quantity,status,subtotal) values (?, ?, ?, ?,?,?)");
            preparedStatement.setString(1, user.getTableid());
            preparedStatement.setString(2, user.getUserid());
            preparedStatement.setString(3, meal.getId());
            preparedStatement.setInt(4, user.getQuantity());  
            preparedStatement.setString(5, "Not served");
             preparedStatement.setDouble(6, subtotal);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    public void confirmCart(){
         try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tablecart where tablecart.phone='"+WalkinLogin.userid+"'");
        while (rs.next()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into confirmedcart(tableid,phone,mealid,quantity,status,subtotal) values (?, ?, ?, ?,?,?)");
            preparedStatement.setString(1, rs.getString("tableid"));
            preparedStatement.setString(2, rs.getString("phone"));
            preparedStatement.setString(3, rs.getString("mealid"));
            preparedStatement.setInt(4, rs.getInt("quantity"));  
            preparedStatement.setString(5, rs.getString("status"));
             preparedStatement.setDouble(6, rs.getDouble("subtotal"));
            preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
          System.err.println("A SQLException was caught: " + e.getMessage());
        }
         try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tablecart where phone=?");           
            preparedStatement.setString(1, WalkinLogin.userid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
     public List<MealBean> getAlltables() {
        List<MealBean> meals = new ArrayList<MealBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from confirmedcart,finalmeal where confirmedcart.mealid=finalmeal.id");
            while (rs.next()) {
                MealBean meal = new MealBean();
                meal.setTableid(rs.getString("tableid"));
                meal.setId(rs.getString("id"));
                meal.setName(rs.getString("name"));
                meal.setCategory(rs.getString("category"));
                meal.setDescription(rs.getString("description"));
                meal.setStatus(rs.getString("status"));
                meal.setPrice(rs.getDouble("price"));
                meal.setImage(rs.getString("imagepath"));
                meal.setQuantity(rs.getInt("quantity"));                
                int q=rs.getInt("quantity");
                double price=rs.getDouble("price");
                double total=price*q;
                meal.setPrice(total);
                meals.add(meal);
            }
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return meals;
    }
    
     public List<MealBean> getMyCart() {
         List<MealBean> meals = new ArrayList<MealBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tablecart,finalmeal where tablecart.phone='"+WalkinLogin.userid+"'"+"and tablecart.mealid=finalmeal.id");
        while (rs.next()) {
                MealBean meal = new MealBean();
                meal.setId(rs.getString("id"));
                meal.setName(rs.getString("name"));
                meal.setCategory(rs.getString("category"));
                meal.setDescription(rs.getString("description"));
                meal.setImage(rs.getString("imagepath"));
                meal.setQuantity(rs.getInt("quantity"));                
                int q=rs.getInt("quantity");
                double price=rs.getDouble("price");
                double total=price*q;
                meal.setPrice(total);
                meals.add(meal);
            }
        } catch (SQLException e) {
          System.err.println("A SQLException was caught: " + e.getMessage());
        }
        return meals;
     }
     public void deleteCart(String mealId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from tablecart where mealid=? and phone=?");            
            preparedStatement.setString(1, mealId);
            preparedStatement.setString(2, WalkinLogin.userid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
     public void clearCart() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tablecart where phone=?");           
            preparedStatement.setString(1, WalkinLogin.userid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
     
    
     
    
}
