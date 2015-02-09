package org.zoro.service;

import java.util.List;

import org.zoro.dto.UserSalesTO;
import org.zoro.model.UserSales;

public interface ReportingService {

    List<UserSales> getUserSales(UserSalesTO inputSalesTO);

}
