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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminHeader.css" />
</head>
<body>
<jsp:include page="adminHeader.jsp" />



	<h2 align="center">商品一覧</h2>
	<form:form action="${pageContext.request.contextPath}/admin/findByName" align="center">
		名前<input type="text" name="adminitem" align="center"> <input
			type="submit" value="検索" align="center">
	</form:form>

	<br>

	<table border="1" align="center">
		<tr>
			<th colspan="2">商品名</th>
			<th>価格</th>
		</tr>
		<c:forEach var="item" items="${itemList}">
			<tr>
				<td><img
						src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>"
						width="150" height="125" alt="<c:out value="${item.name}" />画像"></a></td>
				<td><c:out value="${item.name}"/></td>
				<td>&yen;<c:out value="${item.price}" /></td>
				<td>
				<form:form action="${pageContext.request.contextPath}/admin/itemContent" align="center" method="post">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="submit" value="編集" align="center"><br>
	</form:form>
				<!-- <input type="submit" value="削除" align="center"> -->
				<form:form action="${pageContext.request.contextPath}/admin/changeByDeleted" align="center" method="post">
				<c:if test="${item.deleted==true}">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="hidden" name="deleted" value='<c:out value="${item.deleted}"/>'>
				<input type="submit" value="削除" align="center"></c:if>
				<c:if test="${item.deleted==false}">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="hidden" name="deleted" value='<c:out value="${item.deleted}"/>'>
				<input type="submit" value="再表示" align="center"></c:if>
	</form:form>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>