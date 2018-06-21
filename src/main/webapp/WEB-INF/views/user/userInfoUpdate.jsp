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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" />
<link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/ajaxzip3.js" charset="UTF-8"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script type="text/javascript">
function formReset(userInfoUpdateForm){ 
	document.userRegistrationForm.name.value = '';
	document.userRegistrationForm.email.value = '';	
	document.userRegistrationForm.zipCode1.value = '';	
	document.userRegistrationForm.zipCode2.value = '';	
	document.userRegistrationForm.address.value = '';	
	document.userRegistrationForm.telephone1.value = '';	
	document.userRegistrationForm.telephone2.value = '';	
	document.userRegistrationForm.telephone3.value = '';	
}
</script>
</head>
<body>
<jsp:include page="userHeader.jsp" />
		<div id="userHeader" align="right">
		</div>
		<div id="title" align="center">
		</div>

<div align="center">
<form:form modelAttribute="userInfoUpdateForm" name="userInfoUpdateForm" action="${pageContext.request.contextPath}/user/update" method="post">
<h2>登録者情報変更</h2><br>
<table>
<tr>
<td><label for="name">名前：</label></td></tr><tr><td><form:input path="name"/><br>
<form:errors path="name" cssStyle="color:red" element="div"/></td>
</tr>
<tr>
<td><label for="email">メールアドレス：</label></td></tr><tr><td><form:input path="email" placeholder="例：rakus@rakus.co.jp"/><br><form:errors path="email" cssStyle="color:red" element="div"/>
</td><tr>
<td><label for="zipCode1">郵便番号：</label></td></tr><tr><td><form:input path="zipCode1" maxlength="3" placeholder="例：123"/> - <form:input path="zipCode2" maxlength="4" placeholder="例：4567" onKeyUp="AjaxZip3.zip2addr('zipCode1','zipCode2','address','address')"/><br><form:errors path="zipCode1" cssStyle="color:red" element="div"/></td></tr>
<tr>
<td><label for="address">住所：</label></td></tr><tr><td><form:input path="address"/><br><form:errors path="address" cssStyle="color:red" element="div"/></td></tr>
<tr>
<td><label for="telephone1">電話番号：</label></td></tr><tr><td><form:input path="telephone1" maxlength="3" placeholder="2桁以上3桁以内"/> - <form:input path="telephone2" maxlength="4" placeholder="4桁"/> - <form:input path="telephone3" maxlength="4" placeholder="4桁"/><br><form:errors path="telephone1" cssStyle="color:red" element="div"/></td></tr>
</table>
<button type="submit" class="btn btn-warning">お客様情報を変更する</button>
<button type="button" class="btn btn-primary" onClick="formReset(userInfoUpdateForm)">クリア</button>

</form:form>
</div>

</body>
</html>