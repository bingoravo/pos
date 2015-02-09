package org.zoro.dao;

import java.util.List;

import org.zoro.dto.UserSalesTO;
import org.zoro.model.UserSales;

public interface ReportingDao {

    List<UserSales> getUserSales(UserSalesTO inputSalesTO);
}
