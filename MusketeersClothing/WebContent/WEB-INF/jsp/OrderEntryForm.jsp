<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.osu.cse5234.model.Order" %>
<%@ page import="edu.osu.cse5234.business.view.Item" %>

<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="Header.jsp" />
<div class="jumbotron">
  <div class="container">
	<% Order order = (Order)request.getAttribute("order"); %>
	<form:form modelAttribute="order" method="post" action="purchase/submitItems" >
		<table>
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			
		</tr>
			<c:forEach items="${order.items}" var="item" varStatus="loop">
				<tr>
					<td><form:input path="items[${loop.index}].name" readonly="true" /></td>
					<td>$<form:input path="items[${loop.index}].price" readonly="true" /></td>
					<td><form:input path="items[${loop.index}].quantity" /></td>
	         	</tr>
	   		</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Purchase"></td>
			</tr>
		</table>
	</form:form>
  </div>
</div>
<jsp:include page="Footer.jsp" />