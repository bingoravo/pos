package org.zoro.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.zoro.dao.InventoryDao;
import org.zoro.dto.BookingCart;
import org.zoro.dto.ProductDTO;
import org.zoro.dto.ProductList;
import org.zoro.dto.constants.Constants;
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

    public boolean purchase(Map<String, String> cartDetails, String userId)
	    throws ModuleException {

	if (cartDetails != null) {
	    Set<String> productIds = cartDetails.keySet();
	    if (productIds != null && !productIds.isEmpty()) {
		for (String pId : productIds) {
		    Integer productId = Integer.parseInt(pId);
		    Product buyingProduct = inventoryDao.getProduct(productId);
		    Integer buyingQty = Integer.parseInt(cartDetails.get(pId)); // TODO
										// support
										// bigdecimal
		    Integer updatedAval = validateBuy(buyingProduct,
			    cartDetails.get(pId));
		    inventoryDao.updateProductInventory(productId, updatedAval);
		    inventoryDao.performUserSales(userId, productId,
			    buyingProduct.getUnitPrice(), buyingQty);
		}
	    }
	}
	return true;
    }

    private Integer validateBuy(Product buyingProduct, String quantity)
	    throws ModuleException {

	Integer updatedAval = 0;

	if (buyingProduct == null || buyingProduct.getStatus() == null
		|| buyingProduct.getStatus().equals(Constants.INACTIVE)) {

	    if (buyingProduct != null && buyingProduct.getProductName() != null) {
		throw new ModuleException(
			buyingProduct.getProductName()
				+ " Product is Not available, please remove the product");
	    } else {
		throw new ModuleException(
			"Selected product(s) is not avaliable, please do a price quote");
	    }

	} else {
	    Integer currentAval = buyingProduct.getNoOfStocks();
	    Integer requestedCount = Integer.parseInt(quantity);

	    updatedAval = currentAval - requestedCount;

	    if (updatedAval < 0) {
		throw new ModuleException(
			"Product Inventory is not sufficient for "
				+ buyingProduct.getProductName()
				+ ". Current avaliblity is "
				+ buyingProduct.getNoOfStocks());
	    }

	}

	return updatedAval;

    }
}
