<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
<div id="error_mesages">
<c:forEach var="err" items="${error}">
 ${err} <!-- {err.category} - {err.message} --><br/>
</c:forEach>
</div>
<br/>
</c:if>