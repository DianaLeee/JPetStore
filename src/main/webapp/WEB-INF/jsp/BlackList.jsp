<%@ include file="IncludeTop.jsp"%>
 
<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/index.do"/>'>
            <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
        </tr>
      </table>
    </td>
    <td style="text-align:center">
      <h2>Black List</h2>
        <table id="blackList">
          <tr bgcolor="#cccccc">
            <td><b>User ID</b></td>
            <td><b>User Name</b></td>
          </tr>
 		  	<c:forEach var="blackList" items="${listOfBlack}">
	 		  	<tr>
		 		  	<td>${blackList.userId}</td>
		 		  	<td>${blackList.username}</td>
		 		</tr>
 		  	</c:forEach>
</table>

<%@ include file="IncludeBanner.jsp"%>
<%@ include file="IncludeBottom.jsp"%>
