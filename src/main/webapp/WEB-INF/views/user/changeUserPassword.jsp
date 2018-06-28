<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>パスワード変更画面</title>
<%-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet"> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/testHeader.css" />
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" --%>
<%-- 	href="${pageContext.request.contextPath}/css/Registration.css" /> --%>
<link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v3.0.1/dist/bootstrap-float-label.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta charset="UTF-8">
</head>
<body  background="${pageContext.request.contextPath}/img/wall.gif">
	<jsp:include page="testHeader2.jsp" />
	<h2 class="item"></h2>
	<br>
	<div align="center">
		<br>
		<h2>パスワード変更画面</h2>
		<form:form modelAttribute="changeUserPasswordForm"
			name="changeUserPasswordForm"
			action="${pageContext.request.contextPath}/user/change">
			<table>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><span class="form-group has-float-label"><form:password
								path="password" placeholder="8文字以上16文字以内" class="form-control" />
							<label for="password">現在のパスワード</label></span> <form:errors
							path="password" cssStyle="color:red" element="div" /></td>
				</tr>
				<tr>
					<td><span class="form-group has-float-label"><form:password
								path="newPassword" placeholder="8文字以上16文字以内"
								class="form-control" /> <label for="newPassword">新しいパスワード</label></span>
						<form:errors path="newPassword" cssStyle="color:red" element="div" /></td>
				</tr>
				<tr>
					<td><span class="form-group has-float-label"><form:password
								path="newConfirmationPassword" placeholder="8文字以上16文字以内"
								class="form-control" /> <label for="newConfirmationPassword">確認用パスワード</label></span>
						<form:errors path="newConfirmationPassword" cssStyle="color:red"
							element="div" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><button type="submit"
							class="btn btn-warning">パスワードを変更する</button></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="button"
							class="btn btn-primary" onClick="formReset(userInfoUpdateForm)">クリア</button></td>
				</tr>
			</table>
		</form:form>

	</div>

</body>
</html>