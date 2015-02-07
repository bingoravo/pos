package org.zoro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_sales")
public class UserSales implements Serializable {

    private static final long serialVersionUID = 4171840249545506986L;

    @Id
    @Column(name = "user_sales_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userSalesId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "timestamp")
    private Date timeStamp;

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public Integer getProductId() {
	return productId;
    }

    public void setProductId(Integer productId) {
	this.productId = productId;
    }

    public Integer getQuantity() {
	return quantity;
    }

    public void setQuantity(Integer quantity) {
	this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
	return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
    }

    public Date getTimeStamp() {
	return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
    }

}
