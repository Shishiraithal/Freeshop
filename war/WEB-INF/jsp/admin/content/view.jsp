<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.contents" /></h2>

 <fmt:message key="lbl.id" />: ${content.id} <br/>
 <fmt:message key="lbl.name" />: ${content.name} <br/> 
 <fmt:message key="lbl.menu.title" />: ${content.menuTitle} <br/>
 <fmt:message key="lbl.title" />: ${content.title} <br/> <br/>
 [ <a href="/admin/contents"><fmt:message key="lbl.list" /></a> ] [ <a href="/admin/content"><fmt:message key="lbl.new" /></a> ] [ <a href="/admin/content/${content.id}/edit"><fmt:message key="lbl.edit" /></a> ] [ <a href="/admin/content/${content.id}/delete"><fmt:message key="lbl.delete" /></a> ] 

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />