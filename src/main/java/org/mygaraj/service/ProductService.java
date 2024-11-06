package org.mygaraj.service;

import org.mygaraj.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProduct();

    void addProduct(Product product);

    void updateProductById(Product product);

    void deleteProductById(Integer id);

    Product findById(Integer id);

    List<Product> findByName(String name);

    List<Product> findByCategory(String category);
}
