<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品一覧</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewList.css" type="text/css">
</head>
<body>
<jsp:include page="adminHeader.jsp" />



	<h2 align="center">商品一覧</h2>
	
	<form:form action="${pageContext.request.contextPath}/admin/findByName" align="center">
		名前<input type="text" name="adminitem" align="center"> <input
			type="submit" value="検索" align="center">
	</form:form>
	    <c:choose>
	<c:when test="${itemList.isEmpty()}">
    <p align="center"><font size="5">検索結果がありません</font></p>
	</c:when>
	<c:otherwise>
	<div class=margin align="center">
	<table class="table table-striped" border="1" style="font-size:15pt" >
		<tr>
			<th colspan="2">商品名</th>
			<th>価格</th>
			<th>在庫数</th>
			<th>売上</th>
			<th>削除</th>
		</tr>
		<c:forEach var="item" items="${itemList}" >
			<tr>
				<td><img
						src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>"
						width="150" height="125" alt="<c:out value="${item.name}" />画像"></a></td>
				<td><c:out value="${item.name}"/></td>
				<td>&yen;<fmt:formatNumber value="${item.price}" pattern="###,###"/></td>
				<td><c:out value="${item.stock}" /></td>
				<td>&yen;<fmt:formatNumber value="${item.proceed}" pattern="###,###"/></td>
				<td>
				<form:form action="${pageContext.request.contextPath}/admin/itemContent" align="center" method="post">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="submit" value="編集" align="center"><br>
	</form:form>
				<!-- <input type="submit" value="削除" align="center"> -->
				<form:form action="${pageContext.request.contextPath}/admin/changeByDeleted" align="center" method="post">
				<c:if test="${item.deleted==false}">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="hidden" name="deleted" value='<c:out value="${item.deleted}"/>'>
				<input type="submit" value="削除" align="center"></c:if>
				<c:if test="${item.deleted==true}">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="hidden" name="deleted" value='<c:out value="${item.deleted}"/>'>
				<input type="submit" value="再表示" align="center"></c:if>
	</form:form>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:otherwise>
	</c:choose>
	
</body>
</html>