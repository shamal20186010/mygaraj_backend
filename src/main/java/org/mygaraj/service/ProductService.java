package org.mygaraj.service;

import org.mygaraj.dto.Product;
import org.mygaraj.dto.ProductUpdateRequest;
import org.mygaraj.entity.ProductEntity;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getProduct();

    ProductEntity saveProduct(Product product) throws IOException;

    void updateProductById(Product product);

    void updateQuantities(List<ProductUpdateRequest> updateRequests);

    void deleteProductById(Integer id);

    Product findById(Integer id);

    List<Product> findByName(String name);

    List<Product> findByCategory(String category);

    boolean existsById(Integer id);
}
