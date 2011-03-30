<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2>Cadastro de Categorias de Produtos</h2>

<form name="frmGroup" method="POST" action="/admin/group/save">
 <input type="hidden" name="group.id" value="${group.id}"/>
 ID: ${group.id} <br/>
 Name: <input type="text" name="group.name" value="${group.name}"/> <br/>
 <input type="submit" name="btnSave" value="Save"/> 
</form>
 <br/>
 [ <a href="/admin/groups">lista</a> ] [ <a href="/admin/group">novo</a> ] [ editar ] [ <a href="/admin/group/${product.id}/delete">excluir</a> ]

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />