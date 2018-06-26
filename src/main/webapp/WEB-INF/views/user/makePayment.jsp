<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>決済する</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testHeader.css" />
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
</head>
<body>
<jsp:include page="testHeader.jsp" />

<h2 align="center">ご注文内容</h2>

<hr>
<table border="1" width="350"  align="center">
<tr>

<th>商品名</th>
<th>価格</th>
<th>個数</th>
<th>税抜き価格</th>
<th>小計</th>
</tr>
<c:forEach var="orderItem" items="${order.orderItemList}">
<tr>
<td><c:out value ="${orderItem.item.name}"/></td>
<td>&yen;<fmt:formatNumber value="${orderItem.item.price}" pattern="###,###"/></td>
<td><c:out value ="${orderItem.quantity}"/></td>
<td>&yen;<fmt:formatNumber value="${orderItem.item.price*orderItem.quantity}" pattern="###,###"/></td>
<td>&yen;<fmt:formatNumber value="${orderItem.item.price*orderItem.quantity*1.08}" pattern="###,###"/></td>
</tr>
</c:forEach>
<tr>
<td>消費税</td>
<td align="right" colspan="4">&yen;<fmt:formatNumber value="${order.totalPrice*0.08}" pattern="###,###"/></td>

</tr>
<tr>
<td>送料一律</td>
<td align="right" colspan="4">&yen;500</td>

</tr>
<tr>
<td>商品合計</td>
<td align="right" colspan="4">&yen;<fmt:formatNumber value="${order.totalPrice*1.08 + 500}" pattern="###,###"/></td>

</tr>
</table><br>
<h2 align="center">お届け先</h2>
<hr><div align="center">
お名前：<c:out value="${order.deliveryName}"/><br>
メールアドレス：<c:out value="${order.deliveryEmail}"/><br>
住所：<c:out value="${order.deliveryAddress}"/><br>
郵便番号：<c:out value="${order.deliveryZipCode}"/><br>
電話番号：<c:out value="${order.deliveryTel}"/><br><br>
<form:form action="${pageContext.request.contextPath}/user/payment/confirmed?orderId=${order.id}">
<button type="submit" class="btn btn-info">確定</button>
</form:form></div>

</body>
</html>