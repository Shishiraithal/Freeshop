<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2>Cadastro de Categorias de Produtos</h2>

 ID: ${group.id} <br/>
 Name: ${group.name} <br/> <br/>
 [ <a href="/admin/groups">lista</a> ] [ <a href="/admin/group">novo</a> ] [ <a href="/admin/group/${group.id}/edit">editar</a> ] [ <a href="/admin/group/${group.id}/delete">excluir</a> ] 

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />