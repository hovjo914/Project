/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author John
 */
public class Order {

    private Integer customer;
    private Integer date;

    public Order(Customer cust) {
    }

    public Integer getOrderID() {
        return customer;
    }

    public void setOrderID(Integer orderID) {
        this.customer = orderID;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    // public Integer getTotal(){
    //    return ;
    //  public void addItem(orderItem){
    public Order(Integer orderID, Integer date) {
        this.customer = orderID;
        this.date = date;
    }
}
