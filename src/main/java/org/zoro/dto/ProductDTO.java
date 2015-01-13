package org.zoro.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 703175152631568006L;

    private Integer productId;
    private String productName;
    private BigDecimal unitPrice;
    private BigDecimal reqestedQty;
    private BigDecimal subTotal;

    public Integer getProductId() {
	return productId;
    }

    public void setProductId(Integer productId) {
	this.productId = productId;
    }

    public String getProductName() {
	return productName;
    }

    public void setProductName(String productName) {
	this.productName = productName;
    }

    public BigDecimal getUnitPrice() {
	return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
    }

    public BigDecimal getReqestedQty() {
	return reqestedQty;
    }

    public void setReqestedQty(BigDecimal reqestedQty) {
	this.reqestedQty = reqestedQty;
    }

    public BigDecimal getSubTotal() {
	return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
	this.subTotal = subTotal;
    }

}
