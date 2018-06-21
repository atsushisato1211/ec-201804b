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
<jsp:include page="adminHeader.jsp" />
	
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
        <td>&yen;<fmt:formatNumber value="${order.totalPrice*1.08}" pattern="###,###"/></td>
      </tr>
     </c:forEach>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/admin/menu">メニューに戻る</a>
</div>
	
</body>
</html>