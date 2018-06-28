<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者ログイン画面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminUserLogin.css" />
</head>
<body>
<jsp:include page="adminHeader.jsp" />
	<div align="center">
		<h2>ログイン</h2>
		<form:errors path="adminUserLoginForm.*" cssStyle="color:red"
			element="div" />
		<form:form modelAttribute="adminUserLoginForm"
			action="${pageContext.request.contextPath}/admin/login">

			<form:errors path="email" cssStyle="color:red" element="div" />
			<label for="email"> メールアドレス：<form:input path="email" /></label>
			<form:errors path="password" cssStyle="color:red" element="div" />
			<label for="password">パスワード： <form:password path="password" /></label>

			<button type="submit" class="btn btn-info">ログイン</button>

		</form:form>
	</div>
</body>
</html>