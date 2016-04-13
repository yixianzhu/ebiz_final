/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author zhuyixian
 */
public class CartBean {
    private HashMap<String, CartItemBean> alCartItems = new HashMap<String, CartItemBean>();
    private double totalCost;
    
    public int getCartSize(){
        return alCartItems.size();
    }

    public void addCartItem(String strItemNo, String strItemName, String strPrice, String strCategory, String strQuantity){
        double subSumCost = 0.0;
        double price = 0.0;
        int iQuantity = 0;
        // CartItemBean cartItem = new CartItemBean();
        try{
            price = Double.parseDouble(strPrice);//we need to parst here
            iQuantity = Integer.parseInt(strQuantity);
            if(iQuantity > 0){
                subSumCost = price*iQuantity;
                if(alCartItems.containsKey(strItemNo)){
                    CartItemBean cartItem = alCartItems.get(strItemNo);
                    cartItem.setQuantity(cartItem.getQuantity()+iQuantity);
                    cartItem.setSubSumCost(cartItem.getSubSumCost()+subSumCost);

                }else{
                    CartItemBean cartItem = new CartItemBean();
                    cartItem.setItemNo(strItemNo);
                    cartItem.setQuantity(iQuantity);
                    cartItem.setItemName(strItemName);
                    cartItem.setPrice(price);
                    cartItem.setCategory(strCategory);
                    cartItem.setSubSumCost(subSumCost);
                    alCartItems.put(strItemNo, cartItem);
                }
                calculateOrderTotal();
            }
        }catch(NumberFormatException nfe){
            System.out.println("Error while parsing from String to primitive types: "+nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void deleteCartItem(String strItemNo){
        // int iItemNo = 0;
        try{
            // iItemNo = Integer.parseInt(strItemNo);
            alCartItems.remove(strItemNo);
            calculateOrderTotal();
        }catch(NumberFormatException nfe){
            System.out.println("Error while deleting cart item: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void updateCartItem(String strItemNo, String strQuantity){
        double subSumCost = 0.0;
        double price = 0.0;
        int iQuantity = 0;
        // int iItemNo = 0;
        CartItemBean cartItem = null;
        try{
            // iItemNo = Integer.parseInt(strItemNo);
            iQuantity = Integer.parseInt(strQuantity);
            if(iQuantity>0){
                cartItem = (CartItemBean)alCartItems.get(strItemNo);
                price = cartItem.getPrice();//no need to parse here
                subSumCost = price*iQuantity;
                cartItem.setQuantity(iQuantity);
                cartItem.setSubSumCost(subSumCost);
                calculateOrderTotal();
            }
        }catch (NumberFormatException nfe){
            System.out.println("Error while update cart:" + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

//    public void addCartItem(CartItemBean cartItem){
//        alCartItems.add(cartItem);
//    }

    // public CartItemBean getCartItem(String iItemNo){
    //     CartItemBean cartItem = null;
    //     if(alCartItems.size()>iItemNo){
    //         cartItem = (CartItemBean) alCartItems.get(iItemNo);
    //     }
    //     return cartItem;
    // }

    public ArrayList getCartItems() {
        ArrayList ALalCartItems = new ArrayList<CartItemBean>();
        for (CartItemBean cartItem: alCartItems.values()) {
            ALalCartItems.add(cartItem);
        }
        return ALalCartItems;
    }
    
    // public void setCartItems(ArrayList alCartItems) {
    //      this.alCartItems = alCartItems;
    // }
    
    public double getTotalCost() {
        return totalCost;
    }
    
     public void setTotalCost(double newTotalCost) {
          totalCost = newTotalCost;
     }

    protected void calculateOrderTotal(){
        double totalCost = 0;
        for (CartItemBean cartItem: alCartItems.values()) {
            totalCost += cartItem.getSubSumCost();
        }
        setTotalCost(totalCost);
    }
    
}
