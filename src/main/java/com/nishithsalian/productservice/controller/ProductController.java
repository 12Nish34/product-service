package com.nishithsalian.productservice.controller;

import com.nishithsalian.productservice.dto.ProductRequest;
import com.nishithsalian.productservice.dto.ProductResponse;
import com.nishithsalian.productservice.services.ProductServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/product")
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping("/")
    public void createProduct(@RequestBody ProductRequest productRequest){
        log.info("Product is {}",productRequest.getName());
        productServices.addProduct(productRequest);
    }

    @GetMapping("/")
    public List<ProductResponse> getProducts(){
        return productServices.getProducts();
    }
}
