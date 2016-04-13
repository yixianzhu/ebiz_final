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
    private String name;
    private int quantity;
    private String size;
    public CalebBean() {
        status = defaul;
        userid=new String();
        name = new String();
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}

    public String getUserid() {return userid;}
    public void setUserid(String value) {userid = value;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int value) {quantity = value;}
     public String getSize() {return size;}
    public void setSize(String value) {size = value;}

    public String getName() {return name;}
    public void setName(String value) {name = value;}
}
