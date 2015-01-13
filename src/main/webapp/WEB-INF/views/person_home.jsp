<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css">
		<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
	</head>
	<!-- http://www.tutorialspoint.com/jqueryui/jqueryui_tabs.htm -->
	<script>
		$(function() {
			$("#tabs").tabs();
			$("#subtabs").tabs();
		});
		
		
	</script>
</head>
<body>

	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Sales</a></li>
			<li><a href="#tabs-2">Administration</a></li>
			<li><a href="#tabs-3">Reports</a></li>
		</ul>
		<div id="tabs-1">
			<table>
				<tr>
					<td id="billingPanel" style="size: 70%;">
						<%@include file="widgets/billingPanel.jsp"%>
					</td>
					<td id="FeedingPanel" style="size: 30%";>
						<%@include file="widgets/searchPanel.jsp"%>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="tabs-2">
			<div id="subtabs">
				<ul>
					<li><a href="#subtabs-1">User</a></li>
					<li><a href="#subtabs-2">Products</a></li>
				</ul>
				
				<div id="subtabs-1">
					<p>User Management related functionalities ..TODO</p>
				</div>
				<div id="subtabs-2">
					<p>Add/Edit Products</p>
	
				</div>
				
			</div>
		</div>
      
		<div id="tabs-3">
			<p>Reporting module goes here</p>
		</div>
	</div>



	<a href="person/list">Go to the person list</a>
</body>
</html>
