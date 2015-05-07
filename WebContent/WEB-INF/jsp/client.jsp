<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<title>Клиент</title>

<a href="test.html"> 
	<div class="mybuttonl">
	Главная
	</div>
</a>

<a href="clients.html"> 
	<div class="mybuttonr">
	Список клиентов
	</div>
</a>

<p><strong>Информация о клиенте № ${client.id}</strong></p>

<table>
	<tr>
		<th>Имя</th>
		<th>Фамилия</th>
		<th>Город</th>
		<th>Адрес</th>
		<th>E-mail</th>
		<th>Телефон</th>
	</tr>
	
	<tr>
		<td>${client.firstName}</td>
		<td>${client.lastName}</td>
		<td>${client.location}</td>
	  	<td>${client.address}</td>
	  	<td>${client.email}</td>
	  	<td>${client.phone}</td>
	</tr>
</table>

<p><strong>Информация о заказах:</strong></p>

<table>
	<tr>
		<th>Номер заказа</th>
		<th>Регистрационный номер автомобиля</th>
		<th>Дата</th>
		<th>Тест-драйв</th>
		<th>Статус</th>
	</tr>

	<c:forEach items="${orders}" var="order">
		<tr>
			<td>${order.number}</td>
			<td>${order.carId}</td>
		  	<td>${order.date}</td>
		  	<td>${order.testdrive}</td>
		  	<td>${order.status}</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>