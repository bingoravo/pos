package org.zoro.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zoro.dto.ProductList;
import org.zoro.model.Person;

@Repository
public class PersonDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Person find(Long id) {
		return entityManager.find(Person.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPeople() {

		String code = null;
		List<ProductList> productList = new ArrayList<ProductList>();

		StringBuilder sb = new StringBuilder();
		sb.append("select product_id, product_name from t_product where status= 'ACT'");
		if (code != null && code.trim().length() > 0) {
			sb.append(" and lower(product_name) like '%");
			sb.append(code.trim());
			sb.append("%'");
		}
		String sql = sb.toString();
		System.out.println(sql);
		productList = entityManager.createNativeQuery(sql).getResultList();

		return entityManager.createQuery("select p from Person p")
				.getResultList();
	}

	@Transactional
	public Person save(Person person) {
		if (person.getId() == null) {
			entityManager.persist(person);
			return person;
		} else {
			return entityManager.merge(person);
		}
	}

}
