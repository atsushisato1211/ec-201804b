<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ecHeader.css" />
</head>

<header>
		<div id="userHeader" align="right">
			<p>こんにちはゲストさん</p>
			<p><a href="userLogin.html">ログイン</a></p>
			<p><a href="viewShoppingCart.html">カートの中身を見る</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="<%=request.getContextPath()%>/item/"><img src="<%=request.getContextPath()%>/img/rakus.jpg" width="50"
				height="50" alt="ロゴ">ＥＣサイトラクス</a></h1></div>
		<div id="title" align="center">
		</div>
</header>
<body>

	<br>


	<h2  align="center">商品詳細</h2>
	<table border="1" align="center">
		<tr>
			<td colspan="2" rowspan="3"><img src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>" width="150"
				height="150" alt="商品画像">
			</td>
			<th>商品名：</th>
			<td align="center"><c:out value="${item.name}" /></td>
		</tr>
		<tr>
			<th>価格：</th>
			<td align="center">&yen;<c:out value="${item.price}" /></td>
		</tr>
		<tr>
			<th>商品説明：</th>
			<td><c:out value="${item.description}" /></td>
		</tr>
	</table>
		<div ="sendCart" align="center"><p><a href="<%=request.getContextPath()%>/item/">商品一覧画面へ戻る</a></p></div>
</body>
</html>