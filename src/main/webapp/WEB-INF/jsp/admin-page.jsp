<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Админ-панель</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    </script>
    <script src="../js/popUp.js"></script>
	<meta charset="UTF-8">
	<link rel="icon" type="image/png" href="../images/icon.ico"/>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
<body>
	<div id = "header">
		<img src="../images/logo2.png"  width="800" height="259">
	</div>
	<div id = "content">
		<div id="centreOrder">
			<div class="centreOnly">
        		<button type="button" class="button button3" onclick="window.location='/logout'">Выйти из профиля</button>
        		<button type="button" class="button button1" onclick="window.location='/home'">Домой</button>
				<br>
				<br>
				<br>
				<br>
				Внимание! Следующие ингредиенты заканчиваются, следует пополнить склад!
				<ol class="pillsAdmin">
					<c:forEach var="ending" items="${ingredients_ending}">
                        <li>${ending.name} - Осталось ${ending.quantityOstatok} ${ending.unit}</li>
        			</c:forEach>
					<c:forEach var="endingAdditional" items="${additional_ingredients_ending}">
                        <li>${endingAdditional.name} - Осталось ${endingAdditional.quantity} порций</li>
        			</c:forEach>
    			</ol>

				<input type="button" id="addOnMenu" class="button button1" onclick="PopUpShow1()" value="Добавить дополнительные ингредиенты">
				<input type="button" id="addOnMenuZ" class="button button1" onclick="PopUpShow2()" value="Добавить основные ингредиенты">
			</div>

			<form action="/admin" method="post">
 				<div id="openModal" class="modalDialog">
      				<div>
          				<a href="javascript:PopUpHide1()" title="Закрыть" class="close">X</a>
          				<h2>Добавить дополнительные ингредиенты</h2>
          				<div class="centreOnly">
							<div>
							Выберите категорию:
							<select name="AdditionalIngr">
                            	<c:forEach var="ingr" items="${addINGREDIENT}">
                              		<option value="${ingr.name}">${ingr.name}</option>
                              	</c:forEach>
                            </select>
							</div>

            				<div>
            					Введите количество:
            				</div>
            				<input type="text" name="quantity" class="addNewCoffee"/>

        				</div>
          				<div class="centreOnly">
    		    			<button type="submit" class="add">Добавить</button>
		     			 </div>
     	 			</div>
  				</div>
  			</form>

			<form action="/admin" method="post">
 				<div id="ingredientsPopUp" class="modalDialog">
      				<div>
         				<a href="javascript:PopUpHide2()" title="Закрыть" class="close">X</a>
          				<h2>Добавить ингредиенты</h2>
          				<div class="centreOnly">
							<div>
								Выберите категорию:
								<select name="Ingr">
                              		<c:forEach var="ingredient" items="${INGREDIENT}">
                              			<option value="${ingredient.name}">${ingredient.name}</option>
                              		</c:forEach>
                              	</select>
							</div>
            				<div>
            					Введите количество:
            				</div>
            				<input type="text" name="quantity" class="addNewCoffee"/>
        				</div>
          				<div class="centreOnly">
    		    			<button type="submit" class="add">Добавить</button>
		      			</div>
      				</div>
  				</div>
  			</form>
 		</div>
	</div>
</body>
</html>







