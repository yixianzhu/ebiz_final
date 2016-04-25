/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author xun yang
 */
public class HistoryBean {
    private String staffid;
    private String mealid;
    private String mealname;
    private double sale;
    private int quantity;
    public String getStaffid() {
        return staffid;
    }
    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }
    public String getMealid() {
        return mealid;
    }
    public void setMealid(String mealid) {
        this.mealid = mealid;
    }
    public String getMealname() {
        return mealname;
    }
    public void setMealname(String mealname) {
        this.mealname = mealname;
    }
   
    public double getSale() {
        return sale;
    }
    public void setSale(double sale) {
        this.sale = sale;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int value) {
        quantity = value;
    }
}
