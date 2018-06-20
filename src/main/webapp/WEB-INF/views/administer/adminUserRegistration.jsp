<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>管理者メニュー</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" /></head>
<script type="text/javascript">
function formReset(adminUserRegistrationForm){ 
	document.adminUserRegistrationForm.name.value = '';
	document.adminUserRegistrationForm.email.value = '';	
}
</script>
<body>
<header>
		<div id="userHeader" align="right">
			<p>こんにちは管理者さん</p>
			<p><a href="administerLogin.html">ログアウト</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="${pageContext.request.contextPath}/menu/"><img src="../img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div>
</header>
<form:form modelAttribute="adminUserRegistrationForm" action="${pageContext.request.contextPath}/adminregistration/create" method="post" name="adminUserRegistrationForm">
<h2>管理者登録</h2><br>
<table>
<tr><form:errors path="name" cssStyle="color:red" element="div"/>
<td>名前：</td><td><form:input path="name"/></td></tr>
<tr><form:errors path="email" cssStyle="color:red" element="div"/>
<td>メールアドレス：</td><td><form:input path="email"/></td><tr>
<tr><form:errors path="password" cssStyle="color:red" element="div"/>
<td>パスワード：</td><td><form:password path="password"/></td></tr>
<tr><form:errors path="confirmationpassword" cssStyle="color:red" element="div"/>
<td>確認用パスワード：</td><td><form:password path="confirmationpassword"/></td></tr>
</table>
<button type="submit" class="btn btn-warning">登録する</button>
<button type="button" class="btn btn-primary" onClick='formReset(adminUserRegistrationForm)'>クリア</button>
<!-- <input type="submit" value="登録する"/> -->
<!--<input type="reset" value="クリア"/>-->
</form:form>
</body>
</html>