<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.osu.cse5234.model.Order" %>
<%@ page import="edu.osu.cse5234.business.view.Item" %>
<%@ page import="edu.osu.cse5234.model.PaymentInfo" %>
<%@ page import="edu.osu.cse5234.model.ShippingInfo" %>
    <jsp:include page="Header.jsp" />
<div class="jumbotron">
  <div class="container">
	<% Order order = (Order) session.getAttribute("order"); %>
	
	
	<%if(order == null){ %>
	 <h1><%="Nothing to confirm!" %></h1>
	 <% }else{%>
	 	
			<h1><%=  request.getSession().getAttribute("confirm") %></h1>
			
	<table border= "1">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			
		</tr>
			<% for(Item item: order.getItems()){ %>
				<tr>
					<td><%= item.getName() %></td>
					<td>$<%= item.getPrice() %></td>
					<td><%= item.getQuantity() %></td>	
	         	</tr>
	   		
			
			<%} }%>
		</table>
		<br/>
		<br/>
		<% PaymentInfo payment = (PaymentInfo) session.getAttribute("payment"); %>
		<% ShippingInfo shipping = (ShippingInfo) session.getAttribute("shipping"); %>
		<table>
			
				<tr>
					<td>Card Number: <%= payment.getCardNumber() %></td>
				</tr>
				<tr>
					<td>Expiration date: <%= payment.getEpirationDate() %></td>
				</tr>
				<tr>
					<td>Cvv: <%= payment.getCvv() %></td>
				</tr>
				<tr>
					<td>Name on the card: <%= payment.getHolderName() %></td>
				</tr>
					
	         	
	   		
			<tr>
				<td colspan="2"><input type="submit" value="Edit"></td>
			</tr>
		</table>
		<br/>
		<br/>
		<table>

				<tr>
					<td>Name: <%= shipping.getName() %></td>
				</tr>
				<tr>
					<td>Address Line 1: <%= shipping.getAddressLine1() %></td>
				</tr>
				<tr>
					<% if (shipping.getAddressLine2() != null){ %>
					<td>Address Line 2: <form:input path="addressLine2" /></td>
					<%} %>
				</tr>
				<tr>
					<td>City: <%= shipping.getCity() %></td>
				</tr>
				<tr>
					<td>State: <%= shipping.getState() %></td>
				</tr>
				<tr>
					<td>Zip Code: <%= shipping.getZip() %></td>
				</tr>
					
	         	
	   		
			<tr>
				<td colspan="2"><input type="submit" value="Edit"></td>
			</tr>
		</table>
		<br/>
		<br/>
		<form action= "confirmOrder" method="post">
			<input type="submit" value="Confirm">
		</form>
	
</div>
</div>
    <jsp:include page="Footer.jsp" />
