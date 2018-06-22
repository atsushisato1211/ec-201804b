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



	<div align="center">
	<h2>商品登録画面</h2>
	<form:form modelAttribute="itemForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/admin/itemInsert">

	<table>
	<tr><td><label for="name">商品名:</label></td><td><form:input path="name" value="${itemContent.name}"/><form:errors path="name" cssStyle="color:red" element="div"/></td></tr>
	<tr><td><label for="description">商品説明:</label></td><td><form:textarea path="description" value="${itemContent.description}"/><form:errors path="description" cssStyle="color:red" element="div"/></td></tr>
	<tr><td><label for="price">商品価格:</label></td><td><form:input path="price" value="${itemContent.price}"/><form:errors path="price" cssStyle="color:red" element="div"/></td></tr>
	<tr><td><label for="imagePath">商品画像:</label></td><td> <input name="imagePath" type="file" accept="image/*"/><form:errors path="imagePath" cssStyle="color:red" element="div"/></td></tr>
	</table>
	<button type="submit" class="btn btn-info">登録</button>	
	</form:form>
	</div>
	
</body>
</html>