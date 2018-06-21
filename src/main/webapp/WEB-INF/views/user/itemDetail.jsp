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
			<td colspan="2" rowspan="2"><img src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>" width="150"
				height="150" alt="商品画像">
			</td>
			<th>商品名：</th>
			<td align="center"><c:out value="${item.name}" /></td>
		</tr>
		<tr>
			<th>価格：</th>
			<td align="center">&yen;<c:out value="${item.price}" /></td>
		</tr>
	<%-- 	<tr>
			<th>商品説明：</th>
			<td><pre><c:out value="${item.description}" /></pre></td>
		</tr> --%>
		<tr>
			<th colspan="2">商品説明：</th>
			<td colspan="2"><pre><c:out value="${item.description}" /></pre></td>
		</tr>
	</table>
		<br>
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
			<td><pre><c:out value="${item.description}" /></pre></td>
		</tr>
		
	</table>
		<br>
	<div id="selectQuantity" align="center">
	<form:form modelAttribute="orderItemForm" action="${pageContext.request.contextPath}/insert/" method="post">
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
<<<<<<< HEAD
		<div ="sendCart" align="center"><p><a href="<%=request.getContextPath()%>/user/item">商品一覧画面へ戻る</a></p></div>
=======

			<input type="hidden" name="itemId" value="<c:out value="${item.id}"/>">
<!-- 		<div ="sendCart" align="center"><p><input type="submit" value="カートに入れる"></p></div> -->	

		<div ="sendCart" align="center"><p><a href="<%=request.getContextPath()%>/item/">商品一覧画面へ戻る</a></p></div>
		</form:form>
>>>>>>> bf85cc2638818c5a81da4134d45bc80693f33f50
</body>
</html>