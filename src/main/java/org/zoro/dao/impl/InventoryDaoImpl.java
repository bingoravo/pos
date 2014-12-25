package org.zoro.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zoro.dao.InventoryDao;
import org.zoro.model.Product;

public class InventoryDaoImpl implements InventoryDao {

	private static final Logger log = LoggerFactory
			.getLogger(InventoryDaoImpl.class);

	public void addProduct(Product product) {
		log.info("Add Inverntory");

	}

	public void searchProducts() {
		log.info("Search products");

	}

}
