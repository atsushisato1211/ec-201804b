<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>決済完了画面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" />
</head>
<body>
<header>
		<div id="userHeader" align="right">
			<p>こんにちはゲストさん</p>
			<p><a href="${pageContext.request.contextPath}/index">ログイン</a></p>
			<p><a href="${pageContext.request.contextPath}/show">カートの中身を見る</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="${pageContext.request.contextPath}/item/"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div></div>
</header>
	<h1 align="center">決済が完了しました！</h1>
	<h2 align="center">この度はご注文ありがとうございます。<br>
	お支払い先は、お送りしたメールに記載してありますのでご確認ください。</h2>
	<p align="center"><a href="${pageContext.request.contextPath}/item/">一覧画面へ戻る</a></p>

</body>
</html>