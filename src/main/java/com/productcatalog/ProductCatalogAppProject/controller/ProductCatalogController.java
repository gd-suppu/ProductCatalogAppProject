package com.productcatalog.ProductCatalogAppProject.controller;

import com.productcatalog.ProductCatalogAppProject.model.Product;
import com.productcatalog.ProductCatalogAppProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/catalog")
public class ProductCatalogController {
    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() throws FileNotFoundException {
        try{
            File file = ResourceUtils.getFile("classpath:jcpsample.csv");
            FileInputStream inputFile = new FileInputStream(file);
            productService.save(inputFile);
            return new ResponseEntity<>("Loaded",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Exception while loading",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
