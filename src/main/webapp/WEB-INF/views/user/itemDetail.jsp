<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品詳細</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ecHeader.css" />
</head>
<body>
<jsp:include page="userHeader.jsp" />
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
		<br>
	<div id="selectQuantity" align="center">
	<form action="" method="post">
					個数：<select name="quantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select></div>
			<div ="sendCart" align="center"><p><button type="submit" class="btn btn-info">カートに入れる</button></p></div>
		<div ="sendCart" align="center"><p><a href="<%=request.getContextPath()%>/item/">商品一覧画面へ戻る</a></p></div>
</body>
</html>