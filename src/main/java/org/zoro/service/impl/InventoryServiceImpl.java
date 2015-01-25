package org.zoro.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.zoro.dao.InventoryDao;
import org.zoro.dto.BookingCart;
import org.zoro.dto.ProductDTO;
import org.zoro.dto.ProductList;
import org.zoro.exception.ModuleException;
import org.zoro.model.Product;
import org.zoro.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

    private InventoryDao inventoryDao;

    public void addProduct(Product product) throws ModuleException {
	inventoryDao.addProduct(product);
    }

    public List<Product> getAllProducts() {
	return inventoryDao.getAllProducts();
    }

    public List<ProductList> searchProducts(String code) {
	return inventoryDao.searchProducts(code);
    }

    public Product getProductDetails(String productName) {
	return inventoryDao.getProductDetails(productName);
    }

    public BookingCart populateBookigCart(Map<String, String> cartDetails) {

	BookingCart cart = new BookingCart();
	BigDecimal total = BigDecimal.ZERO;

	if (cartDetails != null) {
	    Set<String> productIds = cartDetails.keySet();
	    if (productIds != null) {
		for (String productId : productIds) {
		    Product persitedProduct = inventoryDao.getProduct(Integer
			    .parseInt(productId));

		    if (persitedProduct != null) {

			Double tReqestedQty = Double.valueOf(cartDetails
				.get(productId));
			BigDecimal reqestedQty = BigDecimal
				.valueOf(tReqestedQty);

			BigDecimal subTotal = reqestedQty
				.multiply(persitedProduct.getUnitPrice());

			ProductDTO productDto = new ProductDTO();
			productDto.setProductId(persitedProduct.getProductId());
			productDto.setProductName(persitedProduct
				.getProductName());
			productDto.setUnitPrice(persitedProduct.getUnitPrice());
			productDto.setReqestedQty(reqestedQty);

			productDto.setSubTotal(subTotal);
			cart.addProductDTO(productDto);

			total = total.add(subTotal);
		    }
		}
		cart.setTotal(total);
	    }

	}
	return cart;
    }

    private ProductDTO transformToDTO(Product persitedProduct) {

	return null;
    }

    public void setInventoryDao(InventoryDao inventoryDao) {
	this.inventoryDao = inventoryDao;
    }

}
