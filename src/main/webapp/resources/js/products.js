function UI_products() {};

$(document).ready(function() {
	
	$("#searchProducts").click(function() {
		UI_products.search();
	});
	
});

UI_products.search = function (){
	UI_products.searchSuccess();
}


UI_products.searchSuccess = function() {
	$("#productPanel").empty();
	
	
	$("#productPanel").append("<table id='productList'></table>");
	$("#productPanel").append("<div id='productPager'></div>");
	
	jQuery("#productList").jqGrid(
			{
				url : 'product/getAllProducts',
				datatype : "json",
				colNames : [ 'Product Id', 'Product Name', 'Status', 'No of Stocks', 'Unit Price', 'Description'],
				colModel : [ {
					name : 'productId',
					index : 'productId',
					width : 75
				}, {
					name : 'productName',
					index : 'productName',
					width : 90
				}, {
					name : 'status',
					index : 'status',
					width : 100
				}, {
					name : 'noOfStocks',
					index : 'noOfStocks',
					width : 80,
					align : "right"
				}, {
					name : 'unitPrice',
					index : 'unitPrice',
					width : 80,
					align : "right"
				}, {
					name : 'description',
					index : 'description',
					width : 150,
					align : "right"
				} ],
				rowNum : 10,
			//	rowList : [ 10, 20, 30 ],
				pager : '#productPager',
			//	sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				caption : "Avaliable products"
			});
	jQuery("#productList").jqGrid('navGrid', '#productPager', {
		edit : false,
		add : false,
		del : false
	});
}