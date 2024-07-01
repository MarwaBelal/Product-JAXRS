package org.eclipse.jakarta.hello.repository;

import jakarta.ejb.Singleton;
import org.eclipse.jakarta.hello.model.Product;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductMemoryRepo implements ProductRepo {

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

    @Override
    public Product findProductbyName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new RuntimeException("Product: " + productName + " not Found");
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        boolean isUpdated = false;
        for (Product product : products) {
            if (updatedProduct.getId() == product.getId()) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setQuantity(updatedProduct.getQuantity());
                isUpdated = true;
            }
        }
       if(!isUpdated) {
           throw new RuntimeException("Product: " + updatedProduct.getName() + " not Found");
       }
    }

    @Override
    public void deleteProductById(int productId) {
        if (!products.removeIf(product -> product.getId() == productId)) {
            throw new RuntimeException("Product ID: " + productId + " not Found");
        }
    }
}
