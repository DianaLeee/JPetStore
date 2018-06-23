<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="IncludeTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
<form:form method="post" commandName="itemForm" method="post">
<form:errors cssClass="error" /> <br><br>
<table class="n13" id="editItem">
	<tr>
		<td colspan="2">
			<font color="green" size="4"><b>Item Details</b></font>
		</td>
	</tr>
	<tr>
		<td>Category: </td> <!-- Product 객체의 categoryId field -->
		<td><form:select path="item.product.categoryId" items="${categoryNames}" />
		</td>
	</tr>	
	<tr>
		<td>Product Name: </td> <!-- Product 객체의 name field -->
		<td><form:select path="item.product.name" items="${productNames}" />
		    <form:errors path="item.product.name" />
		</td>
	</tr>
	<tr>
		<td>판매자: </td> <!-- item 객체의 sellerUsername field. read only. from session. -->
		<td><form:input path="item.sellerUsername" value="${userSession.account.username}" disabled="true" />
		    <form:errors path="item.sellerUsername" />
		</td>
	</tr>
	<tr>
		<td>가격: </td> <!-- item 객체의 listPrice field -->
		<td><form:input path="item.listPrice" type="number" value="${itemForm.listPrice}" />
		    <form:errors path="item.listPrice" />
		</td>
	</tr>
	<tr>
		<td>특징: </td> <!-- item 객체의 attribute1 field -->
		<td><form:input path="item.attribute1" />
		    <form:errors path="item.attribute1" />
		</td>
	</tr>
</table>
<p>
	<input type="image" src="../images/button_submit.gif">
</p>
</form:form>
</div>
<%@ include file="IncludeBottom.jsp"%>

