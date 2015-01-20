<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<style>
.autocomplete-suggestions {
	border: 1px solid #999;
	background: #FFF;
	overflow: auto;
}

.autocomplete-suggestion {
	padding: 5px 5px;
	white-space: nowrap;
	overflow: hidden;
	font-size: 10px
}

.autocomplete-selected {
	background: #F0F0F0;
}

.autocomplete-suggestions strong {
	font-weight: bold;
	color: #3399FF;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>Product Name</td>
			<td><input type="text" id="w-input-search" value=""></td>
			<td>status</td>
			<td><select>
					<option value="ALL">ALL</option>
					<option value="ACT">ACT</option>
					<option value="INA">INA</option>
			</select></td>
			<td><input type="button" id="searchProducts" value="Search"></td>
		</tr>
		<tr>
			<td colspan="5">
				<table>

					<tr>
						<td>
							<div id="productPanel">
								<table id="productList"></table>
								<div id="productPager"></div>
							</div>

						</td>
					</tr>
				</table>

			</td>
		</tr>

	</table>

</body>
</html>













