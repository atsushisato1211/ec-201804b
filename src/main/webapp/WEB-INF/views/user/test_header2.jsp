<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/css2/bootstrap.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/css2/bootstrap.min.css" rel="stylesheet"> --%>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/npm.js"></script>
</head>
<body>
<nav class="navbar navbar-default ">
  <div class="container-fluid">
<!--   ヘッダー部分 ================ -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bootstap</a>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav_target">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
  <!-- 中央のナビゲーション部分 ================ -->
    <div class="collapse navbar-collapse" id="nav_target">
      <ul class="nav navbar-nav">
    <!--     リンクのみ -->
          <li class="active"><a href="#">Nav 1</a></li>
          <li><a href="#">Nav 2</a></li>
        <!-- Nav3 ドロップダウン -->  
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nav3 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">link 1</a></li>
              <li><a href="#">link 2</a></li>
              <li class="divider"></li>
              <li><a href="#">link3</a></li>
            </ul>
          </li>
        <!-- Nav4 ドロップダウン -->
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nav4 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">link 1</a></li>
              <li><a href="#">link 2</a></li>
              <li class="divider"></li>
              <li><a href="#">link3</a></li>
            </ul>
          </li>
      </ul>
  <!-- 右寄せになる部分 ================ -->
      <ul class="nav navbar-nav navbar-right">
    <!--     リンクのみ -->
          <li><a href="#">Nav 5</a></li>
        <!-- Nav6 ドロップダウン -->
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nav6 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">link 1</a></li>
              <li><a href="#">link 2</a></li>
              <li class="divider"></li>
              <li><a href="#">link3</a></li>
            </ul>
          </li>
      </ul>
    </div>
  </div>
</nav> 


<!-- navigation -->
<!-- <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    
  ヘッダー部分 ================
    <div class="navbar-header">
      <a href="./" class="navbar-brand">Bootstrap <span style="font-size: 70%;">私的リファレンス</span></a>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navBootstrap">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
  中央のナビゲーション部分 ================
    <div class="collapse navbar-collapse" id="navBootstrap">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="fontDecoration">装飾<span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="fontDecoration">
            <li><a href="fontDecoration01.html">文字色を変更する</a></li>
            <li><a href="fontDecoration02.html">背景色を変更する</a></li>
            <li><a href="fontDecoration03.html">文字を右/中央/左に寄せる</a></li>
            <li><a href="fontDecoration04.html">blockquote</a></li>
            <li><a href="fontDecoration05.html">ワンポイントに良さそうなラベルを作る</a></li>
            <li><a href="fontDecoration06.html">サイドバーのメニューに良さそうなリストを作る</a></li>
            <li><a href="fontDecoration07.html">枠を付けて強調する</a></li>
            
            <li><a href="buttonDecoration01.html">ボタンを作る</a></li>
            <li><a href="buttonDecoration02.html">ボタンの大きさを変更する</a></li>
            <li><a href="ImageDecoration01.html">モバイル端末で画像を自動で縮小する</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="VisualDecoration">表現・効果<span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="VisualDecoration">
            <li><a href="VisualDecoration01.html">ナビゲーションを作る</a></li>
            <li><a href="VisualDecoration02.html">ページャーボタンを作る</a></li>
            <li><a href="VisualDecoration03.html">ヒントを表示するツールチップを付ける</a></li>
            <li><a href="VisualDecoration04.html">プログレスバーを作る</a></li>
            <li><a href="VisualDecoration05.html">上から降りてくるダイアログを作る</a></li>
            <li><a href="VisualDecoration06.html">付属のWEBフォントアイコンを使う</a></li>
            <li><a href="VisualDecoration07.html">サブメニューに使えそうなドロップダウン</a></li>
            <li><a href="VisualDecoration08.html">Youtube動画などを配置する</a></li>
            <li><a href="VisualDecoration09.html">スライドショーを作る</a></li>
            <li><a href="VisualDecoration10.html">タブパネル</a></li>
            
          </ul>
        </li>
        
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="tableDecoration">表組<span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="tableDecoration">
            <li><a href="tableDecoration01.html">表を作る</a></li>
            <li><a href="tableDecoration02.html">1行ごとに色を変える</a></li>
            <li><a href="tableDecoration03.html">マウスオーバー効果を付ける</a></li>
            <li><a href="tableDecoration04.html">カラムごとに背景色を変更する</a></li>
            <li><a href="tableDecoration05.html">横長の表のモバイル端末における処理</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="glidDecoration">グリッドシステム<span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="glidDecoration">
            <li><a href="glidDecoration01.html">グリッドシステムの考え方</a></li>
            <li><a href="glidDecoration02.html">グリッドシステムの発動タイミング</a></li>
            <li><a href="glidDecoration03.html">デバイスに応じて表示・非表示を指定する</a></li>
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="formDecoration">フォーム<span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="formDecoration">
            <li><a href="formDecoration01.html">フォームを作る</a></li>
            <li><a href="formDecoration02.html">インラインで表示する</a></li>
            <li><a href="formDecoration03.html">ラジオボタン・チェックボックス</a></li>
            <li><a href="formDecoration04.html">セレクトボックス</a></li>
            <li><a href="formDecoration05.html">フォームに色を付ける</a></li>
            <li><a href="formDecoration06.html">Validation Engineが使えるか試してみる</a></li>
            <li><a href="formDecoration07.html">グリッドシステムを使ったより現実的なフォーム</a></li>
          </ul>
        </li>
        
        <li>
          <a href="Private.html" id="formDecoration">私的見解</a>
        </li>
        
        
        
        
      </ul>
      
  右寄せになる部分 ================
      <ul class="nav navbar-nav navbar-right">
        リンクのみ
        <li><a href="http://studio-key.com" target="_blank"><span class="glyphicon glyphicon-home"></span></a></li>
        <li><a href="https://www.studio-key.jp/Contact-us.html" target="_blank"><span class="glyphicon glyphicon-envelope"></span></a></li>
      </ul>
      
    </div>
  </div>
</nav>/navigation
 -->
</body>
</html>