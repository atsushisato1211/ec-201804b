<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理者メニュー</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminHeader.css" />

</head>
<body>
<jsp:include page="adminHeader.jsp" />


<div align ="center">
    <h2>管理者メニュー画面</h2>
        <a href="${pageContext.request.contextPath}/admin/viewItemInsert">商品を登録</a><br><br>
        <a href="${pageContext.request.contextPath}/admin/viewList">商品一覧</a><br><br>
        <a href="${pageContext.request.contextPath}/admin/orderList">注文一覧</a><br><br>
        <sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
							<sec:authentication var="adminUserName" property="principal.adminUser.name" />
								
								
        <a href="${pageContext.request.contextPath}/admin/form">管理者新規登録</a><br><br>
        </sec:authorize>
        <a href="${pageContext.request.contextPath}/admin/logout">ログアウト</a>

</div>
    </body>
</body>
</html>