package com.example.restapi.restapi.controller;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductsController {

    private ProductRepository productRepository;

    private Logger LOG = LoggerFactory.getLogger(ProductsController.class);

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

    @RequestMapping(path ="{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product productToUpdate, @PathVariable(name="id") String id) {
        Product foundProduct = productRepository.findById(id).orElse(null);
        if(foundProduct != null) {
            foundProduct.setName(productToUpdate.getName());
            foundProduct.setDescription(productToUpdate.getDescription());
            foundProduct.setType(productToUpdate.getType());
            foundProduct.setCategory(productToUpdate.getCategory());
            foundProduct.setPrice(productToUpdate.getPrice());
            productRepository.save(foundProduct);
            return foundProduct;
        } else  {
            LOG.info("id not found");
            return productToUpdate;
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") String id){
        Product productToDelete = productRepository.findById(id).orElse(null);

        if(productToDelete != null){
            productRepository.delete(productToDelete);
            LOG.info("product deleted");
        } else{
            LOG.info("id not found");
        }
    }
}
