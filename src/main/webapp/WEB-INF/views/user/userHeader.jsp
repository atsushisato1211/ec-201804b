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
<header>
		<div id="userHeader" align="right">
			<p>こんにちは
			<sec:authorize access="hasRole('ROLE_MEMBER') and isAuthenticated()">
							<sec:authentication var="userName" property="principal.user.name" />
								<c:out value="${userName}" />&nbsp;さん
								</sec:authorize>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/show/">カートの中身を見る</a>
			</p>
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="${pageContext.request.contextPath}/item/"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
					height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
	</header>
</body>
</html>