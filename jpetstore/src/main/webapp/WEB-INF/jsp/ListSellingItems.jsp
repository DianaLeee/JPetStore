<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<script type="text/javascript">
	function delete_confirm_event(item) {
		/*var x = document.getElementById("test").name;*/
		if(confirm("정말 물품을 삭제하시겠습니까?" + item) == true) {
			window.location.href= '<c:url value="/shop/removeSellingItem.do"/>?workingItemId=' + item;
			/*window.location.href = '<c:url value="/shop/removeSellingItem.do"><c:param name="workingItemId" value="${item.id}"/></c:url>';*/
		} else {
			return;
		}
	}
	
	function edit_confirm_event(item) {
		if(confirm("물품을 수정하시겠습니까?" + item) == true) {
			window.location.href= '<c:url value="/shop/editSellingItem.do"/>?workingItemId=' + item;
		} else {
			return;
		}
	}
</script>
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
      <td><b>삭제하기</b></td>
      <td><b>수정하기</b></td>
    </tr>
    <c:forEach var="item" items="${sellingItemList}" varStatus="status">
      <tr bgcolor="#FFFF88">
        <td>
          <b><a href='<c:url value="/shop/viewItem.do">
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
        <td>
          <b>
          	<font color="black"><c:out value="${item.listPrice}" /></font>
          </b>
        </td>
        <td>
        	<input type="button" id="deleteButton" value="삭제" onclick="delete_confirm_event('${item.itemId}');">
        </td>
        <td>
        	<input type="button" id="editButton" value="수정" onclick="edit_confirm_event('${item.itemId}')">
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<%@ include file="IncludeBottom.jsp"%>
