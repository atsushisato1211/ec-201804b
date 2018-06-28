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
 <link href="${pageContext.request.contextPath}/css/css2/bootstrap.css" rel="stylesheet">
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css2/bootstrap-theme.min.css">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>

<!-- navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    
  <!-- ヘッダー部分 ================ -->
    <div class="navbar-header">
     <a class="header_img" href="${pageContext.request.contextPath}/user/item"><img class="head"
						src="<%=request.getContextPath()%>/img/link.png" width="140" height="60"/></a>
     <!--  <a href="./" class="navbar-brand">Bootstrap <span style="font-size: 70%;">私的リファレンス</span></a> -->
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navBootstrap">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
  <!-- 中央のナビゲーション部分 ================ -->
    <div class="collapse navbar-collapse" id="navBootstrap">
      <ul class="nav navbar-nav">
        
         <li><a href="${pageContext.request.contextPath}/user/item">HOME</a></li>
        
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="VisualDecoration">頭文字検索<span class="caret"></span></a>
          <ul class="dropdown-menu" aria-labelledby="VisualDecoration">
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">あ</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="あ"/>">あ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="い"/>">い</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="う"/>">う</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="え"/>">え</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="お"/>">お</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">か</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="か"/>">か</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="き"/>">き</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="く"/>">く</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="け"/>">け</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="こ"/>">こ</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">さ</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="さ"/>">さ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="し"/>">し</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="す"/>">す</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="せ"/>">せ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="そ"/>">そ</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">た</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="た"/>">た</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ち"/>">ち</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="つ"/>">つ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="て"/>">て</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="と"/>">と</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">な</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="な"/>">な</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="に"/>">に</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ぬ"/>">ぬ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ね"/>">ね</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="の"/>">の</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">は</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="は"/>">は</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ひ"/>">ひ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ふ"/>">ふ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="へ"/>">へ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ほ"/>">ほ</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">ま</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ま"/>">ま</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="み"/>">み</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="む"/>">む</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="め"/>">め</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="も"/>">も</a>
        </li>
      </ul>
      </li>
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">や</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="や"/>">や</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ゆ"/>">ゆ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="よ"/>">よ</a>
        </li>
      </ul>
      </li>
            <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">ら</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ら"/>">ら</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="り"/>">り</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="る"/>">る</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="れ"/>">れ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ろ"/>">ろ</a>
        </li>
      </ul>
      </li>
             <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">わ</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="わ"/>">わ</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="を"/>">を</a>
        <a href="<%=request.getContextPath()%>/user/itemInitials?initials=<c:out value="ん"/>">ん</a>
        </li>
      </ul>
      </li>			
          </ul>
        </li>
        
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="tableDecoration">Sort<span class="caret"></span></a>
         <ul class="dropdown-menu" aria-labelledby="VisualDecoration">
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">名前</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=name&sortOption=ASC">昇順</a>
        <a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=name&sortOption=DESC">降順</a>
        </li>
      </ul>
      </li>		
          <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">価格</a>
      <ul class="dropdown-menu">
        <li>
        <a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=price&sortOption=ASC">安い順</a>
        <a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=<c:out value="${itemName}"/>&itemSort=price&sortOption=DESC">高い順</a>
        </li>
      </ul>
      </li>
      <li><a href="<%=request.getContextPath()%>/user/findBySeason">今が旬の食材</a></li>		
      <li><a href="<%=request.getContextPath()%>/user/findByNameAndSort?useritem=&itemSort=name&sortOption=ASC">検索リセット</a></li>		
          </ul>
        </li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="tableDecoration">Cart<span class="caret"></span></a>
         <ul class="dropdown-menu" aria-labelledby="VisualDecoration">
                 
      <li><a href="${pageContext.request.contextPath}/user/show">カートの中身を見る</a></li>		
          </ul>
        </li>
        
        <li><a href="${pageContext.request.contextPath}/user/recontact">お問い合わせ</a>
        
      
      </ul>
      
  <!-- 右寄せになる部分 ================ -->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/admin/index">管理者ログイン</a>
        <!-- リンクのみ -->
          <sec:authorize access="hasRole('ROLE_MEMBER') and isAuthenticated()">
				<sec:authentication var="userName" property="principal.user.name" />
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="tableDecoration" ><c:out value="${userName}" />&nbsp;さん<span class="caret"></span></a>
         <ul class="dropdown-menu" aria-labelledby="VisualDecoration">
         <li><a href="${pageContext.request.contextPath}/user/logout">ログアウト</a></li>
         <li><a href="${pageContext.request.contextPath}/user/info">登録者情報変更</a></li>
							<li><a href="${pageContext.request.contextPath}/user/password">パスワード変更</a></li>
                 
          </ul>
        </li>
        </sec:authorize>
        
        <sec:authorize
				access="!(hasRole('ROLE_MEMBER') and isAuthenticated())">
				
				 <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="tableDecoration">こんにちは ゲストさん<span class="caret"></span></a>
         <ul class="dropdown-menu" aria-labelledby="VisualDecoration">
				<li><a class="login" href="${pageContext.request.contextPath}/user/index">ログイン</a></li>
				<li><a class="login" href="${pageContext.request.contextPath}/user/form">新規登録はこちら</a></li>
							<li><a class="login" href="${pageContext.request.contextPath}/user/forget">パスワードを忘れた方はこちら</a></li>
                 
          </ul>
        </li>
				
				
	</sec:authorize>
  <!--       <li><a href="http://studio-key.com" target="_blank"><span class="glyphicon glyphicon-home"></span></a></li>
        <li><a href="https://www.studio-key.jp/Contact-us.html" target="_blank"><span class="glyphicon glyphicon-envelope"></span></a></li> -->
      </ul>
      
    </div>
  </div>
