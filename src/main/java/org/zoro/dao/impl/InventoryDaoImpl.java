package org.zoro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import org.zoro.dao.InventoryDao;
import org.zoro.dto.productList;
import org.zoro.model.Product;

@Repository
public class InventoryDaoImpl implements InventoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger log = LoggerFactory
			.getLogger(InventoryDaoImpl.class);

	public void addProduct(Product product) {
		log.info("Add Inverntory");

	}

	public List<productList> searchProducts(String code) {
		List<productList> productList = new ArrayList<productList>();

		StringBuilder sb = new StringBuilder();
		sb.append("select product_id, product_name from t_product where status= 'ACT'");
		if (code != null && code.trim().length() > 0) {
			sb.append(" and lower(product_name) like '%");
			sb.append(code.trim());
			sb.append("%'");
		}
		String sql = sb.toString();
		log.info(sql);
		productList = entityManager.createNativeQuery(sql).getResultList();
		return productList;
	}

}
