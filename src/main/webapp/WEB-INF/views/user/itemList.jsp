<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品一覧</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ecHeader.css" />
</head>
<body>
	<jsp:include page="userHeader.jsp" />
<div align ="center">
	<h2>商品一覧</h2>
	<form action="<%=request.getContextPath()%>/item/findByName">
		名前<input type="text" name="useritem" value="${itemName}"> 
		<button type="submit" class="btn btn-info">検索</button>
			</form>
			<form action="<%=request.getContextPath()%>/item/findByNameAndSort" align="center">
		<input type="hidden" name="useritem" value="${itemName}">
		<select name="itemSort" onChange="this.form.submit()">  
		<option value="id">ソート</option>
		  <option value="name">名前順</option>
		  <option value="price">価格順</option>
		</select>
<input type="hidden" value="ASC" name="sortOption">
		<%-- <form:checkbox path="sortOption" value="DESC"/>降順で検索 --%>
		<input type="checkbox" name="sortOption" value="DESC">降順で検索 
	</form>
</div>
	<br><c:choose>
	<c:when test="${itemList.isEmpty()}"><c:out value="${itemName}"/>は商品名に該当しません。</c:when>
	<c:otherwise><table border="1" align="center">
		<tr>
			<th colspan="2">商品名</th>
			<th>価格</th>
		</tr>
		<c:forEach var="item" items="${itemList}">
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/item/itemdetail?id=<c:out value="${item.id}"/>"><img
						src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>"
						width="150" height="125" alt="<c:out value="${item.name}" />画像"></a></td>
				<td><a
					href="<%=request.getContextPath()%>/item/itemdetail?id=<c:out value="${item.id}"/>">
						<c:out value="${item.name}" />
				</a></td>
				<td>&yen;<c:out value="${item.price}" /></td>
			</tr>
		</c:forEach>
	</table></c:otherwise>
	</c:choose>
	
	
	<c:if test="${!itemList.isEmpty()}">
	
	</c:if>
	

</body>
</html>