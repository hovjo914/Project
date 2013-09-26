/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author John
 */
public class Customer {

    private String customername;
 
    private String password;
    private String address;
    private String creditCard;

    public Customer(String userName, String password, String address, String creditCard) {
        this.customername = userName;
        this.password = password;
        this.address = address;
        this.creditCard = creditCard;
      
    }

    public Customer() {
    }

    public String getUserName() {
        return customername;
    }

    public String getName() {
        return customername;
    }

    public void setName(String customername) {
        this.customername = customername;
    }

    public void setUserName(String customername) {
        this.customername = customername;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
