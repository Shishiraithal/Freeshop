<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/admin/inc/top.jsp" />

<h2><fmt:message key="title.admin.products" /></h2>

<form id="frmProduct" name="frmProduct" method="POST" action="/admin/product/save">
 <input type="hidden" name="product.id" value="${product.id}"/>
 <fmt:message key="lbl.id" />: ${product.id} <br/>
 <fmt:message key="lbl.name" />: <input type="text" name="product.name" value="${product.name}"/> <br/>
 <fmt:message key="lbl.short.name" />: <input type="text" name="product.shortName" value="${product.shortName}"/> <br/>
 <fmt:message key="lbl.description" />: <input type="text" name="product.description" value="${product.description}"/> <br/>
 <fmt:message key="lbl.price" />: <input type="text" name="product.price" value="${product.price}"/> <br/>
 <fmt:message key="lbl.old.price" />: <input type="text" name="product.oldPrice" value="${product.oldPrice}"/> <br/>
 <fmt:message key="lbl.quantity" />: <input type="text" name="product.quantity" value="${product.quantity}"/> <br/>
 <fmt:message key="lbl.active" />: <input type="radio" name="product.active" value="true" ${product.active?'checked':''}/> <fmt:message key="lbl.yes" /> / <input type="radio" name="product.active" value="false" ${product.active?'':'checked'}/> <fmt:message key="lbl.no" /> <br/>
 <fmt:message key="lbl.group" />: <select name="product.group.id">
 <c:forEach items="${groups}" var="group" varStatus="st">
 	<option value="${group.id}" ${group.id==product.idGroup?'selected':''}>${group.name}</option>
 </c:forEach>
 </select> <br/>
 <fmt:message key="lbl.brand" />: <input type="text" name="product.brand" value="${product.brand}"/> <br/>
 <fmt:message key="lbl.size" />: <input type="text" name="product.size" value="${product.size}"/> <br/>
 <fmt:message key="lbl.color" />: <input type="text" name="product.color" value="${product.color}"/> <br/>
 <fmt:message key="lbl.author" />: <input type="text" name="product.author" value="${product.author}"/> <br/>
 <fmt:message key="lbl.isbn" />: <input type="text" name="product.isbn" value="${product.isbn}"/> <br/>
 <fmt:message key="lbl.weight" />: <input type="text" name="product.weight" value="${product.weight}"/> <br/>
 <fmt:message key="lbl.dimensions" />: <input type="text" name="product.dimensions" value="${product.dimensions}"/> <br/>
 <fmt:message key="lbl.num.photos" />: <input type="text" name="product.numberOfImages" value="${product.numberOfImages}"/> <br/>
 <fmt:message key="lbl.tags" />: <input type="text" name="tagEditor" value=""/> <input type="button" name="btnAddTag" value="+" onClick="addNewTag(this.form.tagEditor);"/><br/>
 <div id="divTags"></div>
 <input type="submit" name="btnSave" value="Save"/> 
</form>

<script type="text/javascript">
<c:forEach items="${product.tags}" var="tag" varStatus="st">
addTag("${tag}");
</c:forEach>
</script>
<br/>
 [ <a href="/admin/products"><fmt:message key="lbl.list" /></a> ] [ <a href="/admin/product"><fmt:message key="lbl.new" /></a> ] [ <fmt:message key="lbl.edit" /> ] [ <a href="/admin/product/${product.id}/delete"><fmt:message key="lbl.delete" /></a> ]

<jsp:include page="/WEB-INF/jsp/admin/inc/footer.jsp" />