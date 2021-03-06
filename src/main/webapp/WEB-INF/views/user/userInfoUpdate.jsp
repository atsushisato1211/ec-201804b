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
<%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" /> --%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Registration.css"/>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testHeader.css" />
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet"> --%>
<link rel="stylesheet" href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v3.0.1/dist/bootstrap-float-label.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script type="text/javascript">
function formReset(userInfoUpdateForm){ 
	document.userInfoUpdateForm.name.value = '';
	document.userInfoUpdateForm.email.value = '';	
	document.userInfoUpdateForm.zipCode1.value = '';	
	document.userInfoUpdateForm.zipCode2.value = '';	
	document.userInfoUpdateForm.address.value = '';	
	document.userInfoUpdateForm.telephone1.value = '';	
	document.userInfoUpdateForm.telephone2.value = '';	
	document.userInfoUpdateForm.telephone3.value = '';	
}
</script>
</head>
<body  background="${pageContext.request.contextPath}/img/wall.gif">
<jsp:include page="testHeader2.jsp" />
		<div id="userHeader" align="right">
		</div>
		<div id="title" align="center">
		</div>

<div align="center">
<form:form modelAttribute="userInfoUpdateForm" name="userInfoUpdateForm" action="${pageContext.request.contextPath}/user/update" method="post">
<h2>登録者情報変更</h2><br>
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
<label class="text-size" for="telephone2">電話番号3</label></span>
<form:errors path="telephone1" cssStyle="color:red" element="div"/>
</td>
</tr>
</table>
<button type="submit" class="btn btn-warning">お客様情報を変更する</button>
<button type="button" class="btn btn-primary" onClick="formReset(userInfoUpdateForm)">クリア</button>

</form:form>
</div>

</body>
</html>