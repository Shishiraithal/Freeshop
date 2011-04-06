<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="shop_menu">
	<div id="shop_menu_title"><fmt:message key="app.menu.title" /></div>
	<!--
	<a href="/shop/1">Apitos</a>
	<a href="/shop/2">Bandeiras</a>
	<a href="/shop/3">Acessórios</a>
	<a href="/shop/4">Bolsas</a>
	<a href="/shop/5">Livros</a>
	-->
<c:forEach items="${MenuProdGroups}" var="MenuItem" varStatus="st">
	<a href="/shop/${MenuItem.id}">${MenuItem.name}</a>
</c:forEach>
</div>