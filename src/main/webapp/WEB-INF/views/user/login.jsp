<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<p>
				<a href="${pageContext.request.contextPath}">カートの中身を見る</a>
			</p>
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="itemList.html"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
					height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>

	<form:form modelAttribute="userLoginForm"
		action="${pageContext.request.contextPath}/login">
		<div align="center">
			<h3>ログイン</h3>
			<form:errors path="email" cssStyle="color:red" element="div" />
			メールアドレス:
			<form:input path="email" />
			<br>
			<form:errors path="password" cssStyle="color:red" element="div" />
			パスワード:
			<form:input path="password" />
			<br> <input type="submit" value="ログイン"><br> 
			<a href="${pageContext.request.contextPath}/">新規登録はこちら</a>
		</div>
	</form:form>

</body>
</html>