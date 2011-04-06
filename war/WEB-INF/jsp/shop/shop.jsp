<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/inc/top.jsp" />
<jsp:include page="/WEB-INF/jsp/inc/menu.jsp" />

<div id="shop_produto">
<!-- include virtual="/shop/breadcrumb.asp" -->
<br/>

<c:if test="${group==null}">
<h3><fmt:message key="shop.products.title" /></h3>
</c:if>
<c:if test="${group!=null}">
<h3>${group.name}</h3>
</c:if>

<c:if test="${empty products}"><fmt:message key="msg.product.not.found" /></c:if>

<c:forEach items="${products}" var="prod" varStatus="st">
<a href="/shop/product/${prod.id}" class="prod_oferta"><img src="/img/prod/<fmt:formatNumber type="number" maxIntegerDigits="5" pattern="00000" value="${prod.id}" />.jpg" width="120" height="120" border="0"><br/>
<span class="oferta_nome">${prod.shortName}</span><br/>
<c:if test="${prod.oldPrice != null}">
<span class="oferta_preco_antigo"><fmt:message key="lbl.from" />: <fmt:message key="currency.symbol" /> <fmt:formatNumber type="number" pattern="#,##0.00" value="${prod.oldPrice}" /></span><br/>
</c:if>
<span class="oferta_preco"><fmt:message key="lbl.for" />: <fmt:message key="currency.symbol" /> <fmt:formatNumber type="number" pattern="#,##0.00" value="${prod.price}" /></span></a>

<c:if test="${st.index % 4 == 3 && st.index > 0}"><hr/></c:if>
</c:forEach>
<hr/>
</div>

<jsp:include page="/WEB-INF/jsp/inc/footer.jsp" />
