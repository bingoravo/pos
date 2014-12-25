package org.zoro.service.impl;

import org.zoro.dao.InventoryDao;
import org.zoro.dao.impl.InventoryDaoImpl;
import org.zoro.model.Product;
import org.zoro.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

	InventoryDao inventoryDao = new InventoryDaoImpl();

	public void addProduct(Product product) {
		inventoryDao.addProduct(product);

	}

	public void searchProducts() {
		inventoryDao.searchProducts();

	}

}
