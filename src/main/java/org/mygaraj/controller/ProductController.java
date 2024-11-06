package org.mygaraj.controller;

import lombok.RequiredArgsConstructor;
import org.mygaraj.dto.Product;
import org.mygaraj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    @Autowired
    final ProductService productService;

    @GetMapping("/getAll-product")
    public List<Product> getProduct() {
        return productService.getProduct();
    }

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update-product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product) {
        productService.updateProductById(product);
    }

    @DeleteMapping("/delete-product-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/search-by-id/{id}")
    public Product searchProductById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Product> searchByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/search-by-category/{category}")
    public List<Product> searchByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }


}
