<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>YummY</title>
    	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    	</script>
		<meta charset="UTF-8">
		<link rel="icon" type="image/png" href="../images/icon.ico"/>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
<body>
	<div id = "header">
		<img src="../images/logo2.png"  width="800" height="259">
	</div>
	<div id="centreOrder">
		<div class="centreOnly">
    		<h1 id="coffee">Оформление заказа</h1>
    		<h1 style="color: red">${errorMoney}</h1>
    		<h2>Ваш баланс: ${userBalance}₽</h2>
        	<h2>Пополнить заказ на сумму:</h2>
        	<form action="/topup" method="post">
            	<input type="number" name="money" min="0">
               	<input type="submit" class="button button1" value="Внести">
        	</form>
        	<br>
        	<br>
        	<button class="button button3" onclick="window.location='/home'">Вернуться назад</button>
    	</div>
	</div>
	<div id=”clearer”></div>
</body>

</html>