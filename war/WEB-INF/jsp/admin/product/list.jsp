<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.products" /></h2>

[ <a href="/admin/product"><fmt:message key="lbl.new" /></a> ] <br/>

<table>
<tr><th><fmt:message key="lbl.id" /></th><th><fmt:message key="lbl.name" /></th><th><fmt:message key="lbl.price" /></th><th><fmt:message key="lbl.old.price" /></th><th><fmt:message key="lbl.quantity" /></th><th><fmt:message key="lbl.active" /></th><th><fmt:message key="lbl.group" /></th></tr>
<c:forEach items="${list}" var="prod" varStatus="st">
<tr><td>${prod.id}</td><td><a href="/admin/product/${prod.id}">${prod.name}</a></td><td>${prod.price}</td><td>${prod.oldPrice}</td><td>${prod.quantity}</td><td>${prod.active}</td><td>${prod.group}</td></tr>
</c:forEach>
</table>

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />