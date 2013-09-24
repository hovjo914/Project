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

    private String userName;
    private String name;
    private String password;
    private String address;
    private String creditCard;

    public Customer(String userName, String password,String name, String address, String creditCard) {
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.creditCard = creditCard;
        this.name=name;
    }

    public Customer() {
    }

    public String getUserName() {
        return userName;
    }
    
     public String getName() {
        return name;
    }

     public void setName(String userName) {
        this.name = name;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
