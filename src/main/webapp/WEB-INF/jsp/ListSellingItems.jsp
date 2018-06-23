<%@ include file="IncludeTop.jsp"%>

<div align="center">
  <p>
    <font size="4"><b>My Selling Items</b></font>
  </p>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Item ID</b></td>
      <td><b>Category</b></td>
      <td><b>Product</b></td> 
      <td><b>Description</b></td>
      <td><b>Selling Price</b></td>
      <td><b>Status</b></td>
    </tr>
    <c:forEach var="item" items="${sellingItemList}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><a href='<c:url value="/shop/viewOrder.do">
              <c:param name="itemId" value="${item.itemId}"/></c:url>'>
              <font color="black"><c:out value="${item.itemId}" /></font>
            </a></b>
        </td>
        <td>
          <b>
          	<font color="black"><c:out value="${item.product.categoryId}" /></font>
          </b>
        </td>
        <td>
          <b>
          	<font color="black"><c:out value="${item.product.name}" /></font>
          </b>
        </td>
        <td>
          <b>
          	<font color="black"><c:out value="${item.attribute1}" /></font>
          </b>
        </td>
         <td>
          <b>
          	<font color="black"><c:out value="${item.listPrice}" /></font>
          </b>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<%@ include file="IncludeBottom.jsp"%>
