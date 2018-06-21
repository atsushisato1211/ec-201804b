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
								<p><a href="${pageContext.request.contextPath}/user/logout">ログアウト</a></p>
								</sec:authorize>
			<sec:authorize access="!(hasRole('ROLE_MEMBER') and isAuthenticated())">
								ゲスト&nbsp;さん</p>
								<p><a href="${pageContext.request.contextPath}/user/index">ログイン</a></p>
								
								</sec:authorize>
			<p>
				<a href="${pageContext.request.contextPath}/user/show">カートの中身を見る</a>
			</p>
		</div>
		<div id="linkHeader" align="left">
			<h1 align="left">
				<a href="${pageContext.request.contextPath}/user/item"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
					height="50" alt="ロゴ画像">ＥＣサイトラクス</a>
			</h1>
			<div id="title" align="center"></div>
		</div>
			<ul class="nav">
<li><a href="${pageContext.request.contextPath}/user/item">Home</a>
</li>
<li><a href="#">頭文字検索</a>
<ul>
<li><a href="#">あ</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="あ"/>">あ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="い"/>">い</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="う"/>">う</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="え"/>">え</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="お"/>">お</a></li>
</ul></li>
<li><a href="#">か</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="か"/>">か</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="き"/>">き</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="く"/>">く</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="け"/>">け</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="こ"/>">こ</a></li>
</ul></li>
<li><a href="#">さ</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="さ"/>">さ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="し"/>">し</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="す"/>">す</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="せ"/>">せ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="そ"/>">そ</a></li>
</ul></li>
<li><a href="#">た</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="た"/>">た</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ち"/>">ち</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="つ"/>">つ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="て"/>">て</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="と"/>">と</a></li>
</ul></li>
<li><a href="#">な</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="な"/>">な</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="に"/>">に</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ぬ"/>">ぬ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ね"/>">ね</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="の"/>">の</a></li>
</ul></li>
<li><a href="#">は</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="は"/>">は</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ひ"/>">ひ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ふ"/>">ふ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="へ"/>">へ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ほ"/>">ほ</a></li>
</ul></li>
<li><a href="#">ま</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ま"/>">ま</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="み"/>">み</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="む"/>">む</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="め"/>">め</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="も"/>">も</a></li>
</ul></li>
<li><a href="#">や</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="や"/>">や</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ゆ"/>">ゆ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="よ"/>">よ</a></li>
</ul></li>
<li><a href="#">ら</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ら"/>">ら</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="り"/>">り</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="る"/>">る</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="れ"/>">れ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ろ"/>">ろ</a></li>
</ul></li>
<li><a href="#">わ</a><ul>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="わ"/>">わ</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="を"/>">を</a></li>
<li><a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ん"/>">ん</a></li>
</ul></li>

</ul>
</li>
<li><a href="#">Sort</a>
<ul>
<li><a href="#">名前</a>
<ul>
<li><a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=name&sortOption=ASC">昇順</a></li>
<li><a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=name&sortOption=DESC">降順</a></li>
</ul>
</li>
<li><a href="#">価格</a>
<ul>
<li><a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=price&sortOption=ASC">安い順</a></li>
<li><a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=price&sortOption=DESC">高い順</a></li>
</ul>
</li>
<li><a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=&itemSort=name&sortOption=ASC">検索リセット</a></li>
</ul>
</li>
<li><a href="#">Cart</a>
<ul>
<li><a href="${pageContext.request.contextPath}/user/show">カートの中身を見る</a></li>
<li><a href="#">d1</a>
<ul>
<li><a href="#">d2</a></li>
<li><a href="#">d2</a>
<ul class="left">
<li><a href="#">d3</a></li>
<li><a href="#">d3</a></li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<sec:authorize access="hasRole('ROLE_MEMBER') and isAuthenticated()">
							<sec:authentication var="userName" property="principal.user.name" />
<li><a href="${pageContext.request.contextPath}/user/logout">ログアウト</a>
</li></sec:authorize>
<sec:authorize access="!(hasRole('ROLE_MEMBER') and isAuthenticated())">
<li><a href="${pageContext.request.contextPath}/user/index">ログイン</a>
</li>
</sec:authorize>

<!--nav--></ul>
	</header>
</body>
</html>