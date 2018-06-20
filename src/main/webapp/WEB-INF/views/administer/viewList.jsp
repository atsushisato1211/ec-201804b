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



	<h2 align="center">商品一覧</h2>
	<form action="<%=request.getContextPath()%>/menu/findByName" align="center">
		名前<input type="text" name="adminitem" align="center"> <input
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
				<td><img
						src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>"
						width="150" height="125" alt="<c:out value="${item.name}" />画像"></a></td>
				<td><c:out value="${item.name}"/></td>
				<td>&yen;<c:out value="${item.price}" /></td>
				<td>
				<form action="<%=request.getContextPath()%>/menu/itemContent" align="center" method="post">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="submit" value="編集" align="center"><br>
	</form>
				<!-- <input type="submit" value="削除" align="center"> -->
				<form action="<%=request.getContextPath()%>/menu/changeByDeleted" align="center" method="post">
				<c:if test="${item.deleted==true}">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="hidden" name="deleted" value='<c:out value="${item.deleted}"/>'>
				<input type="submit" value="削除" align="center"></c:if>
				<c:if test="${item.deleted==false}">
				<input type="hidden" name="id" value='<c:out value="${item.id}"/>'>
				<input type="hidden" name="deleted" value='<c:out value="${item.deleted}"/>'>
				<input type="submit" value="再表示" align="center"></c:if>
	</form>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>