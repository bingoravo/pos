package org.zoro.dto;

import java.io.Serializable;
import java.util.List;

public class UserSalesTO implements Serializable {

    private static final long serialVersionUID = 2227719821668353350L;

    private String startDate;
    private String endDate;
    private List<String> userIds;

    public String getStartDate() {
	return startDate;
    }

    public void setStartDate(String startDate) {
	this.startDate = startDate;
    }

    public String getEndDate() {
	return endDate;
    }

    public void setEndDate(String endDate) {
	this.endDate = endDate;
    }

    public List<String> getUserIds() {
	return userIds;
    }

    public void setUserIds(List<String> userIds) {
	this.userIds = userIds;
    }

}
