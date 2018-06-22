<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>パスワードを忘れた方</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ecHeader.css" />
<link href="${pageContext.request.contextPath}/css/test.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="userHeader.jsp" />
	<form:form modelAttribute="userPasswordForm"
		action="${pageContext.request.contextPath}/user/checkpassword">
		<div align="center">
			<table>
				<tr>
					<form:errors path="email" cssStyle="color:red" element="div" />
					<td><label for="email">Email</label></td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<form:errors path="question" cssStyle="color:red" element="div" />
					<td><label for="question">親の旧姓を入力してください</label></td>
					<td><form:input path="question" /></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-warning">送る</button></td>
				</tr>
			</table>

		</div>
	</form:form>


</body>
</html>