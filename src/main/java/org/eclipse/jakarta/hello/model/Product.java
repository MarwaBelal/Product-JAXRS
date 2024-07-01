package org.eclipse.jakarta.hello.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Product {
    int id;
    @NotBlank(message = "Name is Required.")
    String name;
    @Positive(message = "The price must be positive.")
    double price;
    @Positive(message = "The quantity must be positive.")
    @Digits(integer = 10, fraction = 0, message = "Quantity must be a numeric value with no decimal")
    int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
