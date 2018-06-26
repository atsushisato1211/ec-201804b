<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品一覧</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/imgslide.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/page.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/itemList.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/item_table.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_menu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/test_header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/left_calamu.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/sort.css" rel="stylesheet">
<%-- <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ecHeader.css" /> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/testHeader.css" />
</head>
<body>
	<jsp:include page="testHeader.jsp" />
	<div align ="center">
	<h2 id="item">新しい商品</h2>
	<!-- スライダー部 -->
<div id="stage">
	<input id="r1" type="radio" name="slider8">
	<input id="r2" type="radio" name="slider8">
	<input id="r3" type="radio" name="slider8">
	<input id="r4" type="radio" name="slider8">
	<input id="r5" type="radio" name="slider8">
	<input id="r6" type="radio" name="slider8">
	<input id="r7" type="radio" name="slider8">
	<input id="r8" type="radio" name="slider8">
  <!-- スライド群 -->
  <div id="photos">
  <c:forEach items="${newitem}" var="item" varStatus="status">
  	<div id="photo<c:out value="${status.count}" />" class="pic">
  	<a href=<%=request.getContextPath()%>/user/itemdetail?id=<c:out value="${item.id}"/>>
  	<img src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>"></a></div>
    </c:forEach>
    <%-- <div id="photo2" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/002.jpg"></a></div>
    <div id="photo3" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/003.jpg"></a></div>
    <div id="photo4" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/004.jpg"></a></div>
    <div id="photo5" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/005.jpg"></a></div>
    <div id="photo6" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/006.jpg"></a></div>
    <div id="photo7" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/007.jpg"></a></div>
    <div id="photo8" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/008.jpg"></a></div>
  	<div id="photo9" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/009.jpg"></a></div>
  	<div id="photo10" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/010.jpg"></a></div>
  	<div id="photo11" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/011.jpg"></a></div>
  	<div id="photo12" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/012.jpg"></a></div>
  	<div id="photo13" class="pic"><a href="#"><img src="<%=request.getContextPath()%>/img/013.jpg"></a></div> --%>
  </div>
  <!-- スライダー部の高さ確保 -->
  <div style="padding-top:20%;"></div>
  <!-- スライドボタン -->
  <div id="btns">
  	<label for="r1" id="btn1" class="p_bar"></label>
  	<label for="r2" id="btn2" class="p_bar"></label>
  	<label for="r3" id="btn3" class="p_bar"></label>
  	<label for="r4" id="btn4" class="p_bar"></label>
  	<label for="r5" id="btn5" class="p_bar"></label>
  	<label for="r6" id="btn6" class="p_bar"></label>
  	<label for="r7" id="btn7" class="p_bar"></label>
  	<label for="r8" id="btn8" class="p_bar"></label>
  	
    <!-- 位置表示バー -->
    <div id="p_btn"></div>
  </div>
  <!-- ボタン部の高さ確保 -->
  <div style="padding-top:2%;"></div>
</div>

	<!-- サブメニュー（左カラム） -->
	<div id="submenu">
		<div id="submenu_header">目的で探す</div>
		<ul id="submenu_body">
			<li><a href="<%=request.getContextPath()%>/user/findBySeason">今が旬の食材</a></li>
			<li><a href="xxx.html">セレクタ</a></li>
			<li><a href="xxx.html">フォント</a></li>
			<li><a href="xxx.html">テキスト</a></li>
			<li><a href="xxx.html">文字色・背景</a></li>
			<li><a href="xxx.html">幅・高さ・余白</a></li>
			<li><a href="xxx.html">ボーダー</a></li>
			<li><a href="xxx.html">表示・配置</a></li>
			<li><a href="xxx.html">リスト</a></li>
			<li><a href="xxx.html">テーブル</a></li>
			<li><a href="xxx.html">生成内容の挿入</a></li>
			<li><a href="xxx.html">インターフェース</a></li>
			<li><a href="xxx.html">フィルタ・ズーム</a></li>
			<li><a href="xxx.html">テキスト（IE独自）</a></li>
			<li><a href="xxx.html">印刷</a></li>
			<li><a href="xxx.html">音声</a></li>
		</ul>
	</div></div>

	
