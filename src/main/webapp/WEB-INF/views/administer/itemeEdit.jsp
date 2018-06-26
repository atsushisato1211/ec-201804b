<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/adminHeader.css" />
</head>
<body>
	<jsp:include page="adminHeader.jsp" />



	<h2 align="center">商品編集</h2>
	<form:form modelAttribute="itemForm" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/admin/itemeEdit">
		<table>
			<tr>
				<td>商品名</td>
				<td><form:input path="name" value="${itemContent.name}" /></td>
			</tr>
			<tr>
				<td>商品説明</td>
				<td><form:textarea path="description"
						value="${itemContent.description}" /></td>
			</tr>
			<tr>
				<td>商品価格</td>
				<td><form:input path="price" value="${itemContent.price}" /></td>
			</tr>
			<tr>
				<td>商品画像</td>
				<td><input name="imagePath" type="file" accept="image/*"
					required /></td>
			</tr>
			<tr>
				<td><label for="season">季節:</label></td>
				<td><form:input path="season" /> <form:errors path="season"
						cssStyle="color:red" element="div" /></td>
			</tr>
			<tr>
				<td><label for="producingArea">生産地:</label></td>
				<td><form:input path="producingArea" /> <form:errors
						path="producingArea" cssStyle="color:red" element="div" /></td>
			</tr>
			<tr>
				<td>削除済み</td>
				<td><c:if test="${itemContent.deleted==true}">
						<form:checkbox path="deleted" checked="checked" />
					</c:if> <c:if test="${itemContent.deleted==false}">
						<form:checkbox path="deleted" />
					</c:if></td>
			</tr>
		</table>
		<input type="hidden" name="id"
			value='<c:out value="${itemContent.id}"/>'>
		<input type="submit" value="変更">
	</form:form>


</body>
</html>