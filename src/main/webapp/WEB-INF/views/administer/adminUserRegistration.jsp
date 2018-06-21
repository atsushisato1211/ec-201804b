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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminHeader.css" />
<link rel="stylesheet" href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v3.0.1/dist/bootstrap-float-label.min.css"/>
</head>
<script type="text/javascript">
function formReset(adminUserRegistrationForm){ 
	document.adminUserRegistrationForm.name.value = '';
	document.adminUserRegistrationForm.email.value = '';	
}
</script>
<body>

<jsp:include page="adminHeader.jsp" />

<div align="center">
<form:form modelAttribute="adminUserRegistrationForm" action="${pageContext.request.contextPath}/admin/create" method="post" name="adminUserRegistrationForm">
<h2>管理者登録</h2><br>

<table>
<tr><td><span class="form-group has-float-label"><form:input path="name" class="form-control" placeholder="例：山田太郎"/><label for="name">名前</label></span><br><form:errors path="name" cssStyle="color:red" element="div"/></td></tr>
<tr>
<td></td></tr><tr><td><span class="form-group has-float-label"><form:input path="email" class="form-control" placeholder="例：rakus@rakus.co.jp"/><label for="email">メールアドレス</label></span><br><form:errors path="email" cssStyle="color:red" element="div"/></td><tr>
<tr><td><span class="form-group has-float-label"><form:password path="password" class="form-control" placeholder="8文字以上16文字以内"/><label for="password">パスワード</label></span><br><form:errors path="password" cssStyle="color:red" element="div"/></td></tr>
<tr><td><span class="form-group has-float-label"><form:password path="confirmationpassword" class="form-control" placeholder="8文字以上16文字以内"/><label for="confirmationpassword">確認用パスワード</label></span><br><form:errors path="confirmationpassword" cssStyle="color:red" element="div"/></td></tr>
</table>
<button type="submit" class="btn btn-warning">管理者情報を登録する</button>
<button type="button" class="btn btn-primary" onClick='formReset(adminUserRegistrationForm)'>クリア</button>
<!-- <input type="submit" value="登録する"/> -->
<!--<input type="reset" value="クリア"/>-->
</form:form>
</div>
</body>
</html>