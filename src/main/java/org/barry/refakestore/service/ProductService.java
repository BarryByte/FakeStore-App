package org.barry.refakestore.service;

import org.barry.refakestore.ReFakeStoreDTO.CategoryDTO;
import org.barry.refakestore.ReFakeStoreDTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.barry.refakestore.models.Product;
import org.barry.refakestore.models.Category;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    //create a resttemplate object to make http requests
    RestTemplate restTemplate = new RestTemplate();
    // define the base url for the fake store api
    String url = "https://fakestoreapi.com";
    //Method to retrieve details of a single product by its ID

    public ProductDTO getSingleProduct(Long id) {
        //make a GET request to the API endpoint for a single product
        ProductDTO response = restTemplate.getForObject(url + "/products" + id, ProductDTO.class);
        return response;
    }

    public ProductDTO[] getAllProducts() {
        ProductDTO[] response = restTemplate.getForObject(url + "/products", ProductDTO[].class);
        return response;
    }

    public ProductDTO createProduct(Product product) {
        //to add a product, first we need to create a ProductDTO object to represent the product
        //set the properties of the ProductDTO object based on the input project
        ProductDTO productdto = new ProductDTO();
        productdto.setTitle(product.getTitle());
        //productdto.setCategory(product.getCategory());
        productdto.setPrice(product.getPrice());
        productdto.setDescription(product.getDescription());
        productdto.setId(product.getId());

        //use restTemplate to make a POST request to add the product
        ProductDTO response = restTemplate.postForObject(url, productdto, ProductDTO.class);
        //ensure tht the response is not null;
        assert response != null;
        return response;
    }

    public void deleleProduct(Long id){
        restTemplate.delete(url + "/products" + id);
    }

    public ProductDTO updateProduct(Long id, Product product){

        ProductDTO productdto = new ProductDTO();
        productdto.setId(product.getId());
        productdto.setTitle(product.getTitle());
//        productdto.setCategory(product.getCategory());
        productdto.setPrice(product.getPrice());
        productdto.setDescription(product.getDescription());

        //put syntax -> (url , updatedObject(representing the updated resource which will be sent as the request body))
        restTemplate.put(url + "/products" + id, productdto);
        return productdto;
    }
//    public List<Category> getCategories(){
//        ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<>() {};
//        List<String> response = restTemplate.exchange(url + "/products/categories", HttpMethod.GET, null, responseType).getBody();
//        List<Category> cat = new ArrayList<>();
//        if(response == null){
//            return cat;
//        }
//        for (String c : response){
//            Category category = new Category();
//            category.setName(c);
//            cat.add(category);
//        }
//        return cat;
//    }
    public String[] getCategories(){
    String[] response = restTemplate.getForObject(url + "/products/categories", String[].class);
    return response;
    }

    //this is a change.
    //this is another change.
}
