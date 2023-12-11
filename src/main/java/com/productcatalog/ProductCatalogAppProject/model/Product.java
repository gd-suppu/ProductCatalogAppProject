package com.productcatalog.ProductCatalogAppProject.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Product implements Serializable {
    @Id
    private String uniq_id;
    private String sku;
    private String name_title;
    @Column(columnDefinition="varchar2(10000)")
    private String description;
    private String list_price;
    private String sale_price;
    private String category;
    private String category_tree;
    private String average_product_rating;
    @Column(columnDefinition="varchar2(10000)")
    private String product_url;
    @Column(columnDefinition="varchar2(10000)")
    private String product_image_urls;
    private String brand;
    private String total_number_reviews;
    @Column(columnDefinition="varchar2(50000)")
    private String Reviews;
}
