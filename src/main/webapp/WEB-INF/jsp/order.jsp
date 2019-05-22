<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>YummY</title>
    	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    	</script>

    	<script src="../js/JavaScript.js"></script>
		<meta charset="UTF-8">
		<link rel="icon" type="image/png" href="../images/icon.ico"/>
	   <link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
<body>
	<div id = "header">
		 <img src="../images/logo2.png"  width="800" height="259">
	</div>
		<div id="centreOrder">
    		<h1 id="coffee">Оформление заказа</h1>
    		<h2><div class="centreOnly">Ваш баланс: ${userBalance}₽</div>
            <h2><div class="centreOnly">Вы заказали:</div></h2>
            <ol class="pills">
                <c:forEach var="ending" items="${zakaz}">
                    <li>${ending}</li>
                </c:forEach>
                <c:forEach var="ending1"  items="${zakazAdditional}">
                    <li>${ending1}</li>
                </c:forEach>
            </ol>
            <h2><div class="centreOnly">Сумма к заказу: ${SUM}₽</div></h2>
            <form action="/order" method="post">
                <c:if test="${userBalance >= SUM}">
                <div class = "centreOnly">
                    <input type="submit" class="button button1" value="Купить"> <br>
                </div>
                </c:if>
            </form>
            <div class = "centreOnly">
                <button class="button button3" onclick="window.location='/home'">Отменить заказ, вернуться на домашнюю страницу</button>
            </div>

            <c:if test="${userBalance < SUM}">
                <div class = "centreOnly">
                    <div style="color: red">У вас недостаточно средств!</div>
                    <button class="button button1" onclick="window.location='/topup'">Пополнить баланс</button>
                </div>
            </c:if>
		    <div id=”clearer”></div>
	    </div>
</body>

</html>