package org.zoro.service.impl;

import java.util.List;

import org.zoro.dao.InventoryDao;
import org.zoro.dao.impl.InventoryDaoImpl;
import org.zoro.dto.productList;
import org.zoro.model.Product;
import org.zoro.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

	// TODO: inject through spring DI
	private InventoryDao inventoryDao = new InventoryDaoImpl();

	public void addProduct(Product product) {
		inventoryDao.addProduct(product);

	}

	public List<productList> searchProducts(String code) {
		return inventoryDao.searchProducts(code);
	}

}
