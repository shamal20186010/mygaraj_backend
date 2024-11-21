package org.mygaraj.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.mygaraj.dto.Product;
import org.mygaraj.dto.ProductUpdateRequest;
import org.mygaraj.entity.ProductEntity;
import org.mygaraj.reporsitory.ProductRepository;
import org.mygaraj.service.ProductService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public List<Product> getProduct() {
        List<Product> productArrayList = new ArrayList<>();
        productRepository.findAll().forEach(entity -> {
            Product product = mapper.map(entity, Product.class);

            // Base64 encoding for the image
            if (entity.getImage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(entity.getImage());
                product.setImage(base64Image);
            }

            productArrayList.add(product);
        });
        return productArrayList;
    }

    @Override
    public ProductEntity saveProduct(Product product) throws IOException {
        ProductEntity productEntity = mapper.map(product, ProductEntity.class);

        if (product.getImage() != null) {
            productEntity.setImage(Base64.getDecoder().decode(product.getImage()));
        }
        return productRepository.save(productEntity);
    }

//    @Override
//    public void addProduct(Product product) {
//        productRepository.save(mapper.map(product, ProductEntity.class));
//    }

    @Override
    public void updateProductById(Product product) {
        ProductEntity productEntity = productRepository.findById(Math.toIntExact(product.getPrId()))
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productEntity.setPrName(product.getPrName());
        productEntity.setPrDescription(product.getPrDescription());
        productEntity.setPrQty(product.getPrQty());
        productEntity.setPrCategory(product.getPrCategory());
        productEntity.setPrPrice(product.getPrPrice());

        if (product.getImage() != null) {
            productEntity.setImage(Base64.getDecoder().decode(product.getImage()));
        }

        productRepository.save(productEntity);
    }

    public void updateQuantities(List<ProductUpdateRequest> updateRequests) {
        for (ProductUpdateRequest request : updateRequests) {
            ProductEntity productEntity = productRepository.findById(Math.toIntExact(request.getProductId()))
                    .orElseThrow(() -> new RuntimeException("Product not found: " + request.getProductId()));

            if (productEntity.getPrQty() < request.getQuantity()) {
                throw new RuntimeException("Insufficient quantity for product: " + productEntity.getPrName());
            }

            productEntity.setPrQty(productEntity.getPrQty() - request.getQuantity());
            productRepository.save(productEntity);
        }
    }

    public Product convertToDto(ProductEntity entity) {
        return mapper.map(entity, Product.class);
    }

    public ProductEntity convertToEntity(Product dto) {
        return mapper.map(dto, ProductEntity.class);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {

        return mapper.map(productRepository.findById(id), Product.class);
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
