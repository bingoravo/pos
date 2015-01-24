package org.zoro.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.zoro.dto.ProductList;
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

    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
	List<Product> allProducts = new ArrayList<Product>();

	StringBuilder sb = new StringBuilder();
	// sb.append(" select productId, productName, status, noOfStocks, unitPrice, description from t_product");
	Query query = entityManager.createNativeQuery(
		"select * from t_product", Product.class);
	allProducts = query.getResultList();

//	List<Object[]> productObjects = entityManager.createNativeQuery(
//		sb.toString()).getResultList();
//
//	if (productObjects != null) {
//	    for (Object[] pObject : productObjects) {
//		Product product = new Product();
//		product.setProductId((Integer) pObject[0]);
//		product.setProductName((String) pObject[1]);
//		product.setStatus((String) pObject[2]);
//		product.setNoOfStocks((Integer) pObject[3]);
//		product.setUnitPrice((BigDecimal) pObject[4]);
//		product.setDescription((String) pObject[5]);
//	    }
//	}

	return allProducts;
    }

    @SuppressWarnings("unchecked")
    public List<ProductList> searchProducts(String code) {
	List<ProductList> productList = new ArrayList<ProductList>();

	StringBuilder sb = new StringBuilder();
	sb.append("select product_id, product_name from t_product where status= 'ACT'");
	if (code != null && code.trim().length() > 0) {
	    sb.append(" and lower(product_name) like '%");
	    sb.append(code.trim());
	    sb.append("%'");
	}
	String sql = sb.toString();
	log.info(sql);

	List<Object[]> productObjects = entityManager.createNativeQuery(sql)
		.getResultList();

	if (productObjects != null) {
	    for (Object[] productObj : productObjects) {
		productList.add(new ProductList((Integer) productObj[0],
			(String) productObj[1]));
	    }
	}

	return productList;

    }

    public Product getProductDetails(String productName) {
	Product product = null;

	if (productName != null && !productName.isEmpty()) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("select * from t_product where lower(product_name) like '%");
	    sb.append(productName.toLowerCase());
	    sb.append("%'");

	    @SuppressWarnings("unchecked")
	    List<Product> products = (ArrayList<Product>) entityManager
		    .createNativeQuery(sb.toString(), Product.class)
		    .getResultList();
	    if (products != null && !products.isEmpty()) {
		product = products.get(0);
	    }
	}

	return product;
    }

    public Product getProduct(Integer productId) {
	return entityManager.find(Product.class, productId);
    }

}
