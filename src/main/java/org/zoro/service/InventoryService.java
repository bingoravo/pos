package org.zoro.service;

import java.util.List;
import java.util.Map;

import org.zoro.dto.BookingCart;
import org.zoro.dto.ProductList;
import org.zoro.model.Product;

public interface InventoryService {

    void addProduct(Product product);

    List<ProductList> searchProducts(String code);

    Product getProductDetails(String productName);

    BookingCart populateBookigCart(Map<String, String> requests);

}
