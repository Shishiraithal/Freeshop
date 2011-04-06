<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br/><br/>
</div>
<div id="footer">
	<p class="menu_footer">
	<a href="/shop/"><fmt:message key="app.menu.store" /></a> &nbsp;|&nbsp; 
	<a href="/shop/cart"><fmt:message key="app.menu.cart" /></a> &nbsp;|&nbsp; 
<c:forEach items="${MenuItems}" var="MenuItem" varStatus="st">
	<a href="/page/${MenuItem.name}">${MenuItem.menuTitle}</a> &nbsp;|&nbsp; 
</c:forEach>
	</p>
	<p><fmt:message key="app.copyright" /></p>
</div>
</div>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-12176665-2");
pageTracker._trackPageview();
} catch(err) {}
</script>
</body>
</html>