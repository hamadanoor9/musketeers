<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.osu.cse5234.model.ShippingInfo" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <jsp:include page="Header.jsp" />
<div class="jumbotron">
  <div class="container">
	<% ShippingInfo shippingInfo = (ShippingInfo) request.getAttribute("shipping"); %>
	<form:form modelAttribute="shipping" method="post" action="submitShipping" >
		<table>

				<tr>
					<td>Name: <form:input path="name" /></td>
				</tr>
				<tr>
					<td>Address Line 1: <form:input path="addressLine1" /></td>
				</tr>
				<tr>
					<td>Address Line 2: <form:input path="addressLine2" /></td>
				</tr>
				<tr>
					<td>City: <form:input path="city" /></td>
				</tr>
				<tr>
					<td>State: <form:input path="state" /></td>
				</tr>
				<tr>
					<td>Zip Code: <form:input path="zip" /></td>
				</tr>
					
	         	
	   		
			<tr>
				<td colspan="2"><input type="submit" value="Next"></td>
			</tr>
		</table>
	</form:form>
  </div>
</div>
    <jsp:include page="Footer.jsp" />
	