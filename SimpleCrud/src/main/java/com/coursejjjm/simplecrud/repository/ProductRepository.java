package com.coursejjjm.simplecrud.repository;

import com.coursejjjm.simplecrud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() { return products; }

    public Product findById(int id) { return products.get(id); }

    public void save(Product product) {
        products.add(product);
    }

    public void update(Product product) {
        int index = products.indexOf(product);

        Product updatetedProduct = new Product();
        updatetedProduct.setId(product.getId());
        updatetedProduct.setName(product.getName());
        updatetedProduct.setPrice(product.getPrice());
        updatetedProduct.setDescription(product.getDescription());
        updatetedProduct.setStock(product.getStock());

        products.set(index, updatetedProduct);
    }

    public void delete(int id) {
        /*
            for (Product product : products) {
                if (product.getId() == id) {
                    products.remove(product);
                }
            }
        */
        products.removeIf(product -> product.getId() == id);
    }
}
