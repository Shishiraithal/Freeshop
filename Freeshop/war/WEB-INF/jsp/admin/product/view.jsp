<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2>Cadastro de Produtos</h2>

 ID: ${product.id} <br/>
 Name: ${product.name} <br/>
 Short name: ${product.shortName} <br/>
 Description: ${product.description} <br/>
 Price: ${product.price} <br/>
 Old Price: ${product.oldPrice} <br/> 
 Quantity: ${product.quantity} <br/> 
 Active: ${product.active} <br/> 
 Group: ${product.group.name} <br/> 
 Brand: ${product.brand} <br/> 
 Size: ${product.size} <br/> 
 Color: ${product.color} <br/> 
 Author: ${product.author} <br/> 
 ISBN: ${product.isbn} <br/> 
 Weight: ${product.weight} <br/> 
 Dimensions: ${product.dimensions} <br/> 
 Number of photos: ${product.numberOfImages} <br/> <br/>
 
 [ <a href="/admin/products">lista</a> ] [ <a href="/admin/product">novo</a> ] [ <a href="/admin/product/${product.id}/edit">editar</a> ] [ <a href="/admin/product/${product.id}/delete">excluir</a> ] 

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />