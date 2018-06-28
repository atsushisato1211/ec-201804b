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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewOrderDetail.css" type="text/css">
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<div align="center" class="view">

<h1>注文詳細画面</h1>
<table class="table table-striped" border="1">
				  <tr>
				    <th nowrap><font size="3">注文NO</font></th>
				    <td><font size="3"><c:out value="${order.orderNumber}"/></font></td>
				  </tr>
				  <tr>
				    <th nowrap><font size="3">名前</font></th>
				    <td><font size="3"><c:out value="${order.deliveryName}"/></font></td>
				  </tr>
				  <tr>
				    <th nowrap><font size="3">アドレス</font></th>
				    <td><font size="3"><c:out value="${order.deliveryEmail}"/></font></td>
				  </tr>
				  <tr>
				    <th nowrap><font size="3">住所</font></th>
				    <td><font size="3"><c:out value="${order.deliveryAddress}"/></font></td>
				  </tr>
				  <tr>
				    <th nowrap><font size="3">TEL</font></th>
				    <td><font size="3"><c:out value="${order.deliveryTel}"/></font></td>
				  </tr>
				  </table>
				  <br>
				  
	<table border="1" class="table table-striped">
      <c:forEach var="orderItem" items="${order.orderItemList}">
    <tr>
        <th nowrap><font size="3">商品</font></th>
        <th nowrap><font size="3">価格</font></th>
        <th nowrap><font size="3">×</font></th>
        <th nowrap><font size="3">個数</font></th>
       <th nowrap><font size="3">金額</font></th>
      </tr>
      <tr>
        <td><font size="3"><c:out value="${orderItem.item.name}"/></font></td>
        <td><font size="3">&yen;<fmt:formatNumber value="${orderItem.item.price}" pattern="###,###"/></font></td>
        <td><font size="4">×</font></td>
        <td><font size="3"><c:out value="${orderItem.quantity}"/></font></td>
        <td><font size="3">&yen;<fmt:formatNumber value="${orderItem.item.price*orderItem.quantity}" pattern="###,###"/></font></td>
      </tr>
      </c:forEach>
    </table><br>
    
    
    <table border="1" class="table table-striped">
				  <tr>
				    <th nowrap><font size="3">小計</font></th>
				    <td><font size="3">&yen;<fmt:formatNumber value="${order.totalPrice}" pattern="###,###"/></font></td>
				  </tr>
				  <tr>
				    <th nowrap><font size="3">税</font></th>
				    <td><font size="3">&yen;<fmt:formatNumber value="${order.totalPrice*0.08}" pattern="###,###"/></font></td>
				  </tr>
				  <tr>
				    <th nowrap><font size="3">支払い方法</font></th>
				    <td>
				      <font size="3">銀行振込</font>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      <font size="3">送料一律</font>
				    </th>
				    <td>
				   <font size="3">  500円</font>
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				 <font size="3">     総計</font>
				    </th>
				    <td><font size="3">&yen;<fmt:formatNumber value="${order.totalPrice*1.08 + 500}" pattern="###,###"/></font></td>
				  </tr>
				  </table><br>

	<table border="1" class="table table-striped">
      <tr>
        <th nowrap><font size="3">現在のステータス</font></th>
        <th nowrap><font size="3">ステータス変更</font></th>
      </tr>
      <tr>
        <td><font size="3"><c:out value="${value}"/></font></td>
        <td><form:form modelAttribute="oderDetailForm" action="${pageContext.request.contextPath}/admin/updateStatus?id=${order.id}">
<select name="status">
<option value="1">未入金</option>
<option value="2" selected>入金済み</option>
<option value="3">発送済み</option>
<option value="4">キャンセル</option>
</select>

<input type="hidden" name="id" value="">
<button type="submit" class="btn btn-info">更新</button>
</form:form></td>
      </tr>
    </table><br>
 <c:out value ="${update}"/>
    <a href="${pageContext.request.contextPath}/admin/orderList/"><font size="5">注文一覧に戻る</font></a>
    <br>
</div>
</body>
</html>