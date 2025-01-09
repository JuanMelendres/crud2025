package com.coursejjjm.simplecrud.repository;

import com.coursejjjm.simplecrud.model.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() { return products; }

    public Product findById(int id) {

        /*
            for (Product product : products) {
                if (product != null && product.getId() == id) {
                    return product;
                }
            }
         */

        return products.stream()
                .filter(
                        product -> product.getId() == id
                ).findFirst().orElseThrow();
    }

    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public Product update(Product newProduct) {

        if (newProduct != null) {
            int index = products.stream().filter(
                    product -> product.equals(newProduct)
                ).findFirst().hashCode();

            Product updatetedProduct = new Product();
            updatetedProduct.setId(newProduct.getId());
            updatetedProduct.setName(newProduct.getName());
            updatetedProduct.setPrice(newProduct.getPrice());
            updatetedProduct.setDescription(newProduct.getDescription());
            updatetedProduct.setStock(newProduct.getStock());

            products.set(index, updatetedProduct);
            return updatetedProduct;
        }
        else {
            return null;
        }

    }

    public void deleteById(int id) {
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
