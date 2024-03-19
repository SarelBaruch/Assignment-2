package com.example.myfragmentapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String phone;

    private List<Product> products;

    public User(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.products = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }
}
