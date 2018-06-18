<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>


<h1>ECサイトラクス</h1>

<form:form modelAttribute="userLoginForm" action="${pageContext.request.contextPath}/login">
<table class = "t1">
<tr><td><h3>ログイン</h3></td></tr>
<tr><td>メールアドレス:<form:input path="email"/></td></tr>
<tr><td>パスワード:<form:input path="password"/></td></tr>
<tr><td><input type="submit" value="ログイン"></td></tr>
</table>
</form:form>

</body>
</html>