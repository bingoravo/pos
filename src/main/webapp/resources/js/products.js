function UI_products() {};


UI_products.ready = function() {
	$("#searchProducts").click(function() {
		UI_products.search();
	});

	$("#btnAddProduct").click(function() {
		UI_products.add();
	});

	$("#btnEditProduct").click(function() {
		UI_products.edit();
	});

	$("#btnSave").click(function() {
		UI_products.save();
	});
	UI_products.search();
	
}

UI_products.search = function() {
	UI_products.searchSuccess();
}

UI_products.searchSuccess = function() {
	$("#productPanel").empty();
	UI_products.clearValues();

	$("#btnAddProduct").prop('disabled', false);
	$("#btnEditProduct").prop('disabled', true);
	$("#btnSave").prop('disabled', true);

	$("#productPanel").append("<table id='productList'></table>");
	$("#productPanel").append("<div id='productPager'></div>");

	jQuery("#productList").jqGrid(
			{
				url : 'product/getAllProducts',
				datatype : "json",
				colNames : [ 'Product Id', 'Product Name', 'Description','No of Stocks', 'Unit Price', 'Status' ],
				colModel : [ {
					name : 'productId',
					index : 'productId',
					hidden : true,
					width : 75
				}, {
					name : 'productName',
					index : 'productName',
					width : 100
				}, {
					name : 'description',
					index : 'description',
					width : 150,
					align : "right"
				}, {
					name : 'noOfStocks',
					index : 'noOfStocks',
					width : 90,
					align : "right"
				}, {
					name : 'unitPrice',
					index : 'unitPrice',
					width : 90,
					align : "right"
				}, {
					name : 'status',
					index : 'status',
					width : 80
				}],
				rowNum : 10,
				// rowList : [ 10, 20, 30 ],
				pager : '#productPager',
				// sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				caption : "Avaliable products",
				onSelectRow : function(rowId) {
					UI_products.rowClick(rowId);
				}
			});
	jQuery("#productList").jqGrid('navGrid', '#productPager', {
		edit : false,
		add : false,
		del : false
	});
}

UI_products.rowClick = function(rowId) {

	$("#btnAddProduct").prop('disabled', false);
	$("#btnEditProduct").prop('disabled', false);
	$("#btnSave").prop('disabled', true);

	UI_products.clearValues();

	if (rowId) {
		var productId = $("#productList").jqGrid('getCell', rowId, 'productId');
		var productName = $("#productList").jqGrid('getCell', rowId,
				'productName');
		var status = $("#productList").jqGrid('getCell', rowId, 'status');
		var noOfStocks = $("#productList").jqGrid('getCell', rowId,
				'noOfStocks');
		var unitPrice = $("#productList").jqGrid('getCell', rowId, 'unitPrice');
		var description = $("#productList").jqGrid('getCell', rowId,
				'description');

		$("#txtProductId").val(productId);
		$("#txtProductName").val(productName);
		$("#txtProductStatus").val(status);
		$("#txtNoOfStocks").val(noOfStocks);
		$("#txtUnitPrice").val(unitPrice);
		$("#txtDescription").val(description);

	} else {
		alert("please select a row");
	}

	$("#frmProducts :input").prop("disabled", true);
}

UI_products.clearValues = function() {
	$("#txtProductId").val("");
	$("#txtProductName").val("");
	$("#txtProductStatus").val("");
	$("#txtNoOfStocks").val("");
	$("#txtUnitPrice").val("");
	$("#txtDescription").val("");
}

UI_products.add = function() {
	UI_products.clearValues();
	$("#frmProducts :input").prop("disabled", false);
	$("#btnAddProduct").prop('disabled', false);
	$("#btnEditProduct").prop('disabled', true);
	$("#btnSave").prop('disabled', false);
}

UI_products.edit = function() {
	$("#frmProducts :input").prop("disabled", false);
	$("#btnAddProduct").prop('disabled', false);
	$("#btnEditProduct").prop('disabled', false);
	$("#btnSave").prop('disabled', false);
}

UI_products.save = function() {
	if (UI_products.validateSave()) {

		var product = {
			productId : $("#txtProductId").val(),
			productName : $("#txtProductName").val(),
			status : $("#txtProductStatus").val(),
			unitPrice : $("#txtUnitPrice").val(),
			noOfStocks : $("#txtNoOfStocks").val(),
			description : $("#txtDescription").val()
		}

		$.ajax({
			url : "product/saveProduct",
			contentType : 'application/json; charset=utf-8',
			async: false,
			data : JSON.stringify(product),
			type : "POST",
			success : function(response) {
				alert(response);
				UI_products.search();
			},
			error : function() {
				alert("Please try again");
			}
		});
	}
}

UI_products.validateSave = function() {
	if ($("#txtProductName").val().trim() == "") {
		alert("Product Name cannot be empty");
		return false;
	}

	if ($("#txtNoOfStocks").val().trim() == "") {
		alert("Number of Stocks cannot be empty");
		return false;
	}

	if ($("#txtUnitPrice").val().trim() == "") {
		alert("Unit Price cannot be empty");
		return false;
	}
	return true;
}


$(document).ready(function() {
	UI_products.ready();
});