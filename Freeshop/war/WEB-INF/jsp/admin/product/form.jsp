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
 Quantity: <input type="text" name="product.quantity" value="${product.quantity}"/> <br/>
 Active: <input type="radio" name="product.active" value="true" ${product.active?'checked':''}/> YES / <input type="radio" name="product.active" value="false" ${product.active?'':'checked'}/> NO <br/>
 Group: <select name="product.group.id">
 <c:forEach items="${groups}" var="group" varStatus="st">
 	<option value="${group.id}" ${group.id==product.idGroup?'selected':''}>${group.name}</option>
 </c:forEach>
 </select> <br/>
 Brand: <input type="text" name="product.brand" value="${product.brand}"/> <br/>
 Size: <input type="text" name="product.size" value="${product.size}"/> <br/>
 Color: <input type="text" name="product.color" value="${product.color}"/> <br/>
 Author: <input type="text" name="product.author" value="${product.author}"/> <br/>
 ISBN: <input type="text" name="product.isbn" value="${product.isbn}"/> <br/>
 Weight: <input type="text" name="product.weight" value="${product.weight}"/> <br/>
 Dimensions: <input type="text" name="product.dimensions" value="${product.dimensions}"/> <br/>
 Number of photos: <input type="text" name="product.numberOfImages" value="${product.numberOfImages}"/> <br/>
 <input type="submit" name="btnSave" value="Save"/> 
</form>
 <br/>
 [ <a href="/admin/products">lista</a> ] [ <a href="/admin/product">novo</a> ] [ editar ] [ <a href="/admin/product/${product.id}/delete">excluir</a> ]

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />