<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>お問い合わせフォーム</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/imgslide.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/itemList.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/item_table.css" rel="stylesheet">
<%-- <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ecHeader.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/testHeader.css" />
</head>
<body>
	<jsp:include page="testHeader.jsp" />
	<p><br></p>
	<br>
	<form:form modelAttribute="userContactForm" action="${pageContext.request.contextPath}/user/contact">
	<div align ="center">
	<table>
	<tr><form:errors path="name" cssStyle="color:red" element="div" />
	<td>タイトル:</td>
	<td><form:input path="name"/></td>
	</tr>
	<tr>
	<td>問い合わせ内容:</td>
	<form:errors path="content" cssStyle="color:red" element="div" />
	<td><textarea name="content" cols="100" rows="10"></textarea></td>
	</tr>
	<tr><td colspan="2" align="center"><button type="submit" class="btn btn-info">送信</button></td></tr>
	</table>
	</div>
	</form:form>
	
</body>
</html>