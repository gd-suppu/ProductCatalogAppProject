package com.productcatalog.ProductCatalogAppProject.service;

import com.productcatalog.ProductCatalogAppProject.exception.ResourceNotFoundException;
import com.productcatalog.ProductCatalogAppProject.helper.CSVHelper;
import com.productcatalog.ProductCatalogAppProject.model.Product;
import com.productcatalog.ProductCatalogAppProject.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsRepository repository;
    @Override
    public void save(InputStream file) {
        List<Product> orders = CSVHelper.csvToOrders(file);
        repository.saveAll(orders);
    }
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getUniqueById(String uniqueId) {
            Optional<Product> productDb=repository.findById(uniqueId);
            if(productDb.isPresent()){
                return productDb.get();
            }
        else{
            throw new ResourceNotFoundException("Record not found with id :"+uniqueId);
            }
    }

    @Override
    public List<Product> getProductsBySku(String sku) {
        return repository.findBySku(sku);
    }

}