</nav><!-- /navigation -->


<!-- <div class="dropdown">
  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu 1 <b class="caret"></b></a>
  <ul class="dropdown-menu multi-level">
    <li><a href="#">Default</a></li>
    <li class="dropdown-submenu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown</a>
    <ul class="dropdown-menu">
      <li><a href="#">sub menu1</a></li>
      <li class="dropdown-submenu">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">sub menu1</a>
      <ul class="dropdown-menu">
        <li class="dropdown-submenu">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">sub menu2</a>
        <ul class="dropdown-menu">
          <li><a href="#">sub menu3</a></li>
          <li><a href="#">sub menu3</a></li>
          <li><a href="#">sub menu3</a></li>
        </ul>
        </li>
      </ul>
      </li>
    </ul>
    </li>
  </ul>
</div> -->

<!-- <nav class="navbar navbar-default"> ヘッダー固定する場合は navbar-fixed-top 追加
  <div class="container-fluid">
    ヘッダー部分 ================
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Header</a>
    この部分がスマートフォンで[三]と表示されるナビゲーションボタンになる
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav_target"> ←これ重要
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="nav_targets"> ←これ重要
  <ul class="nav navbar-nav">
    <li class="active"><a href="#">Nav 1</a></li> class="active" が現在のページでアクティブになります。
    <li><a href="#">Nav 2</a></li>
    
      ドロップダウン
    <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">link 1</a></li>
        <li class="divider"></li>
        <li><a href="#">link3</a></li>
      </ul>
    </li>
  </ul>
</div>
    
  </div>
</nav> -->

<!-- <nav class="navbar navbar-default ">
  <div class="container-fluid">
  ヘッダー部分 ================
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bootstap</a>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav_target">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
  中央のナビゲーション部分 ================
    <div class="collapse navbar-collapse" id="nav_target">
      <ul class="nav navbar-nav">
        リンクのみ
          <li class="active"><a href="#">Nav 1</a></li>
          <li><a href="#">Nav 2</a></li>
        Nav3 ドロップダウン
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Nav3 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">link 1</a></li>
              <li><a href="#">link 2</a></li>
              <li class="divider"></li>
              <li><a href="#">link3</a></li>
            </ul>
          </li>
        Nav4 ドロップダウン
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
  右寄せになる部分 ================
      <ul class="nav navbar-nav navbar-right">
        リンクのみ
          <li><a href="#">Nav 5</a></li>
        Nav6 ドロップダウン
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
</nav> -->
</body>
</html>