<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.categories" /></h2>

[ <a href="/admin/group"><fmt:message key="lbl.new" /></a> ] <br/>

<table>
<tr><th><fmt:message key="lbl.id" /></th><th><fmt:message key="lbl.name" /></th></tr>
<c:forEach items="${list}" var="group" varStatus="st">
<tr><td>${group.id}</td><td><a href="/admin/group/${group.id}">${group.name}</a></td></tr>
</c:forEach>
</table>

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />