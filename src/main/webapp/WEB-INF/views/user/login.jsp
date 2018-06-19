<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ecHeader.css">
</head>
<body>
	<header>
		<div id="userHeader" align="right">
			<p>こんにちはゲストさん</p>
			<p>
				<a href="${pageContext.request.contextPath}">カートの中身を見る</a>
			</p>
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="itemList.html"><img src="../img/rakus.jpg" width="50"
					height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
	</header>

	<h1>ECサイトラクス</h1>

	<form:form modelAttribute="userLoginForm"
		action="${pageContext.request.contextPath}/login">
		<table class="t1">
			<tr>
				<td><h3>ログイン</h3></td>
			</tr>
			<tr>
				<td>メールアドレス:<form:input path=email "/></td>
			</tr>
			<tr>
				<td>パスワード:<form:input path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="ログイン"></td>
			</tr>
			<tr>
				<td><a href="userRegister.html">新規登録はこちら</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>