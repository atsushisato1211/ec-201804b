<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminHeader.css" />
</head>
<body>
	<header>
		<div id="userHeader" align="right"></div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="${pageContext.request.contextPath}/menu/"><img src="../img/rakus.jpg"
					width="50" height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>
	
	<div align="center">

<h1>注文一覧画面</h1>
<table border="1">
      <tr>
        <th nowrap>注文番号</th>
        <th nowrap>日付</th>
        <th nowrap>利用者名</th>
        <th nowrap>現在のステータス</th>
        <th nowrap>総計(税込)</th>
      </tr>
      <c:forEach var="order" items="${orderList}">
      <tr>
        <td><a href="${pageContext.request.contextPath}/admin/orderDetail?id=${order.id}"><c:out value="${order.orderNumber}"/></a></td>
        <td><c:out value="${order.orderDate}"/></td>
        <td><c:out value="${order.deliveryName}"/></td>
        <td><c:out value="${order.statusString}"/></td>
        <td><c:out value="${order.totalPrice}"/></td>
      </tr>
     </c:forEach>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/admin/menu">メニューに戻る</a>
</div>
	
</body>
</html>