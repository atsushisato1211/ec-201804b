<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>パスワード再発行</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testHeader.css" />
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="userHeader.jsp" />
	<br>
	<form:form modelAttribute="userNewPasswordForm" action="${pageContext.request.contextPath}/user/postpass">
		<div align="center">
		<br>
			<h2>パスワード再発行</h2>
			<table>
				<tr>
					<form:errors path="newPassword" cssStyle="color:red" element="div" />
					<td><label for="newPassword">新しいパスワード:</label></td>
					<td><form:password path="newPassword" /></td>
				</tr>
				<tr>
					<form:errors path="" cssStyle="color:red" element="div" />
					<td><label for="confirmationNewPassword">確認用パスワード:</label></td>
					<td><form:password
					 path="confirmationNewPassword" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit"
							class="btn btn-info">申し込む</button></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>