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

    private Integer orderID;
    private Integer date;

   public Order(Customer cust) {
      throw new UnsupportedOperationException("Not yet implemented");
   }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
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
        this.orderID = orderID;
        this.date = date;
    }
}
