/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author John
 */
public class Product implements Comparable<Product> {

    @NotNull(message = "ID must be provided.")
    @Range(min = 100, max = 9999999,
            message = "productID must contain between 5 and 8 digits (Inclusive).")
    private String productID;
    @NotBlank(message = "Name must be provided.")
    @Length(min = 2, message = "Name must contain at least two characters.")
    private String productName;
    @NotBlank(message = "Category must be provided.")
    @Length(min = 4, max = 10, message = "Major must be a four character code.")
    private String category;
    @NotBlank(message = "Price must be provided.")
    @Length(min = 2, max = 9)
    private double price;
    @NotBlank(message = "Quantity must be provided.")
    @Length(min = 1, max = 5)
    private int quantity;
    private String description;

    public Product(String productID, String productName, String description, String category, Double price, Integer quantity) {

        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.productID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID: " + productID + ",   Name: " + productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Product t) {
        return this.getProductID().compareTo(t.getProductID());
    }
}
