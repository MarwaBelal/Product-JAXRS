package org.eclipse.jakarta.hello.repository;

import org.eclipse.jakarta.hello.model.Product;

import java.util.List;

public interface ProductRepo {

    List<Product> findAllProducts();

    Product findProductbyName(String productName);

    void addProduct(Product product);

    void updateProduct(Product updatedProduct);

    void deleteProductById(int productId);


}
