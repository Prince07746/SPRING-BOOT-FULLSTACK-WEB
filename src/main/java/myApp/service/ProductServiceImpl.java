package myApp.service;


import myApp.model.Product;
import myApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("\"Product not found with id: \" + id"));
    }
    @Override
    public Product updateProduct(Long id,Product product){
        Product foundProduct = getProductById(id);

        foundProduct.setName(product.getName());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setDescription(product.getDescription());

        return productRepository.save(foundProduct);

    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
