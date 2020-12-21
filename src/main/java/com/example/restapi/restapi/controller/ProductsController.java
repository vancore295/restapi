package com.example.restapi.restapi.controller;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductsController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET )
    public Product getProduct(@PathVariable(name="id") String id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product productToSave) {
        return productRepository.save(productToSave);
    }
}
