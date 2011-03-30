<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2>Cadastro de Produtos</h2>

[ <a href="/admin/product">NOVO</a> ] <br/>

<table>
<tr><th>ID</th><th>Nome</th><th>Preço</th><th>Preço Antigo</th></tr>
<c:forEach items="${list}" var="prod" varStatus="st">
<tr><td>${prod.id}</td><td><a href="/admin/product/${prod.id}">${prod.name}</a></td><td>${prod.price}</td><td>${prod.oldPrice}</td></tr>
</c:forEach>
</table>

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />