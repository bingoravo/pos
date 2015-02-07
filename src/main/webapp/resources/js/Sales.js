function UI_Sales() {
}

UI_Sales.cart = {};



$(document).ready(function() {
	
	UI_Sales.cart = {};

	if (!loadCheker.isFirstLoad(loadCheker.sales, "sales.js")) {
	//	return;
	}

	$('#w-input-search').autocomplete({
		serviceUrl : 'sales/searchProducts',
		paramName : "searchCode",
		delimiter : ",",
		transformResult : function(response) {
			return {
				suggestions : $.map($.parseJSON(response), function(item) {
					return {
						value : item.productName,
						data : item.productId
					};
				})
			};
		}
	});

	$("#w-button-search").click(function() {
		UI_Sales.search();
	});
	
	$("#addToCart").click(function (){
		UI_Sales.addToCart();
	})
	
	$("#btnPurchase").click(function (){
		UI_Sales.purchase();
	})
	

});

UI_Sales.search = function() {
	UI_Sales.clearData();
	if (UI_Sales.isValidSearch()) {
		var dataParams = "productName=" + $('#w-input-search').val();

		$.ajax({
			type : "GET",
			url : "sales/getProductDetails",
			data : dataParams,
			success : function(response) {
				UI_Sales.searchSucess(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
}

UI_Sales.clearData = function (){
	$("#productName").html("");
	$("#unitPrice").html("");
	$("#productId").val("");
	$("#qty").val("");
}

UI_Sales.searchSucess = function(response) {
	if (response != null && response.productId != "undefined") {
		$("#productName").html(response.productName);
		$("#unitPrice").html(response.unitPrice);
		$("#productId").val(response.productId);
	} else {
		alert("Product not found")
	}

}

UI_Sales.isValidSearch = function() {
	var valid = false;
	var selectedProduct = $('#w-input-search').val();
	if (selectedProduct != null && selectedProduct != "undefined"
			&& selectedProduct.trim().length > 0) {
		valid = true;
	}
	return valid;
}

UI_Sales.updateSubtotal = function() {
	var subPrice = $("#unitPrice").html();
	var subQty = $("#qty").val();
	if (subPrice != null && subPrice.length > 0 && subQty != null
			&& subQty.length > 0) {
		var calculatedSub = parseFloat(subPrice) * parseFloat(subQty);
		$("#subTotal").html(calculatedSub.toFixed(2));
	}

}

UI_Sales.addToCart = function (){
  var prodId = $("#productId").val();
  var quantity= $("#qty").val();
  
  UI_Sales.cart[prodId] = {};
  UI_Sales.cart[prodId] =  quantity;
  UI_Sales.updateBookingData();
}

UI_Sales.updateBookingData = function (){
	$.ajax({
		type : "POST",
		dataType: 'json', 
		url : "sales/getBookingCart",
		contentType: "application/json",
		data : JSON.stringify(UI_Sales.cart),
		success : function(response) {
			UI_Sales.updateBookingDataSuccess(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	
	
}

UI_Sales.updateBookingDataSuccess = function (response){
	if(response != null){
	    UI_Sales.rebuildBillPanel(response);
	}
}

UI_Sales.rebuildBillPanel = function (products){
	$("#billContent").empty();
	
	var html = "";
	
	var selProdcts = products.selectedProducts;
	
	if(selProdcts != null && selProdcts.length > 0 ){
		
		for ( var i = 0; i < selProdcts.length; i++) {
			var p = selProdcts[i];
				html = html + "<tr>" +
				   "<td><input type='text' id='desc_" + p.productId + "' name='desc_" + p.productId + "' value='" + p.productName + "'  disabled='disabled'/></td>"+
				   "<td><input type='text' id='uprice_" + p.productId + "' name='uprice_" + p.productId + "' value='" + p.unitPrice + "' disabled='disabled' /></td>" +
				   "<td><input type='text' id='qty_" + p.productId + "' name='qty_" + p.productId + "' value='" + p.reqestedQty + "' disabled='disabled' /></td>" +
				   "<td><input type='text' id='price_" + p.productId + "' name='price_" + p.productId + "' value='" + p.subTotal + "' disabled='disabled' /></td>" +
				   "<td><img onclick='UI_Sales.removeFromBookingCard(" +  p.productId  + ")' alt='Remove' src='resources/images/remove.jpg' width='17px' height='17px' style='display: block;'></td>" +
				  "</tr>";
		}
	}else{
		html = html + "<tr>" +
		   "<td><input type='text' disabled='disabled'/></td>"+
		   "<td><input type='text' disabled='disabled' /></td>" +
		   "<td><input type='text' disabled='disabled' /></td>" +
		   "<td><input type='text' disabled='disabled' /></td>" +
		   "<td><img   src='resources/images/remove.jpg' width='17px' height='17px' style='display: block;' disabled='disabled'></td>" +
		  "</tr>";
	}
	
	
	
	html = html + "<tr>" +
				   		"<td colspan='2'>TOTAL</td>" +
				   		"<td colspan='2'><label>" + products.total + "</label></td> +" +
				  "</tr>";
	
	$("#billContent").append(html);
	
}

UI_Sales.removeFromBookingCard = function (productId){
	delete UI_Sales.cart[productId];
	UI_Sales.updateBookingData();
}

UI_Sales.searchSuccess = function() {
	jQuery("#list2").jqGrid(
			{
				url : 'server.php?q=2',
				datatype : "json",
				colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
						'Total', 'Notes' ],
				colModel : [ {
					name : 'id',
					index : 'id',
					width : 55
				}, {
					name : 'invdate',
					index : 'invdate',
					width : 90
				}, {
					name : 'name',
					index : 'name asc, invdate',
					width : 100
				}, {
					name : 'amount',
					index : 'amount',
					width : 80,
					align : "right"
				}, {
					name : 'tax',
					index : 'tax',
					width : 80,
					align : "right"
				}, {
					name : 'total',
					index : 'total',
					width : 80,
					align : "right"
				}, {
					name : 'note',
					index : 'note',
					width : 150,
					sortable : false
				} ],
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : '#pager2',
			//	sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				caption : "JSON Example"
			});
	jQuery("#list2").jqGrid('navGrid', '#pager2', {
		edit : false,
		add : false,
		del : false
	});
}

UI_Sales.purchase = function (){
	
	if( UI_Sales.validPurchase()){
		if (confirm("Make a payment of Rs.100.00")){
			 $.ajax({
					type : "POST",
					url : "sales/purchase",
					contentType : 'application/json; charset=utf-8',
					async: false,
					data : JSON.stringify(UI_Sales.cart),
					success : function(response) {
						UI_Sales.purchaseSuccess(response);
					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});
		 }
	}
}

UI_Sales.validPurchase = function (){
	var valid = false;
	if (UI_Sales.cart != null && !$.isEmptyObject(UI_Sales.cart)){
		valid = true;
	}else{
		alert("Please select at least one product to purchase");
	}
	
	return valid;
}

UI_Sales.purchaseSuccess = function (response){
	if( response != null){
		alert(response);
	}
}