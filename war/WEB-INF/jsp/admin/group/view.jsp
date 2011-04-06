<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.categories" /></h2>

 <fmt:message key="lbl.id" />: ${group.id} <br/>
 <fmt:message key="lbl.name" />: ${group.name} <br/> <br/>
 [ <a href="/admin/groups"><fmt:message key="lbl.list" /></a> ] [ <a href="/admin/group"><fmt:message key="lbl.new" /></a> ] [ <a href="/admin/group/${group.id}/edit"><fmt:message key="lbl.edit" /></a> ] [ <a href="/admin/group/${group.id}/delete"><fmt:message key="lbl.delete" /></a> ] 

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />