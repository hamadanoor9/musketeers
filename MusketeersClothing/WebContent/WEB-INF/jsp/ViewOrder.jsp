<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="edu.osu.cse5234.model.Order" %>
    <%@ page import="edu.osu.cse5234.business.view.Item" %>
    <%@ page import="edu.osu.cse5234.model.LineItem" %>
<jsp:include page="Header.jsp" />
<div class="jumbotron">
  <div class="container">
	<% Order order = (Order) request.getAttribute("order"); %>
	<%if(order == null){ %>
	 <h1><%="No Order yet!" %></h1>
	 <% }else{%>
	<table border= "1">
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			
		</tr>
			<% for(Item item: order.getItems()){ %>
				<tr>
					<td><%= item.getName() %></td>
					<td>$<%= item.getUnitPrice() %></td>
					<td><%= item.getAvailableQuantity() %></td>	
	         	</tr>
	   		
			
			<%} }%>
		</table>
		
		<form action= "viewConfirmation" >
			<input type="submit" value="Next">
		</form>
  </div>
</div>
	
<jsp:include page="Footer.jsp" />