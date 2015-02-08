<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<table>
		<tr>
			<%-- 			<td id="billingPanel" style="size: 70%;"><%@include --%>
			<%-- 					file="widgets/billingPanel.jsp"%></td> --%>
			<%-- 			<td id="FeedingPanel" style="size: 30%";><%@include --%>
			<%-- 					file="widgets/searchPanel.jsp"%></td> --%>

			<!-- billingPanel.jsp -->
			<td>
				<table>
					<tr>
						<td>
							<h2>BILLING DETAILS</h2>
						</td>
					</tr>
					<tr>
						<td>
							<table>
								<thead>
									<tr>
										<td>Description</td>
										<td>Qty</td>
										<td>Unit Price</td>
										<td>Price</td>
									</tr>
								</thead>
								
								<tbody id="billContent">
									<tr >
										<td><input type="text" id="desc_1" name="desc_1" value="Desc" disabled='disabled' /></td>
										<td><input type="text" id="uprice_1" value="Desc" name="uprice_1" disabled='disabled' /></td>
										<td><input type="text" id="qty_1" name="qty_1" value="Desc" disabled='disabled' /></td>
										<td><input type="text" id="price_1" name="price_1" value="Desc" disabled='disabled' /></td>
									</tr>
									<tr>
										<td colspan="2">TOTAL</td>
										<td colspan="2"></td>
									</tr>
							 	</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<h2>PURCHASE OPTIONS</h2>
						</td>
					</tr>
					<tr>
						<td align="left"><input type="button" id="btnPurchase" value="Purchase" /></td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>
							<h2>SEARCH PANEL</h2>
						</td>
					</tr>
					<tr>
						<td>Search</td>
						<td>
							<div>
								<input type="text" id="w-input-search" value=""> <span>
									<button id="w-button-search" type="button">Search</button>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<td><br /></td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td>Product Name</td>
									<td><label id="productName"></label></td>
								</tr>
								<tr>
									<td>Unit Price</td>
									<td><label id="unitPrice"></label></td>
								</tr>
								<tr>
									<td>Required Quantity</td>
									<td><input type="text" id="qty" name="qty" value="" onblur="UI_Sales.updateSubtotal()"/></td>
								</tr>
								<tr>
									<td>Sub Total</td>
									<td><label id="subTotal"></label></td>
								</tr>
								<tr>
									<td><input type="button" id="addToCart" name="addToCart"
										value="Add To Cart">
									<td>
								</tr>
								<tr>
									<td><input type="text" id="productId" name="productId" value="" style="display: none;"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>


			</td>

		</tr>
	</table>

</body>
</html>













