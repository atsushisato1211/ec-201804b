<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body><header>
		<div id="userHeader" align="right">
			
			<sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
							<sec:authentication var="adminUserName" property="principal.adminUser.name" />
								<p>こんにちは<c:out value="${adminUserName}" />&nbsp;さん</p>
								<p><a href="${pageContext.request.contextPath}/admin/logout">ログアウト</a></p>
								</sec:authorize>
								<sec:authorize access="!(hasRole('ROLE_ADMIN') and isAuthenticated())">
								<p>こんにちは管理者さん</p>
								<p><a href="${pageContext.request.contextPath}/admin/index">ログイン</a></p>
								</sec:authorize>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="${pageContext.request.contextPath}/admin/menu"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center"></div>
		</div>
</header>
</html>