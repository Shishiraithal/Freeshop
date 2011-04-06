<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/inc/top.jsp" />

<div id="shop_register">
<h3><fmt:message key="title.register" /></h3>
<br/>

<jsp:include page="/WEB-INF/jsp/inc/err.jsp" />

<table border="0" cellspacing="5" align="center">
<tr valign="top">
<td>
	<div class="divRegister">
		<h4>Já sou cliente</h4>
		<form name="frmLogin" method="POST" action="/shop/login">
		<table align="center">
			<tr><td>E-mail:</td><td><input type="text" name="email"/></td></tr>
			<tr><td>Senha:</td><td><input type="password" name="password"/></td></tr>
			<tr><td colspan="2" align="right">
			<input type="submit" name="btnLogin" value="Entrar"/>
			<input type="submit" name="lostPassword" value="Esqueci a senha"/>
			<br/><br/>
			</td></tr>
		</table>
		</form>
	</div>
</td>
<td>
	<div class="divRegister">
		<h4>Ainda não sou cliente</h4>
		<form name="frmLogin" method="POST" action="/shop/signon">
		<table align="center">
			<tr><td>Nome:</td><td><input type="text" name="costumer.name"/></td></tr>
			<tr><td>E-mail:</td><td><input type="text" name="costumer.email"/></td></tr>
			<tr><td>Senha:</td><td><input type="password" name="costumer.password"/></td></tr>
			<!--
			<tr><td>Sexo:</td><td><input type="radio" name="costumer.gender" value="M"/>Masculino / <input type="radio" name="costumer.gender" value="F"/> Feminino</td></tr>
			<tr><td>Nascimento:</td><td><input type="text" name="costumer.birth"/></td></tr>
			-->
			<tr><td>CPF:</td><td><input type="text" name="costumer.ssn"/></td></tr>
			<tr><td>Telefone:</td><td><input type="text" name="costumer.phone"/></td></tr>
			<tr><td>Celular:</td><td><input type="text" name="costumer.cellphone"/></td></tr>
			<tr><td>Endereço:</td><td><input type="text" name="costumer.address"/></td></tr>
			<tr><td>Complemento:</td><td><input type="text" name="costumer.address2"/></td></tr>
			<tr><td>Bairro:</td><td><input type="text" name="costumer.neighbourhood"/></td></tr>
			<tr><td>Cidade:</td><td><input type="text" name="costumer.city"/></td></tr>
			<tr><td>Estado:</td><td><input type="text" name="costumer.state"/></td></tr>
			<tr><td>CEP:</td><td><input type="text" name="costumer.zipcode"/></td></tr>
			<tr><td colspan="2" align="right">
			<input type="submit" name="btnLogin" value="Cadastrar"/>
			<br/><br/>
			</td></tr>
		</table>
		</form>
	</div>
</td>
</tr>
</table>

</div>

<jsp:include page="/WEB-INF/jsp//inc/footer.jsp" />
