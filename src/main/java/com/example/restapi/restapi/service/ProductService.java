package com.example.restapi.restapi.service;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getOne(String id) {
        LOG.info("Getting product with id: " + id);
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product newProduct) {
        try {
            LOG.info("Saving Product...");
            return productRepository.save(newProduct);
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return new Product();
    }

    public Product updateProduct(String id, Product productToUpdate) {
        Product foundProduct = productRepository.findById(id).orElse(null);
        try{
            foundProduct.setName(productToUpdate.getName());
            foundProduct.setDescription(productToUpdate.getDescription());
            foundProduct.setType(productToUpdate.getType());
            foundProduct.setCategory(productToUpdate.getCategory());
            foundProduct.setPrice(productToUpdate.getPrice());
            productRepository.save(foundProduct);
            return foundProduct;
        }catch (Exception ex) {
            LOG.error(ex.getMessage());
        }

        return new Product();
    }

    public void deleteProduct(String id) {
        Product productToDelete = productRepository.findById(id).orElse(null);
        try {
            LOG.info("Deleting product with id: " + id);
            productRepository.delete(productToDelete);
            LOG.info("product deleted");
        }catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
    }
}
