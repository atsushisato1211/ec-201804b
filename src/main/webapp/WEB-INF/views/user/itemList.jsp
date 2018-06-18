<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ecHeader.css" />
</head>
<body>
	<header>
		<div id="userHeader" align="right">
			<p>こんにちはゲストさん</p>
			<p>
				<a href="userLogin.html">ログイン</a>
			</p>
			<p>
				<a href="viewShoppingCart.html">カートの中身を見る</a>
			</p>
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="<%=request.getContextPath()%>/item/"><img
					src="<%=request.getContextPath()%>/img/rakus.jpg" width="50"
					height="50" alt="ロゴ">ＥＣサイトラクス</a>
			</h1>
		</div>
		<div id="title" align="center"></div>
	</header>

	<h2 align="center">商品一覧</h2>
	<form action="<%=request.getContextPath()%>/item/findByName" align="center">
		名前<input type="text" name="useritem" align="center"> <input
			type="submit" value="検索" align="center">
	</form>

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