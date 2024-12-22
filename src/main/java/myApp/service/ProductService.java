package myApp.service;

import myApp.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product); // Create
    List<Product> getAllProducts(); // Read
    Product getProductById(Long id); // Read by ID
    Product updateProduct(Long id, Product product); // Update
    void deleteProduct(Long id); // Delete

}
