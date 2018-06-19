<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>管理者ログイン画面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
</head>
<body>
	<header>
		<div id="userHeader" align="right">
			<p>こんにちは管理者さん</p>

		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="../user/itemList.html"><img src="../img/rakus.jpg"
					width="50" height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>


	<div align="center">

		<h2>ログイン</h2>
		<form:form modelAttribute="adminUserLoginForm"
			action="${pageContext.request.contextPath}/admin/login">
	
					メールアドレス：<form:input path="email" />
					<br>パスワード： <form:input path="password" />
					<br><input type="submit" value="ログイン" />
		</form:form>
	</div>
</body>
</html>