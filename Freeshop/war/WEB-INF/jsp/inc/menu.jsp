<div id="shop_menu">
	<div id="shop_menu_title">Artigos</div>
	<!--
	<a href="/shop/1">Apitos</a>
	<a href="/shop/2">Bandeiras</a>
	<a href="/shop/3">Acessórios</a>
	<a href="/shop/4">Bolsas</a>
	<a href="/shop/5">Livros</a>
	-->
<c:forEach items="${MenuGroups}" var="MenuItem" varStatus="st">
	<a href="/shop/${MenuItem.id}">${MenuItem.name}</a>
</c:forEach>
</div>