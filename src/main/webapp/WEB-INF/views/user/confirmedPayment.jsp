<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>決済完了画面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" />
<link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet">
</head>
<body>
<jsp:include page="userHeader.jsp" />
</br></br>
	<h1 align="center">決済が完了しました！</h1>
	<h2 align="center">この度はご注文ありがとうございます。<br>
	お支払い先は、お送りしたメールに記載してありますのでご確認ください。</h2>
	<p align="center"><a href="${pageContext.request.contextPath}/user/item">一覧画面へ戻る</a></p>

</body>
</html>