<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.osu.cse5234.model.PaymentInfo" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Entry</title>
</head>
<body>
	
	<% PaymentInfo paymentInfo = (PaymentInfo)request.getAttribute("payment"); %>
	<form:form modelAttribute="payment" method="post" action="submitPayment" >
		<table>
			
				<tr>
					<td>Card Number: <form:input path="cardNumber" /></td>
				</tr>
				<tr>
					<td>Expiration date: <form:input path="epirationDate" /></td>
				</tr>
				<tr>
					<td>Cvv: <form:input path="cvv" /></td>
				</tr>
				<tr>
					<td>Name on the card: <form:input path="holderName" /></td>
				</tr>
					
	         	
	   		
			<tr>
				<td colspan="2"><input type="submit" value="Next"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>