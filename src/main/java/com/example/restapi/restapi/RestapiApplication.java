package com.example.restapi.restapi;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        Product product1 = new Product();
        product1.setName("Simple Product");
        product1.setDescription("this is a tester product");
        product1.setCategory("SPECIAL");
        product1.setType("CUSTOM");
        product1.setPrice(295.0);

        productRepository.save(product1);*/
    }
}
