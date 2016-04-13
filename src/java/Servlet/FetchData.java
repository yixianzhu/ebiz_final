package Servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class FetchData {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            //    Properties prop = new Properties();
          //      InputStream inputStream = FetchData.class.getClassLoader().getResourceAsStream("/db.properties");
            //    prop.load(inputStream);
            //    String driver = prop.getProperty("driver");
            //    String url = prop.getProperty("url");
            //    String user = prop.getProperty("user");
            //    String password = prop.getProperty("password");
                  String USERNAME="yang";
                  String PASSWORD="0914";
                 String CON_STRING="jdbc:mysql://localhost:3306/test";
                 String driver="com.mysql.jdbc.Driver";
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            catch (InstantiationException e){
                 e.printStackTrace();
            }
            catch (IllegalAccessException e){
                 e.printStackTrace();
            }
            return connection;
        }

    }
    
    public static ArrayList<Meal> getAllMeals() {
    	connection = FetchData.getConnection();
        ArrayList<Meal> mealList = new ArrayList<Meal>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from meal");
        
            while(rs.next()) {	
            	Meal meal=new Meal();
            	meal.setId(rs.getString("id"));
                meal.setName(rs.getString("name"));
                meal.setCategory(rs.getString("category"));
                meal.setPrice(rs.getInt("price"));
            	mealList.add(meal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mealList;
    }
}
