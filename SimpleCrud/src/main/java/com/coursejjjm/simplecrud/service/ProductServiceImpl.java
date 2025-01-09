package com.coursejjjm.simplecrud.service;

import com.coursejjjm.simplecrud.mappers.ProductMappers;
import com.coursejjjm.simplecrud.model.product.Product;
import com.coursejjjm.simplecrud.model.rdmProduct.RdmProduct;
import com.coursejjjm.simplecrud.repository.ProductRepository;
import com.coursejjjm.simplecrud.rest.RandomProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final RandomProductClient randomProductClient;
    private final ProductMappers productMappers;

    // create instance of Random class
    Random rand = new Random();

    public ProductServiceImpl(
            ProductRepository productRepository,
            RandomProductClient randomProductClient,
            ProductMappers productMappers
    ) {
        this.productRepository = productRepository;
        this.randomProductClient = randomProductClient;
        this.productMappers = productMappers;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product createRandmProduct() {

        int id = rand.nextInt(195);

        RdmProduct rdmProduct = randomProductClient.getRandomProduct(id);
        log.info("rdmProduct: {}", rdmProduct);

        Product product = productMappers.rdmProductToProduct(rdmProduct);

        if (product != null) {
            productRepository.save(product);
        }

        return product;
    }
}
