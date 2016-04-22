/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Bean.CartItemBean;
import Bean.TogoBean;
import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhuyixian
 */
public class togoDAO {
    private Connection connection;
    Statement st = null;
    ResultSet rs = null;
    String sql = "";

    public togoDAO() {
            //connect to database and select the record
            connection = DatabaseConnection.getConnection();	
        }
    
    public void insertmeal(String orderid, CartItemBean cartItem) {
        try { 
            st = connection.createStatement();
            sql = "INSERT INTO IS2730.ORDERDETAIL (ORDERID, MEALID, QUANTITY) VALUES " +
                "('"+ orderid+"', '"+cartItem.getItemNo()+"',"+cartItem.getQuantity()+")";
                st.executeUpdate(sql);                  
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void insertorder(String orderid, String strPhoneNumber, double totalCost, Double tips, Double charge) {
        try { 
            String years = orderid.substring(0,4);
            String month = orderid.substring(4,6);
            String date = orderid.substring(6,8);
           
            st = connection.createStatement();
            sql = "INSERT INTO IS2730.ORDERS (ORDERID, PHONE, YEARS, MONTH, DATE, STAFFID, TIP, SUBTOTAL, TOTAL, WALKIN) VALUES " +
                "('"+ orderid+"', '"+strPhoneNumber+"', '"+years+"', '"+month+"', '"+date+"', 'togo',"+tips+","+totalCost+","+charge+",'false')";
            st.executeUpdate(sql);  
                
	    } catch (SQLException e) {
            e.printStackTrace();
	    }
    }

    public void tellmanager(String orderid, String strPhoneNumber, String customername, String orderedmeals) {
        try { 
            String ordertime = orderid.substring(0,8);  
           
            st = connection.createStatement();
            sql = "INSERT INTO IS2730.TOGOTEMP (ORDERID, CNAME, PHONE, ORDERTIME, ORDEREDM, COOKED, COLLECTED) VALUES " +
                "('"+ orderid+"', '"+customername+"', '"+strPhoneNumber+"', '"+ordertime+"', '"+orderedmeals+"','false','false')";
            st.executeUpdate(sql);  
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateTempCook(String orderid) {
        try { 
            PreparedStatement preparedStatement = connection.prepareStatement("update togotemp set cooked='true'" +
                            "where orderid=?");          
            preparedStatement.setString(1, orderid);
            preparedStatement.executeUpdate();
                
        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    
    public void updateTempCollect(String orderid) {
        try { 
            PreparedStatement preparedStatement = connection.prepareStatement("update togotemp set collected='true'" +
                            "where orderid=?");          
            preparedStatement.setString(1, orderid);
            preparedStatement.executeUpdate();
                
        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    public void deleteTemp(String orderid) {
        try { 
            PreparedStatement preparedStatement = connection.prepareStatement("delete from togotemp where orderid=?");          
            preparedStatement.setString(1, orderid);
            preparedStatement.executeUpdate();
                
        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
   
    public List<TogoBean> getAllOrders(){
        List<TogoBean> togo = new ArrayList<TogoBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from togotemp");
            while (rs.next()) {
                TogoBean pickup = new TogoBean();
                pickup.setOrderid(rs.getString("orderid"));
                pickup.setCname(rs.getString("cname"));
                pickup.setPhone(rs.getString("phone"));
                pickup.setOrderTime(rs.getString("ordertime"));
                pickup.setOrderContent(rs.getString("orderedm"));
                pickup.setCooked(rs.getString("cooked"));
                pickup.setCollected(rs.getString("collected"));
                togo.add(pickup);
            }
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return togo;
    }
}
