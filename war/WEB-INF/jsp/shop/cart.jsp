<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/inc/top.jsp" />

<div id="shop_produto_cart">
<h3><fmt:message key="title.cart" /></h3>
<br/>

<jsp:include page="/WEB-INF/jsp/inc/err.jsp" />

<c:if test="${empty cart}"><fmt:message key="msg.cart.empty" /></c:if>

<c:if test="${not empty cart}">
<table id="shop_cart_table">
<tr><th colspan="3"><fmt:message key="lbl.product" /></th><th><fmt:message key="lbl.quantity" /></th><th><fmt:message key="lbl.price" /></th><th><fmt:message key="lbl.total" /></th></tr>
<c:if test="${empty cart.items}"><tr><td colspan="6"><fmt:message key="msg.cart.empty" /></td></tr></c:if>
<c:forEach items="${cart.items}" var="item" varStatus="st">
<tr>
 <td><a href="/shop/product/${item.product.id}"><img src="/img/prod/<fmt:formatNumber type="number" maxIntegerDigits="5" pattern="00000" value="${item.product.id}" />_thumb.jpg" border="0" /></a></td>
 <td><a href="/shop/product/${item.product.id}">${item.product.name}</a></td>
 <td>
  <a href="/shop/exclude/${item.product.id}"><img src="/img/ico/ico_trash_16.gif" width="16" height="16" border="0" alt="<fmt:message key="lbl.exclude" />" title="<fmt:message key="lbl.exclude" />"/></a>
  <a href="/shop/add/${item.product.id}"><img src="/img/ico/ico_plus.png" width="16" height="16" border="0" alt="<fmt:message key="lbl.add.item" />" title="<fmt:message key="lbl.add.item" />"/></a>
  <a href="/shop/remove/${item.product.id}"><img src="/img/ico/ico_minus.png" width="16" height="16" border="0" alt="<fmt:message key="lbl.exclude.item" />" title="<fmt:message key="lbl.exclude.item" />"/></a>
 </td>
 <td>${item.quantity}</td>
 <td>${item.product.price}</td>
 <td><fmt:formatNumber type="number" pattern="#,##0.00" value="${item.total}"/></td>
</tr>
</c:forEach>
<form name="frmCEP" method="POST" ACTION="/shop/cart/cep">
<tr class="shop_cart_table_cep">
 <c:if test="${empty cart.frete}">
 <td colspan="6">
 </c:if>
 <c:if test="${not empty cart.frete}">
 <td colspan="4">
 </c:if>
 <fmt:message key="lbl.zip.shipping" />: 
 <input type="text" name="cep" size="8" maxlength="8" value="${cart.cep}"/>
 <input type="submit" name="btnCep" value="OK"/>
 </td>
 <c:if test="${not empty cart.frete}">
 <td><fmt:message key="lbl.freight" />: </td><td><fmt:message key="currency.symbol" /> <fmt:formatNumber type="number" pattern="#,##0.00" value="${cart.frete}"/></td>
 </c:if>
</tr>
</form>
<tr><td colspan="5" class="shop_cart_table_total"><fmt:message key="lbl.total" />: </td><td class="shop_cart_table_total"><fmt:message key="currency.symbol" /> <fmt:formatNumber type="number" pattern="#,##0.00" value="${cart.total}"/></td>
</tr>
</table>
<table id="shop_cart_table_checkout">
<tr><td>* Observação: Você será redirecionado para a página do PagSeguro do UOL para finalizar a compra.</td></tr>
<tr><td>
 <input type="button" name="btnCheckout" value="<fmt:message key="lbl.btn.checkout" />" onclick="checkout(this);"/>
 <input type="button" name="btnContinuar" value="<fmt:message key="lbl.btn.shop.more" />" onclick="checkout(this);"/>
</td></tr>
</table>
</c:if>

</div>

<jsp:include page="/WEB-INF/jsp/inc/footer.jsp" />
