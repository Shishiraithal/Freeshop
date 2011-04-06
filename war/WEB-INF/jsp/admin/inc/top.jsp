<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- base href="http://www.refscall.com.br/" / -->
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title><fmt:message key="app.admin.title" /></title>
<link type="text/css" rel="stylesheet" href="/css/estilo.css">
<script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
<div id="outer">
<div id="top">
	<table align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td><img src="/img/logo2.gif" width="267" height="110"></td>
		<td><img src="/img/blank.gif" width="1" height="1"></td>
		<td><img src="/img/top2.jpg" width="492" height="110"></td>
	</tr>
	</table>
</div>
<div id="menu">
	<ul>
		<li><a href="/admin/"><fmt:message key="app.admin.menu.admin" /></a></li>
		<li><a href="/admin/groups"><fmt:message key="app.admin.menu.categories" /></a></li>
		<li><a href="/admin/products"><fmt:message key="app.admin.menu.prods" /></a></li>
		<li><a href="/admin/contents"><fmt:message key="app.admin.menu.contents" /></a></li>
	</ul>
</div>
<div id="content">
<div id="contentAdmin">
<br/>