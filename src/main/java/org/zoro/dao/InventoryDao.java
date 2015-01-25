package org.zoro.dao;

import java.util.List;

import org.zoro.dto.ProductList;
import org.zoro.exception.ModuleException;
import org.zoro.model.Product;

public interface InventoryDao {

    void addProduct(Product product) throws ModuleException;

    List<Product> getAllProducts();

    List<ProductList> searchProducts(String code);

    Product getProductDetails(String productName);

    Product getProduct(Integer productId);

}
