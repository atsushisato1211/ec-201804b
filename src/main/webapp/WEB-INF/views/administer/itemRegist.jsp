<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminHeader.css" />
</head>
<body>
<header>
		<div id="userHeader" align="right">
			<p>こんにちは管理者さん</p>
			<p><a href="administerLogin.html">ログイン</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="<%=request.getContextPath()%>/menu/"><img src="<%=request.getContextPath()%>/img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div>
</header>



	<h2 align="center">商品登録画面</h2>
	<form:form modelAttribute="itemForm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/menu/itemInsert">
	<table>
	<tr><td>商品名</td><td><form:input path="name" value="${itemContent.name}"/></td></tr>
	<tr><td>商品説明</td><td><form:textarea path="description" value="${itemContent.description}"/></td></tr>
	<tr><td>商品価格</td><td><form:input path="price" value="${itemContent.price}"/></td></tr>
	<tr><td>商品画像</td><td> <input name="imagePath" type="file" accept="image/*" required/></td></tr>
	</table>
	<input type="submit" value="登録">	
	</form:form>
	
	
</body>
</html>