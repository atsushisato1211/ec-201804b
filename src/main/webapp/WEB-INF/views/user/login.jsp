<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<span class="site"><h1>ECサイトラクス</h1></span>

<form:form modelAttribute="userLoginForm" action="${pageContext.request.contextPath}/login">
<span class="table">
<table>
<tr><td><h3>ログイン</h3></td></tr>
<tr><td>メールアドレス:<form:input path="email"/></td></tr>
<tr><td>パスワード:<form:input path="password"/></td></tr>
<tr><td><input type="submit" value="ログイン"></td></tr>
</table></span>
</form:form>

</body>
</html>