package org.barry.refakestore.controller;

import org.barry.refakestore.ReFakeStoreDTO.CategoryDTO;
import org.barry.refakestore.ReFakeStoreDTO.ProductDTO;
import org.barry.refakestore.models.Category;
import org.barry.refakestore.models.Product;
import org.barry.refakestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;

    @GetMapping("/products")
    public ProductDTO[] getAllProducts(){
        return ps.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getSingleProduct(@PathVariable Long id){
        return ps.getSingleProduct(id);
    }

    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody Product product){ return ps.createProduct(product);}

    //Use PATCH when you want to perform partial updates to a resource, modifying only the specified fields.
    //Use PUT when you want to replace the entire resource with a new representation, even if some fields are not provided in the request.

    @PutMapping("/products/{id}")
    public  ProductDTO updateProduct(@PathVariable Long id , @RequestBody Product product ) {
        return ps.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        ps.deleleProduct(id);
        return "Product deleted successfully";
    }

    @GetMapping("/products/categories")
    public String[] getCategories(){
        return ps.getCategories();
    }


}
