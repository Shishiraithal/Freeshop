<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/inc/top.jsp" />

<div id="div_content">
<c:if test="${not empty content.title}">
<h3>${content.title}</h3>
</c:if>
<br/>
${content.content.value}
</div>

<jsp:include page="/WEB-INF/jsp/inc/footer.jsp" />