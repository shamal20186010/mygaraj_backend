package org.mygaraj.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.mygaraj.dto.Product;
import org.mygaraj.entity.ProductEntity;
import org.mygaraj.reporsitory.ProductRepository;
import org.mygaraj.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public List<Product> getProduct() {
        List<Product> productArrayList = new ArrayList<>();
        productRepository.findAll().forEach(entity->{
            productArrayList.add(mapper.map(entity, Product.class));
        });
        return productArrayList;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(mapper.map(product, ProductEntity.class));
    }

    @Override
    public void updateProductById(Product product) {
        productRepository.save(mapper.map(product,ProductEntity.class));
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {

        return mapper.map(productRepository.findById(id),Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
//        List<Product> listBySearchName =new ArrayList<>();
//        productReporsitory.findByName().forEach(entity ->{
//            listBySearchName.add(mapper.map(entity,Product.class));
//        });
        return null;
    }

    @Override
    public List<Product> findByCategory(String category) {
//        List<Product> listBySearchCategory =new ArrayList<>();
//        productReporsitory.findByCategory().forEach(entity ->{
//            listBySearchCategory.add(mapper.map(entity,Product.class));
//        });
        return null;
    }
}
