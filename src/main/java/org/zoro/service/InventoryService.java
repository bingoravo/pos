package org.zoro.service;

import java.util.List;

import org.zoro.dto.productList;
import org.zoro.model.Product;

public interface InventoryService {

	void addProduct(Product product);

	public List<productList> searchProducts(String code);

}
