package org.zoro.dao;

import java.util.List;

import org.zoro.dto.productList;
import org.zoro.model.Product;

public interface InventoryDao {

	void addProduct(Product product);

	List<productList> searchProducts(String code);

}
