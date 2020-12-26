package com.example.restapi.restapi.controller;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;
import com.example.restapi.restapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductsController {

    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private Logger LOG = LoggerFactory.getLogger(ProductsController.class);

    @RequestMapping(path = "{id}", method = RequestMethod.GET )
    public Product getProduct(@PathVariable(name="id") String id) {
        return productService.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product productToSave) {
        return productService.saveProduct(productToSave);
    }

    @RequestMapping(path ="{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product productToUpdate, @PathVariable(name="id") String id) {
        return productService.updateProduct(id, productToUpdate);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") String id){
        productService.deleteProduct(id);
    }
}
