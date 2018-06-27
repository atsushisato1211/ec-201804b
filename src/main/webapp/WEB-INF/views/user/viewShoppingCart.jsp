<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ショッピングカート一覧</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testHeader.css" />
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
</head>
<body>
<jsp:include page="testHeader.jsp" />

    <h2 align="center">ショッピングカート一覧</h2>
    
    <c:choose>
	<c:when test="${order.orderItemList==null}">
    <p align="center">カートに商品がありません</p>
	</c:when>
	<c:otherwise>
        <table border ="1"  align="center">
            <tr>
                <th colspan="2">商品名</th>
                <th>価格</th>
                <th>個数</th>
                <th></th>
            </tr>
	<c:forEach var="orderItem" items="${order.orderItemList}">
            <tr>
				<td><img src="${pageContext.request.contextPath}/img/<c:out value="${orderItem.item.imagePath}"/>" width="150"height="125" alt="商品画像"></td>
                <td><c:out value="${orderItem.item.name}"/></td>
                <td>&yen;<c:out value="${orderItem.item.price}"/></td>
                <td><c:out value="${orderItem.quantity}"/>個</td>
                <td>
                    <form:form action="${pageContext.request.contextPath}/user/delete">
						<input type="hidden" name ="itemId" value="${orderItem.itemId}"/>
                        <input type="hidden" name ="orderId" value="${orderItem.orderId}"/>
                        <input type="submit" value="削除">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </table><br>
    <div  align="center"><a href="${pageContext.request.contextPath}/user/item">商品一覧へ戻る</a></div>
    <div  align="center"><a href="${pageContext.request.contextPath}/user/payment/make">決済へ</a></div>
        </c:otherwise>
    </c:choose>
</body>
</html>