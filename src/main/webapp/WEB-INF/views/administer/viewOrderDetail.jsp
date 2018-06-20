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
</head>
<body>
<div align="center">

<h1>注文詳細画面</h1>
<table border="1">
				  <tr>
				    <th nowrap>注文NO</th>
				    <td><c:out value="${order.orderNumber}"/></td>
				  </tr>
				  <tr>
				    <th nowrap>名前</th>
				    <td><c:out value="${order.deliveryName}"/></td>
				  </tr>
				  <tr>
				    <th nowrap>アドレス</th>
				    <td><c:out value="${order.deliveryEmail}"/></td>
				  </tr>
				  <tr>
				    <th nowrap>住所</th>
				    <td><c:out value="${order.deliveryAddress}"/></td>
				  </tr>
				  <tr>
				    <th nowrap>TEL</th>
				    <td><c:out value="${order.deliveryTel}"/></td>
				  </tr>
				  </table><br>
				  
	<table border="1">
      <c:forEach var="orderItem" items="${order.orderItemList}">
      <tr>
        <th nowrap>商品</th>
        <th nowrap>価格</th>
        <th nowrap>×</th>
        <th nowrap>個数</th>
       <th nowrap>金額</th>
      </tr>
      <tr>
        <td><c:out value="${orderItem.item.name}"/></td>
        <td><c:out value="${orderItem.item.price}"/>円</td>
        <td>×</td>
        <td><c:out value="${orderItem.quantity}"/></td>
        <td><c:out value="${orderItem.item.price*orderItem.quantity}"/>円</td>
      </tr>
      </c:forEach>
    </table><br>
    
    
    <table border="1">
				  <tr>
				    <th nowrap>小計</th>
				    <td><c:out value="${order.totalPrice}"/>円</td>
				  </tr>
				  <tr>
				    <th nowrap>税</th>
				    <td><c:out value="${order.totalPrice*0.08}"/>円</td>
				  </tr>
				  <tr>
				    <th nowrap>支払い方法</th>
				    <td>
				      銀行振込
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      送料一律
				    </th>
				    <td>
				      500円
				    </td>
				  </tr>
				  <tr>
				    <th nowrap>
				      総計
				    </th>
				    <td><c:out value="${order.totalPrice*1.08+500}"/>円</td>
				  </tr>
				  </table><br>

	<table border="1">
      <tr>
        <th nowrap>現在のステータス</th>
        <th nowrap>ステータス変更</th>
      </tr>
      <tr>
        <td><c:out value="${value}"/></td>
        <td><form:form modelAttribute="oderDetailForm" action="${pageContext.request.contextPath}/updateStatus?id=${order.id}">
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
 <p id="notice-input-text-1" style="display: none; color: red;"> 更新されました。</p><br>
<br>
    <a href="${pageContext.request.contextPath}/orderList/">注文一覧に戻る</a>
</div>
</body>
</html>