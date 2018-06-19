<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ecHeader.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/ajaxzip3.js" charset="UTF-8"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
</head>
<body>
<header>
		<div id="userHeader" align="right">
			<p>こんにちはゲストさん</p>
			<p><a href="${pageContext.request.contextPath}/index">ログイン</a></p>
			<p><a href="${pageContext.request.contextPath}/show">カートの中身を見る</a></p>
		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="${pageContext.request.contextPath}/item/"><img src="${pageContext.request.contextPath}/img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div>
</header>
<form:form modelAttribute="userRegistrationForm" action="${pageContext.request.contextPath}/registration/create" method="post">
<h2>利用者登録</h2><br>
<form:errors path="name" cssStyle="color:red" element="div"/>
名前：<form:input path="name"/><br>
<form:errors path="email" cssStyle="color:red" element="div"/>
メールアドレス：<form:input path="email"/><br>
<form:errors path="password" cssStyle="color:red" element="div"/>
パスワード：<form:password path="password"/><br>
<form:errors path="confirmationpassword" cssStyle="color:red" element="div"/>
確認用パスワード：<form:password path="confirmationpassword"/><br>
<form:errors path="zipCode1" cssStyle="color:red" element="div"/>
<form:errors path="zipCode2" cssStyle="color:red" element="div"/>
郵便番号：<form:input path="zipCode1" maxlength="3"/> - <form:input path="zipCode2" maxlength="4" onKeyUp="AjaxZip3.zip2addr('zipCode1','zipCode2','address','address')"/><br>
<form:errors path="address" cssStyle="color:red" element="div"/>
住所：<form:input path="address"/><br>
<form:errors path="telephone1" cssStyle="color:red" element="div"/>
<form:errors path="telephone2" cssStyle="color:red" element="div"/>
<form:errors path="telephone3" cssStyle="color:red" element="div"/>
電話番号：<form:input path="telephone1" maxlength="3"/> - <form:input path="telephone2" maxlength="4"/> - <form:input path="telephone3" maxlength="4"/><br>
<input type="submit" value="登録する"/><input type="reset" value="クリア"/>
</form:form>
</body>
</html>