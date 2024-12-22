package myApp.controller;


import myApp.model.Product;

import myApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProduct(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "product";
    }
    @GetMapping("/products/new")
    public String createProductForm(Model model){
        model.addAttribute("product",new Product());
        return "createProduct";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product){
      productService.saveProduct(product);
      return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public  String editProductForm(@PathVariable("id") Long id,Model model){
      model.addAttribute("product",productService.getProductById(id));
      return "editProductForm";
    }

    @PostMapping("/products/{id}")
    public String editProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product){
        productService.updateProduct(id,product);
        return "redirect:/products";
    }
    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
