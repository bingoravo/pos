
function UI_performSales(){}

$(document).ready(function() {
	
	if (!loadCheker.isFirstLoad(loadCheker.performSales, "performSales.js")) {
        return;
    }
	console.log("inside perform sales");
	
	$("#btnSearch").click(function(){
		alert("searched");
		console.log("searched");
		UI_performSales.search();
	});
});


UI_performSales.search = function (){
	$.ajax({
		 type : "GET",   
	     url : "productDetails",   
	     data : "name=rimaz",  
	     success : function(response) {  
	      alert(response);   
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	 });
}

UI_performSales.searchSuccess = function (){
	jQuery("#list2").jqGrid({
	   	url:'server.php?q=2',
		datatype: "json",
	   	colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
	   	colModel:[
	   		{name:'id',index:'id', width:55},
	   		{name:'invdate',index:'invdate', width:90},
	   		{name:'name',index:'name asc, invdate', width:100},
	   		{name:'amount',index:'amount', width:80, align:"right"},
	   		{name:'tax',index:'tax', width:80, align:"right"},		
	   		{name:'total',index:'total', width:80,align:"right"},		
	   		{name:'note',index:'note', width:150, sortable:false}		
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager2',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    caption:"JSON Example"
	});
	jQuery("#list2").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});
}