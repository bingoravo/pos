<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<script src="resources/js/products.js" type="text/javascript"></script>
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
		<tr>
			<td><input type="button" id="btnAddProduct" name="btnAddProduct"
				value="Add"></td>
			<td><input type="button" id="btnEditProduct"
				name="btnEditProduct" value="Edit"></td>
		</tr>
		<tr>
			<td colspan="5">
				<form action="" id="frmProducts">
					<table>
						<tr>
							<td>Product Name:</td>
							<td><input type="text"  id ="txtProductName" name="txtProductName"></input></td>
						</tr>
						<tr>
							<td>Status</td>
							<td><input type="text" id ="txtProductStatus" name="txtProductStatus"></input></td>
						</tr>
						<tr>
							<td>No of Stocks:</td>
							<td><input type="text" id ="txtNoOfStocks"  name="txtNoOfStocks"></input></td>
						</tr>
						<tr>
							<td>Unit Price</td>
							<td><input type="text" id ="txtUnitPrice"  name="txtUnitPrice"></input></td>
						</tr>
						<tr>
							<td>Description</td>
							<td><input type="text" id ="txtDescription"  name="txtDescription"></input></td>
						</tr>
					</table>
					<input type="text"  id ="txtProductId" name="txtProductId" style="display: none;"></input>
				</form>
			</td>
		</tr>
		<tr>
			<td align="right"><input type="button" name="btnSave" id="btnSave"
				value="Save"></input></td>
		</tr>
	</table>

</body>
</html>













