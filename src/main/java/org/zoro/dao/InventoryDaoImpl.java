package org.zoro.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zoro.dto.ProductList;
import org.zoro.exception.ModuleException;
import org.zoro.model.Product;
import org.zoro.model.UserSales;

@Repository
public class InventoryDaoImpl implements InventoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory
	    .getLogger(InventoryDaoImpl.class);

    @Transactional(propagation = Propagation.REQUIRED)
    public void addProduct(Product product) throws ModuleException {

	validate(product.getProductId(), product.getProductName());

	Integer productId = product.getProductId();
	if (productId != null && productId > 0) {
	    entityManager.merge(product);
	    log.info("updated Inverntory");
	} else {
	    entityManager.persist(product);
	    log.info("added new Inverntory");
	}
    }

    /**
     * product name to be unique
     */
    @SuppressWarnings("unchecked")
    private void validate(Integer productId, String productName)
	    throws ModuleException {

	String sql = "select * from t_product where product_name='"
		+ productName + "'";

	Query query = entityManager.createNativeQuery(sql, Product.class);
	List<Product> resultDups = query.getResultList();
	if (resultDups != null && !resultDups.isEmpty()) {
	    Product persisted = resultDups.get(0);

	    if (productId != null && productId > 0) {
		if (!persisted.getProductId().equals(productId)) {
		    throw new ModuleException(
			    "Product Name is already taken, please select a different one");
		}
	    } else {
		if (persisted.getProductName().equalsIgnoreCase(productName)) {
		    throw new ModuleException(
			    "Product Name is already taken, please select a different one");
		}
	    }
	}
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
	List<Product> allProducts = new ArrayList<Product>();
	Query query = entityManager.createNativeQuery(
		"select * from t_product", Product.class);
	allProducts = query.getResultList();

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

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateProductInventory(Integer productId, Integer noOfStocks) {

	Query query = entityManager
		.createQuery("update Product set noOfStocks =:noOfStocks where productId =:productId ");
	query.setParameter("noOfStocks", noOfStocks);
	query.setParameter("productId", productId);
	query.executeUpdate();

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void performUserSales(String userId, Integer productId,
	    BigDecimal unitPrice, Integer quantity) {

	UserSales userSales = new UserSales();
	userSales.setUserId(userId);
	userSales.setProductId(productId);
	userSales.setUnitPrice(unitPrice);
	userSales.setQuantity(quantity);
	userSales.setTimeStamp(new Date());
	entityManager.persist(userSales);

    }
}
