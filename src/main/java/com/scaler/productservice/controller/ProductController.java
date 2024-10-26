package com.scaler.productservice.controller;

import java.util.*;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    final private ProductService productService;

    @Autowired
    private ProductController(ProductService productService) {
    this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){
         ResponseEntity<Product> response = new ResponseEntity<Product>(productService.getSingleProduct(id),HttpStatus.ACCEPTED);
        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
         productService.updateProduct(id,product);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
       productService.deleteProduct(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
      ResponseEntity<Product> response = new ResponseEntity<>(productService.replaceProduct(id,product),HttpStatus.OK);
      return response;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        ResponseEntity<List<Category>> response = new ResponseEntity<>(productService.getAllCategories(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductWithCategory(@PathVariable("categoryName") String categoryName){
        return new ResponseEntity<>(productService.getProductWithCategory("categoryName"), HttpStatus.OK);
    }
}
