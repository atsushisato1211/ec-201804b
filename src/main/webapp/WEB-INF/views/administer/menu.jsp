<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<header>
		<div id="userHeader" align="right">
			<p>こんにちは管理者さん</p>
			<p><a href="${pageContext.request.contextPath}/admin/logout">ログアウト</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="${pageContext.request.contextPath}/admin/menu"><img src="../img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div>
</header>


<div align ="center">
    <h2>管理者メニュー画面</h2>
        <a href="${pageContext.request.contextPath}/admin/viewItemInsert">商品を登録</a><br><br>
        <a href="${pageContext.request.contextPath}/admin/viewList">商品一覧</a><br><br>
        <a href="${pageContext.request.contextPath}/admin/orderList">注文一覧</a>
        <br>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/admin/logout">ログアウト</a>

</div>
    </body>
</body>
</html>