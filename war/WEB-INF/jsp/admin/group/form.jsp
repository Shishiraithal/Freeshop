<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.categories" /></h2>

<form name="frmGroup" method="POST" action="/admin/group/save">
 <input type="hidden" name="group.id" value="${group.id}"/>
 <fmt:message key="lbl.id" />: ${group.id} <br/>
 <fmt:message key="lbl.name" />: <input type="text" name="group.name" value="${group.name}"/> <br/>
 <input type="submit" name="btnSave" value="Save"/> 
</form>
 <br/>
 [ <a href="/admin/groups"><fmt:message key="lbl.list" /></a> ] [ <a href="/admin/group"><fmt:message key="lbl.new" /></a> ] [ <fmt:message key="lbl.edit" /> ] [ <a href="/admin/group/${group.id}/delete"><fmt:message key="lbl.delete" /></a> ]

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />