package org.zoro.service;

import org.zoro.model.Product;

public interface InventoryService {

	void addProduct(Product product);

	void searchProducts();

}
