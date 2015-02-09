package org.zoro.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.zoro.dao.ReportingDao;
import org.zoro.dto.UserSalesTO;
import org.zoro.model.UserSales;

@Repository
public class ReportingDaoImpl implements ReportingDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserSales> getUserSales(UserSalesTO inputSalesTO) {
	return null;
    }

}
