<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>パスワードを忘れたお客様</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/body.css"
	rel="stylesheet">
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ecHeader.css" />
<link href="${pageContext.request.contextPath}/css/test.css"
	rel="stylesheet"> --%>
</head>
<body background="${pageContext.request.contextPath}/img/wall.gif">
	<jsp:include page="testHeader2.jsp" />
	<form:form modelAttribute="userPasswordForgetForm"
		action="${pageContext.request.contextPath}/user/checkpassword">
		<div align="center">
			<br> <br>
			<h2 class="item">パスワードを忘れたお客様</h2>
			<table>
			
				<tr>
					<form:errors path="email" cssStyle="color:red" element="div" />
					<td><label for="email">メールアドレス:</label></td>
					<td><form:input path="email" placeholder="メールアドレス"/></td>
				</tr>

				<tr>
					<form:errors path="question" cssStyle="color:red" element="div" />
					<td><label for="question">親の旧姓:</label></td>
					<td><form:input path="question" placeholder="親の旧姓"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit"
							class="btn btn-warning">送る</button></td>
				</tr>
			</table>

		</div>
	</form:form>


</body>
</html>