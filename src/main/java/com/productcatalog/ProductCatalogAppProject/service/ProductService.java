package com.productcatalog.ProductCatalogAppProject.service;

import com.productcatalog.ProductCatalogAppProject.helper.CSVHelper;
import com.productcatalog.ProductCatalogAppProject.model.Product;
import com.productcatalog.ProductCatalogAppProject.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepository repository;

    public void save(InputStream file) {
        List<Product> orders = CSVHelper.csvToOrders(file);
        repository.saveAll(orders);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
