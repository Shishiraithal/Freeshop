<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- base href="http://www.refscall.com.br/" / -->
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<meta name="description" content="Bandeira Eletrônica para Árbitro de Futebol, Material Esportivo para Arbitragem de Futebol">
<meta name="keywords" content="bandeira eletrônica, bandeirinha eletrônica, bandeira eletronica, bandeirinha eletronica, refscall, ervocom, signal beep, genialtec, material esportivo, árbitro, arbitragem, bandeira, bandeirinha, apito">
<title><fmt:message key="app.title" /></title>
<link type="text/css" rel="stylesheet" href="/css/estilo.css">
<script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
<div id="outer">
<div id="top">
	<table align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top"><img src="/img/logo3.gif" width="267" height="90"></td>
		<td valign="top" rowspan="2"><img src="/img/blank.gif" width="1" height="1"></td>
		<td valign="top" rowspan="2"><img src="/img/top2_c.jpg" width="492" height="110"></td>
	</tr>
	<tr>
		<c:if test="${empty customer}">
		<td valign="middle" class="sing_in_on_area"><a href="/shop/register">Faça seu Login ou Cadastre-se</a></td>
		</c:if>
		<c:if test="${not empty customer}">
		<td valign="middle" class="sing_in_on_area">Bem-vindo, ${customer.name}</td>
		</c:if>
	</tr>
	</table>
</div>
<div id="menu">
	<ul>
		<li><a href="/shop/"><fmt:message key="app.menu.store" /></a></li>
		<li><a href="/shop/cart"><fmt:message key="app.menu.cart" /></a></li>
<c:forEach items="${MenuItems}" var="MenuItem" varStatus="st">
		<li><a href="/page/${MenuItem.name}">${MenuItem.menuTitle}</a></li>
</c:forEach>
	</ul>
</div>
<div id="content">
