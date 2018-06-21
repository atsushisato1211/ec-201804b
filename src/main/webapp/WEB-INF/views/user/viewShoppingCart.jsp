<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ショッピングカート一覧</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" />
</head>
<body>
<header>
		<div id="userHeader" align="right">
			<p>こんにちはゲストさん</p>
			<p><a href="${pageContext.request.contextPath}/index">ログイン</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="${pageContext.request.contextPath}/item/"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div>
</header>



    <h2 align="center">ショッピングカート一覧</h2>
    
    <c:forEach var="order" items="${orderList}">
	<c:if test="${order.orderItemList} == null">
    <p align="center">カートに商品がありません</p>
	</c:if>
	<c:forEach var="orderItem" items="${order.orderItemList}">
        <table border ="1"  align="center">
            <tr>
                <th colspan="2">商品名</th>
                <th>価格</th>
                <th>個数</th>
                <th></th>
            </tr>
            <tr>
				<td><a href="${pageContext.request.contextPath}/user/itemdetail"><img src="${pageContext.request.contextPath}/img/<c:out value="${orderItem.item.imagePath}"/>" width="150"height="125" alt="商品画像"></a></td>
                <td><a href="${pageContext.request.contextPath}/user/itemdetail"></a><c:out value="${orderItem.item.name}"/></td>
                <td>&yen;<c:out value="${orderItem.item.price}"/></td>
                <td><c:out value="${orderItem.quantity}"/>個</td>
                <td>
                    <form action="${pageContext.request.contextPath}/user/show" method="post">
                        <input type="hidden" name="item.id" value="1">
                        <input type="submit" value="削除">
                    </form>
                </td>
            </tr>
        </table><br>
        </c:forEach>
</c:forEach>
    <div  align="center"><a href="${pageContext.request.contextPath}/user/make">決済へ</a></div>
</body>
</html>