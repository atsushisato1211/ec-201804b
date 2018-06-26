<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>お問い合わせ完了フォーム</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/imgslide.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/itemList.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/item_table.css" rel="stylesheet">
<%-- <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ecHeader.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/testHeader.css" />
</head>
<body>
	<jsp:include page="testHeader.jsp" />
	<p><br></p>
	<br>
	<div align="center">
	<h1>お問い合わせありがとうございました！</h1>
	<h2>お客様の声は今後の経営に反映させていきます。</h2>
	<h2>これからも楽青果をよろしくお願いいたします。</h2>
	<a href ="${pageContext.request.contextPath}/user/item">メニュー画面へ戻る</a>
	
	</div>
</body>
</html>