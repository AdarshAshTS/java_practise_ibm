package com.thymleafdemo.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymleafdemo.models.Product;


public class ProductController{
    @GetMapping("/products")
    public String products(Model model) {

        List<Product> products = List.of(
                new Product(1,"Laptop",75000),
                new Product(2,"Mobile",30000),
                new Product(3,"Keyboard",1500),
                new Product(4,"Mouse",800)
        );

        model.addAttribute("products", products);

        return "products";
    }
}