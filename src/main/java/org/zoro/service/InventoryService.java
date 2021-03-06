package org.zoro.service;

import java.util.List;
import java.util.Map;

import org.zoro.dto.BookingCart;
import org.zoro.dto.ProductList;
import org.zoro.exception.ModuleException;
import org.zoro.model.Product;

public interface InventoryService {

    void addProduct(Product product) throws ModuleException;

    List<Product> getAllProducts();

    List<ProductList> searchProducts(String code);

    Product getProductDetails(String productName);

    BookingCart populateBookigCart(Map<String, String> requests);

    boolean purchase(Map<String, String> cartDetails, String userId)
	    throws ModuleException;

}
