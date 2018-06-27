<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>利用者登録フォーム</title>
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" /> --%>
<link rel="stylesheet" href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v3.0.1/dist/bootstrap-float-label.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script type="text/javascript">
function formReset(userRegistrationForm){ 
	document.userRegistrationForm.name.value = '';
	document.userRegistrationForm.email.value = '';	
	document.userRegistrationForm.password.value = '';	
	document.userRegistrationForm.confirmationpassword.value = '';	
	document.userRegistrationForm.zipCode1.value = '';	
	document.userRegistrationForm.zipCode2.value = '';	
	document.userRegistrationForm.address.value = '';	
	document.userRegistrationForm.telephone1.value = '';	
	document.userRegistrationForm.telephone2.value = '';	
	document.userRegistrationForm.telephone3.value = '';
	document.userRegistrationForm.question.value = '';
	
}
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Registration.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testHeader.css" />
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
</head>
<body>
<jsp:include page="testHeader.jsp" />
<div align="center">
<form:form modelAttribute="userRegistrationForm" name="userRegistrationForm" action="${pageContext.request.contextPath}/user/create" method="post">
<h2>利用者登録</h2><br>
<table>
<tr>
<td>
<span class="form-group has-float-label"><form:input path="name" class="form-control" placeholder="例：山田太郎" />
<label for="name">名前</label></span>
<form:errors path="name" cssStyle="color:red" element="div"/>
</td>
</tr>
<tr>
<td>
<span class="form-group has-float-label"><form:input path="email" placeholder="例：rakus@rakus.co.jp" class="form-control"/>
<label for="email">メールアドレス</label></span>
<form:errors path="email" cssStyle="color:red" element="div"/>
</td>
</tr>
<tr>
<td>
<span class="form-group has-float-label"><form:password path="password" placeholder="8文字以上16文字以内" class="form-control" />
<label for="password">パスワード</label></span>
<form:errors path="password" cssStyle="color:red" element="div"/></td></tr>
<tr>
<td>
<span class="form-group has-float-label"><form:password path="confirmationpassword" placeholder="8文字以上16文字以内" class="form-control"/>
<label for="confirmationpassword">確認用パスワード</label></span>
<form:errors path="confirmationpassword" cssStyle="color:red" element="div"/></td></tr>
<tr>
<td>
<span class="form-group has-float-label inline-block-element"><form:input path="zipCode1" maxlength="3" placeholder="例：123" class="form-control form-size"/>
<label class="text-size" for="zipCode1">郵便番号上3桁</label></span>-
<span class="form-group has-float-label inline-block-element"><form:input path="zipCode2" maxlength="4" placeholder="例：4567" class="form-control form-size" onKeyUp="AjaxZip3.zip2addr('zipCode1','zipCode2','address','address')"/>
<label class="text-size" for="zipCode2">郵便番号下4桁</label></span>
<form:errors path="zipCode1" cssStyle="color:red" element="div"/>
</td>
</tr>
<tr>
<td>
<span class="form-group has-float-label "><form:input path="address" placeholder="例：〇〇県〇〇市〇〇区" class="form-control"/>
<label for="address">住所</label></span>
<form:errors path="address" cssStyle="color:red" element="div"/>
</td>
</tr>
<tr>
<td>
<span class="form-group has-float-label inline-block-element"><form:input path="telephone1" maxlength="3" placeholder="例：090または03" class="form-control"/>
<label class="text-size" for="telephone1">電話番号1</label></span>-
<span class="form-group has-float-label inline-block-element"><form:input path="telephone2" maxlength="4" placeholder="例:1234" class="form-control"/>
<label class="text-size" for="telephone2">電話番号2</label></span>-
<span class="form-group has-float-label inline-block-element"><form:input path="telephone3" maxlength="4" placeholder="例：5678" class="form-control"/>
<label class="text-size" for="telephone3">電話番号3</label></span>
<form:errors path="telephone1" cssStyle="color:red" element="div"/>
</td>
</tr>
<tr>
<td>
<span class="form-group has-float-label text-size"><form:input path="question" placeholder="解答を入力して下さい" class="form-control"/>
<label for="question">親の旧姓は？</label></span>
<form:errors path="question" cssStyle="color:red" element="div"/>
</td>
</tr>
</table>
<button type="submit" class="btn btn-warning">お客様情報を登録する</button>
<button type="button" class="btn btn-primary" onClick="formReset(userRegistrationForm)">クリア</button>

</form:form>
</div>
</body>
</html>