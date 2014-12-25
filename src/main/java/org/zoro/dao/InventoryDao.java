package org.zoro.dao;

import org.zoro.model.Product;

public interface InventoryDao {

	void addProduct(Product product);

	void searchProducts();

}
