<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
  <tr><td>
    <a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
  </td></tr>
</table>

<div align="center">
  <p>
    <b>Please confirm the information below and then press continue...</b>
  </p>
  <p></p>
  <table class="n13">
    <tr>
      <td align="center" colspan="2">
        <font size="4"><b>Item Information</b></font><br />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <font color="GREEN" size="4"><b>입력내용을 확인하세요</b></font></td>
    </tr>
    <tr>
      <td>Category</td>
      <td>${itemForm.item.product.categoryId}</td>
    </tr>
    <tr>
      <td>Product Name</td>
      <td>${itemForm.item.product.name}</td>
    </tr>
    <tr>
      <td>판매자</td>
      <td>${itemForm.item.sellerUsername}</td>
    </tr>
    <tr>
      <td>가격</td>
      <td>${itemForm.item.listPrice}</td>
    </tr>
    <tr>
      <td>특징</td>
      <td>${itemForm.item.attribute1}</td>
    </tr>
  </table>
  <p>
    <a href='<c:url value="/shop/confirmAddItem.do"/>'>
      <img border="0" src="../images/button_continue.gif" alt="" /></a>
  </p>
</div>

<%@ include file="IncludeBottom.jsp"%>
