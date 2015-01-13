package org.zoro.dao;

import java.util.List;

import org.zoro.dto.ProductList;
import org.zoro.model.Product;

public interface InventoryDao {

    void addProduct(Product product);

    List<ProductList> searchProducts(String code);

    Product getProductDetails(String productName);

    Product getProduct(Integer productId);

}