<div align ="center">
	<h2>商品一覧</h2>
	<form action="<%=request.getContextPath()%>/user/findByName">
		名前<input type="text" name="useritem" value="${itemName}"> 
		<button type="submit" class="btn btn-info">検索</button>
			</form>
			<form action="<%=request.getContextPath()%>/user/findByNameAndSort" align="center">
		<input type="hidden" name="useritem" value="${itemName}">

		<select name="itemSort" onChange="this.form.submit()">  
		<option value="id">ソート</option>
		  <option value="name">名前順</option>
		  <option value="price">価格順</option>
		</select>
<input type="hidden" value="ASC" name="sortOption">
<input type="hidden" value="ASC" name="season">

		<%-- <form:checkbox path="sortOption" value="DESC"/>降順で検索 --%>
		<c:choose><c:when test="${sortOption.equals('DESC')}">
		<input type="checkbox" name="sortOption" value="DESC" checked="checked">降順で検索 </c:when>
		<c:otherwise>
		<input type="checkbox" name="sortOption" value="DESC">降順で検索 </c:otherwise>
	</c:choose>
	</form>
</div>

	<!-- 商品一覧テスト開始 -->
	<br><c:choose>
	<c:when test="${itemList.isEmpty()}"><c:out value="${erroritemName}"/>は商品名に該当しません。</c:when>
	<c:otherwise><table class="item" cellspacing="30" border="0"　class="itemList" align="center">
	<!-- 	<tr>
			<th colspan="2">商品名</th>
			<th>価格</th>
		</tr> -->
		<c:forEach var="item" items="${itemList}" varStatus="status">
		<%-- 	<c:if test="${status.count%4==0}"><tr></c:if> --%>
						<td class="item"><a
					href="<%=request.getContextPath()%>/user/itemdetail?id=<c:out value="${item.id}"/>"><img
						src="<%=request.getContextPath()%>/img/<c:out value="${item.imagePath}"/>"
						width="250" height="225" alt="<c:out value="${item.name}" />画像"></a><br>
				</a><br>
				<table class="item_name" border="0" align="center"><tr><td class="item_name" align="center">
				<a
					href="<%=request.getContextPath()%>/user/itemdetail?id=<c:out value="${item.id}"/>">
						<c:out value="${item.name}" /></a></td></tr>
						<tr><td class="item_name" align="center">
				&yen;<c:out value="${item.price}" /></td></tr>
				</table>
			 	</td>
				<c:if test="${status.count%3==0}"></tr></c:if>
						
		</c:forEach>
	</table></c:otherwise>
	</c:choose>
	<!-- 商品一覧テスト終了 -->
	
	
	<c:if test="${!itemList.isEmpty()}">
	
	</c:if><c:out value="${maxPageNum}"></c:out>
	<c:forEach var="obj" items="${data}" varStatus="status"></c:forEach>
<div>
  <ul class="pagination">
    <li class="page-item <c:if test="${(pageNum)==1}">disabled</c:if>">
      <a class="page-link" href="<%=request.getContextPath()%>/user/page?pageNum=<c:out value="${pageNum-1}"/>">&laquo;</a>
    </li>
<c:forEach varStatus="num" begin="1" end="${maxPageNum}">
<c:choose> <c:when test="${(num.count)==pageNum}"> 
    <li class="page-item active">
      <a class="page-link" href="<%=request.getContextPath()%>/user/page?pageNum=<c:out value="${num.count}"/>"><c:out value="${num.count}"/></a>
    </c:when><c:otherwise>
    <li class="page-item">
      <a class="page-link" href="<%=request.getContextPath()%>/user/page?pageNum=<c:out value="${num.count}"/>"><c:out value="${num.count}"/></a>
</c:otherwise>
</c:choose>
</c:forEach>
     <li class="page-item <c:if test="${(pageNum)==maxPageNum}">disabled</c:if>">
      <a class="page-link" href="<%=request.getContextPath()%>/user/page?pageNum=<c:out value="${pageNum+1}"/>">&raquo;</a>
    </li>
  </ul>
</div>








</body>
</html>