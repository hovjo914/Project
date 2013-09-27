/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.Date;

/**
 *
 * @author John
 */
public class Order {

    private Integer customer;
    private Date date;

    public Order(Customer cust) {
    }

    public Integer getOrderID() {
        return customer;
    }

    public void setOrderID(Integer orderID) {
        this.customer = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // public Integer getTotal(){
    //    return ;
    //  public void addItem(orderItem){
    public Order(Integer orderID, Date date) {
        this.customer = orderID;
        this.date = date;
    }
}
