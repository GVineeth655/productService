package com.scaler.productservice.controller;

import java.util.*;

import com.scaler.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {

    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<Product>();
    }

    @GetMapping("/{id}")
    public Product getASingleProduct(@PathVariable("id") Long id){
        return new Product();
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){

        Product p =  new Product();
        p.setTitle("Add new item");
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

}
