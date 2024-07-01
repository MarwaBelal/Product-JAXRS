package org.eclipse.jakarta.hello.service;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import org.eclipse.jakarta.hello.model.Product;
import org.eclipse.jakarta.hello.repository.ProductRepo;

import java.util.List;

@Singleton
public class ProductServiceImpl implements ProductService {

    private static int nextId = 0; // Static variable to track the next available ID

    @Inject
    ProductRepo productRepo;

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        product.setId(nextId++);
        productRepo.addProduct(product);
    }

    @Override
    public Product findProductbyName(String productName) {
        return productRepo.findProductbyName(productName);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        productRepo.updateProduct(updatedProduct);
    }

    @Override
    public void deleteProductById(int productId) {
        productRepo.deleteProductById(productId);
    }
}
