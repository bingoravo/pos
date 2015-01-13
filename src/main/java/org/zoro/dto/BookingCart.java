package org.zoro.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookingCart implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5718603521278304995L;
    private List<ProductDTO> selectedProducts;
    private BigDecimal total;

    public BookingCart() {
	selectedProducts = new ArrayList<ProductDTO>();
	total = BigDecimal.ZERO;
    }

    public List<ProductDTO> getSelectedProducts() {
	return selectedProducts;
    }

    public void setSelectedProducts(List<ProductDTO> selectedProducts) {
	this.selectedProducts = selectedProducts;
    }

    public BigDecimal getTotal() {
	return total;
    }

    public void setTotal(BigDecimal total) {
	this.total = total;
    }

    public void addProductDTO(ProductDTO product) {
	getSelectedProducts().add(product);
    }

}
