package com.scaler.productservice.controller;

import java.util.*;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    private ProductController(ProductService productService) {
    this.productService = productService;
}

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
         productService.updateProduct(id,product);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
       productService.deleteProduct(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
      productService.replaceProduct(id,product);
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
