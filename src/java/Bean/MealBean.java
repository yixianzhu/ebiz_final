/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xun yang
 */
public class MealBean extends Object implements Serializable{
    private String id;
    private String name;
    private String category;
    private String description;
    private double price;
    private String hint;
    private int quantity;
    private String size;
    private String image;
    private String tableid;
    private String status;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getHint() {
        return hint;
    }
    public void setHint(String hint) {
        this.hint = hint;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getTableid() {
        return tableid;
    }
    public void setTableid(String tableid) {
        this.tableid = tableid;
    }
     public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getQuantity() {return quantity;}
    public void setQuantity(int value) {quantity = value;}
    public String getSize() {return size;}
    public void setSize(String value) {size = value;}
}
