package com.productcatalog.ProductCatalogAppProject.service;

import com.productcatalog.ProductCatalogAppProject.model.Product;

import java.io.InputStream;
import java.util.List;

public interface ProductService {

    public void save(InputStream file);
    List<Product > getAllProducts();

    Product getUniqueById(String uniqueId);

    List<Product> getProductsBySku(String sku);

}
