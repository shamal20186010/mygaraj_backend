package org.mygaraj.controller;

import lombok.RequiredArgsConstructor;
import org.mygaraj.dto.Product;
import org.mygaraj.dto.ProductUpdateRequest;
import org.mygaraj.entity.ProductEntity;
import org.mygaraj.exceptions.ProductNotFoundException;
import org.mygaraj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    @Autowired
    final ProductService productService;

    @GetMapping("/getAll-product")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> productList = productService.getProduct();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductEntity> saveProduct(
            @RequestParam("prName") String prName,
            @RequestParam("prDescription") String prDescription,
            @RequestParam("prQty") Integer prQty,
            @RequestParam("prCategory") String prCategory,
            @RequestParam("prPrice") double prPrice,
            @RequestParam("image") MultipartFile image) throws IOException {

        String base64Image = Base64.getEncoder().encodeToString(image.getBytes());

        Product product = new Product();
        product.setPrName(prName);
        product.setPrDescription(prDescription);
        product.setPrQty(prQty);
        product.setPrCategory(prCategory);
        product.setPrPrice(prPrice);
        product.setImage(base64Image);


        try {
            ProductEntity savedProduct = productService.saveProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update-product/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> updateProduct(
            @PathVariable Long id,
            @RequestParam("prName") String prName,
            @RequestParam("prDescription") String prDescription,
            @RequestParam("prQty") Integer prQty,
            @RequestParam("prCategory") String prCategory,
            @RequestParam("prPrice") double prPrice,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        try {
            Product product = new Product();
            product.setPrId(id);
            product.setPrName(prName);
            product.setPrDescription(prDescription);
            product.setPrQty(prQty);
            product.setPrCategory(prCategory);
            product.setPrPrice(prPrice);

            if (image != null && !image.isEmpty()) {
                String base64Image = Base64.getEncoder().encodeToString(image.getBytes());
                product.setImage(base64Image);
            }

            productService.updateProductById(product);
            return ResponseEntity.ok("Product updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product.");
        }
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<String> updateProductQuantities(@RequestBody List<ProductUpdateRequest> updateRequests) {
        try {
            productService.updateQuantities(updateRequests);
            return ResponseEntity.ok("{\"message\":\"Product quantities updated successfully.\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/delete-product-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Integer id) {
        if (!productService.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
        productService.deleteProductById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product deleted successfully.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
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
