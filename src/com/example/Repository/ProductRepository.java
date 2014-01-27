package com.example.Repository;

import com.example.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public void createProduct(String title, String description) {
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("TITLE1","DESC1"));
        products.add(new Product("TITLE2","DESC2"));
        products.add(new Product("TITLE3","DESC3"));
        return products;
    }
}
