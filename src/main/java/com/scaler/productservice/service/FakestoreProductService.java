package com.scaler.productservice.service;

import com.scaler.productservice.dtos.FakestoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FakestoreProductService implements ProductService {

    private final RestTemplate restTemplate;
    List<Product> products = new ArrayList<>();

    @Autowired
    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertProductDtoToProduct(FakestoreProductDto fakestoreProduct) {
        Product product = new Product();
        product.setCategory(new Category());
        product.getCategory().setName(fakestoreProduct.getCategory());
        product.setId(fakestoreProduct.getId());
        product.setTitle(fakestoreProduct.getTitle());
        product.setImageUrl(fakestoreProduct.getUrl());
        product.setPrice(fakestoreProduct.getPrice());
        product.setDescription(fakestoreProduct.getDescription());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakestoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreProductDto.class);
        return convertProductDtoToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakestoreProductDto[] productDto = restTemplate.getForObject("https://fakestoreapi.com/products/", FakestoreProductDto[].class);
        return Arrays.stream(productDto).map(this::convertProductDtoToProduct).collect(Collectors.toList());
    }

    @Override
    public void addNewProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Long id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(id)) {
                products.set(i, updatedProduct);
                break;
            }

        }
    }
    @Override
    public void deleteProduct(Long id) {

    for(int i = 0; i<products.size();i++){
        if(Objects.equals(id, products.get(i).getId())){
            products.remove(i);
            break;
        }
    }
  }

  @Override
  public void replaceProduct(Long id, Product product){
        for(int i=0; i<products.size(); i++){
            if(Objects.equals(id, products.get(i).getId())){
                products.set(i,product);
            }
        }
  }

}
