function UI_UserSales() {};

UI_UserSales.ready = function() {
	
	$("#rptGenerate").click(function() {
		UI_UserSales.generateReport();
	});
}

UI_UserSales.generateReport = function() {
	if (UI_UserSales.isValidCriteria) {
		
		var userIds = [];
		userIds[0] = 'SYSTEM';
		
		var userSalesTo = {
							startDate:$("#startDate").val(), 
							endDate:$("#endDate").val(), 
							userIds:{}
							};
		
	//	data : JSON.stringify(userSalesTo),

		$.ajax({
			type : "POST",
			url : "report/userSales",
			contentType : 'application/json; charset=utf-8',
			async: false,
			data : userSalesTo,
			success : function(response) {
				UI_UserSales.generateReportSucess(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
}

UI_UserSales.isValidCriteria = function() {
	var valid = true;
	if (!valid) {
		alert("Please correct the search criteria");
	}

	return valid;
}
UI_UserSales.generateReportSucess = function (){
	alert("Response Received");
}


$(document).ready(function() {
	UI_UserSales.ready();
});