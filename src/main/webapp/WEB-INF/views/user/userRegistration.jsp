<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
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
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1></div>
		<div id="title" align="center">
		</div>
</header>
<div align="center">
<form:form modelAttribute="userRegistrationForm" action="${pageContext.request.contextPath}/registration/create" method="post">
<h2>利用者登録</h2><br>
<table>
<tr><form:errors path="name" cssStyle="color:red" element="div"/>

<td><label for="name">名前：</label></td><td><form:input path="name"/></td></tr>

<tr><form:errors path="email" cssStyle="color:red" element="div"/>
<td><label for="email">メールアドレス：</label></td><td><form:input path="email"/></td><tr>
<tr><form:errors path="password" cssStyle="color:red" element="div"/>
<td><label for="password">パスワード：</label></td><td><form:password path="password"/></td></tr>
<tr><form:errors path="confirmationpassword" cssStyle="color:red" element="div"/>
<td><label for="confirmationpassword">確認用パスワード：</label></td><td><form:password path="confirmationpassword"/></td></tr>
<tr><form:errors path="zipCode1" cssStyle="color:red" element="div"/>
<td><label for="zipCode1">郵便番号：</label></td><td><form:input path="zipCode1" maxlength="3"/> - <form:input path="zipCode2" maxlength="4" onKeyUp="AjaxZip3.zip2addr('zipCode1','zipCode2','address','address')"/></td></tr>
<tr><form:errors path="address" cssStyle="color:red" element="div"/>
<td><label for="address">住所：</label></td><td><form:input path="address"/></td></tr>
<tr><form:errors path="telephone1" cssStyle="color:red" element="div"/>
<td><label for="telephone1">電話番号：</label></td><td><form:input path="telephone1" maxlength="3"/> - <form:input path="telephone2" maxlength="4"/> - <form:input path="telephone3" maxlength="4"/></td></tr>
</table>
<button type="submit" class="btn btn-warning">登録する</button>
<button type="reset" class="btn btn-primary">クリア</button>
<!-- <input type="submit" value="登録する"/> -->
<!--<input type="reset" value="クリア"/>-->
</form:form>
</div>
</body>
</html>