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
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ecHeader.css" />
<link href="${pageContext.request.contextPath}/css/test.css"
	rel="stylesheet">
<meta charset="UTF-8">
</head>
<body>
	<jsp:include page="userHeader.jsp" />

	<div align="center">
		<h2>パスワード変更画面</h2>

		<form:form modelAttribute="changeUserPasswordForm"
			action="${pageContext.request.contextPath}/user/change">
			<table>
				<tr>
					<form:errors path="password" cssStyle="color:red" element="div" />
					<td>現在のパスワード:<form:password path="password" /></td>
				</tr>
				<tr>
					<form:errors path="newPassword" cssStyle="color:red" element="div" />
					<td>新しいパスワード:<form:password path="newPassword" /></td>
				</tr>
				<tr>
					<form:errors path="newConfirmationPassword" cssStyle="color:red" element="div" />
					<td>新しいパスワードの確認:<form:password path="newConfirmationPassword" /></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-warning">パスワードを変更する</button></td>
				</tr>
				<tr>
					<td><button type="button" class="btn btn-primary"
							onClick="formReset(userInfoUpdateForm)">クリア</button></td>
				</tr>
			</table>
		</form:form>

	</div>

</body>
</html>