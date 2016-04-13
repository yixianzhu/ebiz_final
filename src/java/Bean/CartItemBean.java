/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author zhuyixian
 */
public class CartItemBean {
    private String itemNo;
    private String itemName;
    private String category;
    private int quantity;
    private double price;
    private double subSumCost;
    
    public String getItemNo(){
        return itemNo;
    }
    
    public void setItemNo(String newItermNo){
        itemNo = newItermNo;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public void setItemName(String newItermName){
        itemName = newItermName;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String newCategory){
        category = newCategory;
    }

    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public double getSubSumCost(){
        return subSumCost;
    }
    
    public void setSubSumCost(double newSubSumCost){
        subSumCost = newSubSumCost;
    }
    
}
