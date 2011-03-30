<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2>Cadastro de Produtos</h2>

<form name="frmProduct" method="POST" action="/admin/product/save">
 <input type="hidden" name="product.id" value="${product.id}"/>
 ID: ${product.id} <br/>
 Name: <input type="text" name="product.name" value="${product.name}"/> <br/>
 Short name: <input type="text" name="product.shortName" value="${product.shortName}"/> <br/>
 Description: <input type="text" name="product.description" value="${product.description}"/> <br/>
 Price: <input type="text" name="product.price" value="${product.price}"/> <br/>
 Old Price: <input type="text" name="product.oldPrice" value="${product.oldPrice}"/> <br/>
 Group: <select name="product.group.id">
 <c:forEach items="${groups}" var="group" varStatus="st">
 	<option value="${group.id}">${group.name}</option>
</c:forEach>
 </select> <br/>
 <input type="submit" name="btnSave" value="Save"/> 
</form>
 <br/>
 [ <a href="/admin/products">lista</a> ] [ <a href="/admin/product">novo</a> ] [ editar ] [ <a href="/admin/product/${product.id}/delete">excluir</a> ]

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />