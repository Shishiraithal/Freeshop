<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.contents" /></h2>

<form name="frmContent" method="POST" action="/admin/content/save">
 <input type="hidden" name="content.id" value="${content.id}"/>
 <fmt:message key="lbl.id" />: ${content.id} <br/>
 <fmt:message key="lbl.name" />: <input type="text" name="content.name" value="${content.name}"/> <br/>
 <fmt:message key="lbl.menu.title" />: <input type="text" name="content.menuTitle" value="${content.menuTitle}"/> <br/>
 <fmt:message key="lbl.title" />: <input type="text" name="content.title" value="${content.title}"/> <br/>
 <fmt:message key="lbl.content" />: <br/>
 <textarea name="content.content" rows="10" cols="50">
 <c:out value="${content.content.value}" escapeXml="true" />
</textarea> <br/>
 <input type="submit" name="btnSave" value="Save"/> 
</form>
 <br/>
 [ <a href="/admin/contents"><fmt:message key="lbl.list" /></a> ] [ <a href="/admin/content"><fmt:message key="lbl.new" /></a> ] [ <fmt:message key="lbl.edit" /> ] [ <a href="/admin/content/${content.id}/delete"><fmt:message key="lbl.delete" /></a> ]

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />