<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css">
</head>
<body>
	<header>
		<div id="userHeader" align="right">
			<p>
				<a href="${pageContext.request.contextPath}/show/">カートの中身を見る</a>
			</p>
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="${pageContext.request.contextPath}/item/"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
					height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>
	<div align="center">
	<h3>ログイン</h3>
	<form:errors path="userLoginForm.*" cssStyle="color:red" element="div"/>
	<form:form modelAttribute="userLoginForm"
		action="${pageContext.request.contextPath}/login">
			<form:errors path="email" cssStyle="color:red" element="div" />
			メールアドレス:
			<form:input path="email" />
			<br>
			<form:errors path="password" cssStyle="color:red" element="div" />
			パスワード:<form:password path="password" />
			<br> 
			<!-- <input type="submit" value="ログイン"> -->
			<button type="button" class="btn btn-info">ログイン</button><br> 
			<a href="${pageContext.request.contextPath}/registration/form">新規登録はこちら</a>
	</form:form>
	</div>
</body>
</html>