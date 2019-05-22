<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
  <head>
		<title>YummY</title>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    	</script>
    	<script src="../js/addDrink.js"></script>
		  <meta charset="UTF-8">
		  <link rel="icon" type="image/png" href="../images/icon.ico"/>
	    <link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
<body>
	<div id = "header">
		 <img src="../images/logo2.png"  width="800" height="259">
	</div>
	<div id = "content">
		<div id="left">
		  <ul class="menu">
			 <li>
				<a href="#coffee">
					<strong>Кофе</strong>
				</a>
			 </li>
			 <li>
				<a href="#tea">
					<strong>Чай</strong>
				</a>
			 </li>
		  </ul>
		</div>

		<div id="centre">
    	<h1 id="coffee">Классическое кофе</h1>
        <table class="tablica" cellpadding="10">
          <c:forEach var="item" items="${COFFEE}" varStatus="status">
            <tr class="border_bottom">
              <td class="photo"> 
                <img class="img" src="${item.photo_link}">
              </td>
              <td valign="top" class="label" name="title1">
                ${item.title}
              </td>
              <td class="volume">
                ${item.weight} мл.
              </td>
              <td class="money">
                <div name="price1">${item.price}₽</div>
              </td>
            </tr>
          </c:forEach>
        </table>

      <h1 id="tea">Может по чаю?</h1>
				<table class="tablica" cellpadding="10">
          <c:forEach var="item" items="${TEA}" varStatus="status">
            <tr class="border_bottom">
              <td class="photo"> 
                <img class="img" src="${item.photo_link}">
              </td>
              <td valign="top" class="label">
                ${item.title}
              </td>
              <td class="volume">
                ${item.weight} мл.
              </td>
              <td class="money">
                ${item.price}₽
              </td>
            </tr>
          </c:forEach>
        </table>          
 		</div>
    <div id="output">
    	<div class="centreOnly"> 
        Привет, ${userName}! 
      </div>

      <div class="centreOnly">
        Ваш баланс: ${userBalance}₽
        <a href="/topup" ><img src="../images/plus.png" width="15" 
        height="15" alt="Пополнить"></a>
      </div>

      <button type="button" class="button button3" onclick="window.location='/logout'">
        Выйти из профиля
      </button>

      <c:if test="${currentUserRole == 'ADMIN'}">
        <a href="/admin">
          <button type="button" class="button button1">Зайти в админку</button>
        </a>
      </c:if>
		</div>

		<div id="right">
      <h2>Заказ</h2>
        <form action="/home" method="post" name="resForm" id="resForm">
          <div class="form-block"> Ваш напиток: <br>
            <span id="drink_input">
              <div class="vibor">
                <select name="items">
                  <optgroup label="Кофе">
                    <c:forEach var="item" items="${COFFEE}">
                      <option value="${item.title}">${item.title}</option>
                    </c:forEach>
                  </optgroup>
                  <optgroup label="Чай">
                    <c:forEach var="item" items="${TEA}">
                      <option value="${item.title}">${item.title}</option>
                    </c:forEach>
                  </optgroup>
                </select>
              </div>
              <br>
              Дополнительные ингредиенты:
              <select size="6" multiple name="ingr[]">
                <c:forEach var="ingr" items="${addINGREDIENT}">
                  <option value="${ingr.name}">${ingr.name} || ${ingr.price}₽</option>
                </c:forEach>
              </select>
              <br>
              <br>
              <div class="centreOnly">Количество сахара: 
                <input type="number" max="5" min="0" value="2" name="sugar[]" style="width: 6em;">
              </div>
              <br>
            </span>
          </div>

          <a id="add_btn" class="button button1">Добавить ещё напиток</a>
            <div class = "centreOnly">
            	<input type="submit" value="Оформить заказ" class="button button1" >
            </div>
        </form>
      </div>
		  <div id=”clearer”></div>
	 </div>
</body>

</html>







