package org.zoro.dao;

import java.math.BigDecimal;
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

    void updateProductInventory(Integer productId, Integer noOfStocks);

    void performUserSales(String userId, Integer productId,
	    BigDecimal unitPrice, Integer buyingQty);

}
