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

import Bean.MealBean;
import Bean.CalebBean;
import DbConnect.DatabaseConnection;
import Servlet.CloginServlet;
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
           System.out.println(meal.getId());
           System.out.println(meal.getName());
           System.out.println(meal.getCategory());
           System.out.println(meal.getDescription());
           System.out.println(meal.getPrice());
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
    public void addCart(MealBean meal, CalebBean user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into finalcart(userid,mealid,quantity) values (?, ?, ?)");
            preparedStatement.setString(1, user.getUserid());
            preparedStatement.setString(2, meal.getId());
            preparedStatement.setInt(3, user.getQuantity());       
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    
     public List<MealBean> getMyCart() {
         List<MealBean> meals = new ArrayList<MealBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from finalcart,finalmeal where cart.userid='"+CloginServlet.userid+"'"+"and cart.mealid=meal.id");
        while (rs.next()) {
                MealBean meal = new MealBean();
                meal.setId(rs.getString("id"));
                meal.setName(rs.getString("name"));
                meal.setCategory(rs.getString("category"));
                meal.setDescription(rs.getString("description"));
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
                    .prepareStatement("delete from finalcart where mealid=? and userid=?");            
            preparedStatement.setString(1, mealId);
            preparedStatement.setString(2, CloginServlet.userid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
     public void clearCart() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from finalcart where userid=?");           
            preparedStatement.setString(1, CloginServlet.userid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
}
