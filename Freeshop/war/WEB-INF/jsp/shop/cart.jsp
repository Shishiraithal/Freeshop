<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/inc/top.jsp" />

<div id="shop_produto">
<br/>

<h3>Carrinho de Compras</h3>

<c:if test="${empty cart}">Nenhum produto encontrado.</c:if>

<c:if test="${not empty cart}">
<table border="0">
<tr><th><th>Produto</th><th>Preço</th><th>Quantidade</th><th>Total</th></tr>
<c:forEach items="${cart.items}" var="item" varStatus="st">
<tr>
 <td><a href="/shop/product/${item.product.id}"><img src="/img/prod/<fmt:formatNumber type="number" maxIntegerDigits="5" pattern="00000" value="${item.product.id}" />_thumb.jpg" border="0" /></a></td>
 <td><a href="/shop/product/${item.product.id}">${item.product.name}</a></td>
 <td>${item.product.price}</td>
 <td>${item.quantity}</td>
 <td><fmt:formatNumber type="number" pattern="#,##0.00" value="${item.total}"/></td>
</tr>
</c:forEach>
<tr><td>Total: R$ <fmt:formatNumber type="number" pattern="#,##0.00" value="${cart.total}"/></td></tr>
</table>
</c:if>

<hr/>
</div>

<jsp:include page="/WEB-INF/jsp/inc/footer.jsp" />
