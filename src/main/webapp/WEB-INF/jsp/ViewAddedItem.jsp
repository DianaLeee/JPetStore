<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
    </td>
  </tr>  
</table>

<div align="center">
  <c:if test="${!empty message}">
    <b><c:out value="${message}" /></b>
  </c:if>
  
  <p></p>
  <table class="n13">
    <tr>
      <td align="center" colspan="2"><font size="4">
        <b>Item #<c:out value="${addedItem.itemId}" /></b></font> <br />
    </tr>
    <tr>
      <td colspan="2"><font color="green" size="4"><b>Item Details</b></font></td>
    </tr>
   <tr>
      <td>Category</td>
      <td>${addedItem.product.categoryId}</td>
    </tr>
    <tr>
      <td>Product Name</td>
      <td>${addedItem.product.name}</td>
    </tr>
    <tr>
      <td>판매자</td>
      <td>${addedItem.sellerUsername}</td>
    </tr>
    <tr>
      <td>가격</td>
      <td>${addedItem.listPrice}</td>
    </tr>
    <tr>
      <td>특징</td>
      <td>${addedItem.attribute1}</td>
    </tr>
  </table>
</div>

<%@ include file="IncludeBottom.jsp"%>