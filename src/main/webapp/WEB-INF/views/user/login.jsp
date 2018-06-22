<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン画面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css">
</head>
<body>
	<header>
		<div id="userHeader" align="right">
			
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="${pageContext.request.contextPath}/user/item"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50" 
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>
	
	<div align="center">
	<h3>ログイン</h3>
	<form:errors path="userLoginForm.*" cssStyle="color:red" element="div"/>
	<form:form modelAttribute="userLoginForm"
		action="${pageContext.request.contextPath}/user/login" class="form-horizontal">
		
	<table ><tr><form:errors path="email" cssStyle="color:red" element="div" />
		<td><label for="email">メールアドレス:</label></td>
		<td><form:input path="email"/></td></tr>
			
			<tr><form:errors path="password" cssStyle="color:red" element="div" />
			<td><label for="password">パスワード:</label></td>
		<td><form:password path="password" /></td></tr>
			<tr><td colspan="2" align="center"><button type="submit" class="btn btn-info">ログイン</button></td></tr> 
			<tr><td><br></td></tr>
			<tr><td colspan="2" align="center"><a href="${pageContext.request.contextPath}/user/form">新規登録はこちら</a></td></tr>
			<tr><td><br></td></tr>
			<tr><td colspan="2" align="center"><a href="${pageContext.request.contextPath}/user/forget">パスワードを忘れた方はこちら</a></td></tr>
	</table>
	
	</form:form>
	</div>
</body>
</html>