<!-- Tiles: Header -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table> <!--  class="top"> -->
  <tr>
    <td>
      <a href="<c:url value="/shop/index.do"/>">
        <img border="0" src="../images/logo-topbar.gif" /></a>
    </td>
    <td style="text-align:right">
      <a href="<c:url value="/shop/viewCart.do"/>">
        <img border="0" name="img_cart" src="../images/cart.gif" /></a>
      <img border="0" src="../images/separator.gif" />
      <c:if test="${empty userSession.account}" >
        <a href="<c:url value="/shop/signonForm.do"/>">
          <img border="0" name="img_signin" src="../images/sign-in.gif" /></a>
      </c:if>
      <c:if test="${!empty userSession.account}" >
        <a href="<c:url value="/shop/signoff.do"/>">
          <img border="0" name="img_signout" src="../images/sign-out.gif" /></a>
        <img border="0" src="../images/separator.gif" />
        <a href="<c:url value="/shop/editAccount.do"/>">
          <img border="0" name="img_myaccount" src="../images/my_account.gif" /></a>
      </c:if>
      
      
      <!-- Added Code for seeing my selling items-->
      <!-- If User login, add link to selling user's items -->
      <img border="0" src="../images/separator.gif" />
      <c:if test="${!empty userSession.account}" >
        <a href="<c:url value="/shop/listSellingItems.do"/>">판매중인 나의 물품 보기</a>
      </c:if>
      <!-- End of added code for seeing my selling items -->
      
      <img border="0" src="../images/separator.gif" />&nbsp;
      <a href="../help.html"><img border="0" name="img_help" src="../images/help.gif" /></a>
    </td>
    <td style="text-align:left">
      <form action="<c:url value="/shop/searchProducts.do"/>" method="post">
	    <input type="hidden" name="search" value="true"/>
        <input type="text" name="keyword" size="14" />&nbsp;
        <input src="../images/search.gif" type="image"/>
      </form>
    </td>
     <td style="text-align:left">
    	<a href="<c:url value="/shop/blacklist.do"/>">Black List</a>
    </td>
  </tr>
</table>

<%@ include file="IncludeQuickHeader.jsp" %>

