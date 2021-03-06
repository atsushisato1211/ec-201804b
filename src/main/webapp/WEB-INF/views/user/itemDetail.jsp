<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品詳細</title>
<%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> --%>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ecHeader.css" /> --%>
<%-- <link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet"> --%>
<%-- <link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet"> --%>
<%-- <link href="${pageContext.request.contextPath}/css/imgslide.css" rel="stylesheet"> --%>
<%-- <link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet"> --%>
<%-- <link href="${pageContext.request.contextPath}/css/wall.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/img/wall.gif">
<%-- <jsp:include page="userHeader.jsp" /> --%>
<%-- <jsp:include page="testHeader.jsp" /> --%>
<jsp:include page="testHeader2.jsp" />
	<br>

<h2 class="item"></h2>
	<h2 class="detail" align="center">商品詳細</h2>
	<div style="background-color:#FAFAFA; width: 90%; height: 50%; margin-left: auto; margin-right: auto; ;" align="center">
	<table border="0" align="center" bordercolor="#333333" style="background-color:#FAFAFA; width: 90%; height: 50%; margin-left: auto; margin-right: auto; ;">
		<tr>
			<td colspan="2" rowspan="3"><img src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>" width="300"
				height="250" alt="商品画像">
			</td>
			<th align="center"><pre>商品名：</pre></th>
			<td align="center"><pre><c:out value="${item.name}" /></pre></td>
		</tr>
		<tr>
			<th align="center"><pre>価格：</pre></th>
			<td align="center"><pre>&yen;<fmt:formatNumber value="${item.price}" pattern="###,###"/></pre></td>
		</tr>
		<tr>
			<th align="center"><pre>商品説明：</pre></th>
			<td ><pre><c:out value="${item.description}" /></pre></td>
		</tr>
	<%-- 	<tr>
			<th>商品説明：</th>
			<td><pre><c:out value="${item.description}" /></pre></td>
		</tr> --%>
	<%-- 	<tr>
			<th colspan="2">商品説明：</th>
			<td colspan="2"><pre><c:out value="${item.description}" /></pre></td>
		</tr> --%>
	</table>
	</div>
		<br>

	<div id="selectQuantity" align="center">
	<form:form modelAttribute="orderItemForm" action="${pageContext.request.contextPath}/user/insert">
			<font color="red"><c:out value ="${error}"/></font><br>
					個数：<!--  <select name="quantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>-->
			<form:input path="quantity"/>

			<div ="sendCart" align="center"><p><button type="submit" class="btn btn-info">カートに入れる</button></p></div>
			
			<input type="hidden" name="itemId" value="<c:out value="${item.id}"/>">
			</form:form>
			</div>

		<div ="sendCart" align="center"><p><a href="<%=request.getContextPath()%>/user/item">商品一覧画面へ戻る</a></p></div>
		


</body>
</html>