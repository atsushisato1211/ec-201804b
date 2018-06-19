<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header>
		<div id="userHeader" align="right">
			<p>こんにちは管理者さん</p>
			

		</div>
				<div id="linkHeader" align="left">
			<h1 align ="left"><a href="../user/itemList.html"><img src="../img/rakus.jpg" width="50"
				height="50" alt="ロゴ画像">ＥＣサイトラクス</a></h1>
		<div id="title" align="center">
		</div>
</header>


<div align="center">
  <h2>ログイン</h2>
  
 <font color="#ff0000">・入力情報は不正です</FONT><BR>
  
  <form action="administerMenu.html" method="post">
    メールアドレス：<input type="text" name="email"><br>
    パスワード： <input type="password" name="password"><br>
    <input type="submit" value="ログイン">
  </form>
</div>


</body>
</html>