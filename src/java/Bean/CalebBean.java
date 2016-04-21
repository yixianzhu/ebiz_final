/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Xun
 */
import java.io.Serializable;


    public class CalebBean extends Object implements Serializable {

    public static final String ISTATUS = "Login";
    public static final String defaul = "Welcome back!";
    private String status;
    private String userid;
    private String tableid;
    private String name;
    private int quantity;
    private String size;
    private int order;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String time;
    private String guest;
    private String date;
    private double cost;
    public CalebBean() {
        status = defaul;
        userid=new String();
        name = new String();
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}

    public String getUserid() {return userid;}
    public void setUserid(String value) {userid = value;}
    public String getTableid() {return tableid;}
    public void setTableid(String value) {tableid = value;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int value) {quantity = value;}
     public String getSize() {return size;}
    public void setSize(String value) {size = value;}

    public String getName() {return name;}
    public void setName(String value) {name = value;}
    
    public int getOrder() {return order;}
    public void setOrder(int value) {order = value;}
    public String getFname() {return fname;}
    public void setFname(String value) {fname = value;}
    public String getLname() {return lname;}
    public void setLname(String value) {lname = value;}
    public String getEmail() {return email;}
    public void setEmail(String value) {email = value;}
    public String getPhone() {return phone;}
    public void setPhone(String value) {phone = value;}
    public String getTime() {return time;}
    public void setTime(String value) {time = value;}
    public String getGuest() {return guest;}
    public void setGuest(String value) {guest = value;}
    public String getDate() {return date;}
    public void setDate(String value) {date = value;}
    public double getCost() {return cost;}
    public void setCost(double value) {cost = value;}
    
    
}
