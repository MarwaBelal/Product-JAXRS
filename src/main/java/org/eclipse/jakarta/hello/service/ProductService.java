package org.eclipse.jakarta.hello.service;

import org.eclipse.jakarta.hello.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    void addProduct(Product product);

    Product findProductbyName(String productName);

    void updateProduct(Product updatedProduct);

    void deleteProductById(int productId);


}
