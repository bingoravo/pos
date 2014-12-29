package org.zoro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 3674613598495109246L;

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "status")
	private String status;

	@Column(name = "no_of_stocks")
	private Integer noOfStocks;

	@Column(name = "unit_price")
	private Double unitPrice;

	@Column(name = "description")
	private String description;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNoOfStocks() {
		return noOfStocks;
	}

	public void setNoOfStocks(Integer noOfStocks) {
		this.noOfStocks = noOfStocks;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
