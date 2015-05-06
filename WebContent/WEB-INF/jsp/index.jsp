<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<title>Главная страница</title>

<a href="cars"> 
	<div class="mybuttonl">
	Автомобили
	</div>
</a>

<a href="clients"> 
	<div class="mybuttonr">
	Клиенты
	</div>
</a>

<table>
<tr>
	<th>Номер заказа</th>
	<th>Регистрационный номер автомобиля</th>
	<th>Имя клиента</th>
	<th>Дата</th>
	<th>Тест-драйв</th>
	<th>Статус</th>
</tr>

<c:forEach items="${orders}" var="order">
	<tr>
		<td>${order.number}</td>
		<td><a href="car?id=${car.reg_number}"> №${order.car_id}</a></td>
		<td><a href="client?id=${order.client_id}"> №${order.client}</a></td>
	  	<td>${order.date}</td>
	  	<td>${order.testrive}</td>
	  	<td>${order.status}</td>
	</tr>
</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>