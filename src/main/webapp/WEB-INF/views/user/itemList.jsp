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
		名前<input type="text" name="useritem"> 
		<button type="submit" class="btn btn-info">検索</button>
	</form>
</div>
	<br>

	<table border="1" align="center">
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
	</table>
	
	

</body>
</html>