package com.nishithsalian.productservice.services;


import com.nishithsalian.productservice.dto.ProductRequest;
import com.nishithsalian.productservice.dto.ProductResponse;
import com.nishithsalian.productservice.model.Product;
import com.nishithsalian.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;

@Service
@Slf4j
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductRequest productResponse){
        Product product = Product.builder()
                .name(productResponse.getName())
                .description(productResponse.getDescription())
                .price(productResponse.getPrice())
                .build();
        productRepository.save(product);

        log.info("Product is saved with id {}",product.getId());
    }

    public List<ProductResponse> getProducts(){
        List<Product> product = productRepository.findAll();
        log.info(product.toString());
        return product.stream().map(products -> mapProductResponse(products)).toList();
    }

    private ProductResponse mapProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
