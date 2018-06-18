<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="userRegistrationForm" action="${pageContext.request.contextPath}/registration/form" method="post">
<h2>利用者登録</h2><br>
名前：<form:input path="name"/><br>
メールアドレス：<form:input path="email"/><br>
パスワード：<form:input path="password"/><br>
確認用パスワード：<form:input path="confirmationpassword"/><br>
郵便番号：<form:input path="zipCode"/><br>
住所：<form:input path="address"/><br>
電話番号：<form:input path="telephone1"/> - <form:input path="telephone2"/> - <form:input path="telephone3"/><br>
<input type="submit" value="登録する"/><input type="reset" value="クリア"/>
</form:form>
</body>
</html>