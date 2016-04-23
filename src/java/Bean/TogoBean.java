/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;

/**
 *
 * @author xun yang
 */
public class TogoBean extends Object implements Serializable{
    private String orderid;
    private String cname;
    private String phone;
    private String orderTime;
    private String orderContent;
    private String cooked;
    private String collected;
    public String getOrderid() {
        return orderid;
    }
    public void setOrderid(String value) {
        this.orderid = value;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String value) {
        this.cname = value;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String value) {
        this.phone = value;
    }
    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String value) {
        this.orderTime = value;
    }
    public String getOrderContent() {
        return orderContent;
    }
    public void setOrderContent(String value) {
        this.orderContent = value;
    }
    public String getCooked() {
        return cooked;
    }
    public void setCooked(String value) {
        this.cooked = value;
    }
    public String getCollected() {
        return collected;
    }
    public void setCollected(String value) {
        this.collected = value;
    }
}
