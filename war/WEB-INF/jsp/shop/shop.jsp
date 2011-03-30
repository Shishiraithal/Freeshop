<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/inc/top.jsp" />

<div id="shop_menu">
	<div id="shop_menu_title">Artigos</div>
	<!--
	<a href="/shop/1">Apitos</a>
	<a href="/shop/2">Bandeiras</a>
	<a href="/shop/3">Acessórios</a>
	<a href="/shop/4">Bolsas</a>
	<a href="/shop/5">Livros</a>
	-->
<c:forEach items="${MenuGroups}" var="MenuItem" varStatus="st">
	<a href="/shop/${MenuItem.id}">${MenuItem.name}</a>
</c:forEach>
</div>

<div id="shop_produto">
<!-- include virtual="/shop/breadcrumb.asp" -->
<br/>

<h3>Artigos</h3>

<c:forEach items="${products}" var="prod" varStatus="st">
<a href="/shop/product/${prod.id}" class="prod_oferta"><img src="http://localhost:8888/img/prod/thumb/<fmt:formatNumber type="number" maxIntegerDigits="5" pattern="00000" value="${prod.id}" />.jpg" width="120" height="120" border="0"><br/>
<span class="oferta_nome">${prod.shortName}</span><br/>
<c:if test="${prod.oldPrice != null}">
<span class="oferta_preco_antigo">de: R$ <fmt:formatNumber type="number" pattern="#,##0.00" value="${prod.oldPrice}" /></span><br/>
</c:if>
<span class="oferta_preco">por: R$ <fmt:formatNumber type="number" pattern="#,##0.00" value="${prod.price}" /></span></a>

<c:if test="${st.index % 4 == 3 && st.index > 0}"><hr/></c:if>
</c:forEach>
<hr/>
</div>

<jsp:include page="/WEB-INF/jsp//inc/footer.jsp" />
