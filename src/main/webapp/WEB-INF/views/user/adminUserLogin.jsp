<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者ログイン画面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" type="text/css"　href="${pageContext.request.contextPath}/css/adminUserLogin.css" />
</head>
<body>
	<header>
		<div id="userHeader" align="right"></div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="../user/itemList.html"><img src="../img/rakus.jpg"
					width="50" height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>


		<form:form modelAttribute="adminUserLoginForm" action="${pageContext.request.contextPath}/admin/login">
	<div align="center">
		<h2>ログイン</h2>
			<form:errors path="email" cssStyle="color:red" element="div" />
					<label for="email">
					メールアドレス：<form:input path="email" /></label>
			<form:errors path="password" cssStyle="color:red" element="div" />
			<label for="password">パスワード： <form:input path="password" /></label>
			
			<button type="submit" class="btn btn-info">ログイン</button>
		
	</div>
		</form:form>	
</body>
</html>