package org.zoro.dto;

import java.io.Serializable;

public class ProductList implements Serializable {

    private static final long serialVersionUID = -506541698166519203L;

    private int productId;
    private String productName;

    public ProductList(int productId, String productName) {
	super();
	this.productId = productId;
	this.productName = productName;
    }

    public int getProductId() {
	return productId;
    }

    public void setProductId(int productId) {
	this.productId = productId;
    }

    public String getProductName() {
	return productName;
    }

    public void setProductName(String productName) {
	this.productName = productName;
    }

}
