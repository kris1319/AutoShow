<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<title>Список клиентов</title>

<a href="test.html"> 
	<div class="mybuttonl">
	Главная
	</div>
</a>

<a href="add_client.html"> 
	<div class="mybuttonl">
	Новый клиент
	</div>
</a>

<table>
<tr>
	<th>Номер клиента</th>
	<th>Имя</th>
	<th>Фамилия</th>
	<th>Город</th>
</tr>

<c:forEach items="${clients}" var="cl">
	<tr>
		<td><a href="client.html?id=${cl.id}">${cl.id}</a></td>
		<td>${cl.firstName}</td>
		<td>${cl.lastName}</td>
	  	<td>${cl.location}</td>
	</tr>
</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>