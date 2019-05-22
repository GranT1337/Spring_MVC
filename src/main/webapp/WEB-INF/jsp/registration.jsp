<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
	<head>
		<title>Регистрация</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
        </script>
		<meta charset="UTF-8">
	       <link rel="icon" type="image/png" href="../images/icon.ico"/>
	       <link rel="stylesheet" type="text/css" href="../css/AuthReg.css">
    </head>
<body>
    <form action="/registration" method="post">
	   <div class="background" style="background-image: url('../images/coffeeBGa.png');">
	       <div class="user">
                <header class="user_header">
                    <h1>Регистрация</h1>
                </header>
                <c:if test="${errors != null}">
                    <div class="errorMessage">
                        <c:forEach var="error" items="${errors}">
        			        ${error.defaultMessage}
                            <br>
                        </c:forEach>
                    </div>
                </c:if>

                <c:if test="${emailbusy != null}">
                    <div class="errorMessage">
                        <div>${emailbusy}</div>
                    </div>
                </c:if>

                <form action="/registration" method="post">
                        <input type="text" name="name" placeholder="Имя" class="form_input" />
                        <input type="text" name="surname" placeholder="Фамилия" class="form_input" />
                        <input type="email" name="email" placeholder="Email" class="form_input"/>
                        <input type="password" name="password" placeholder="Пароль" class="form_input" />
                        <button class="btn" type="submit">Зарегистрироваться</button>
                </form>

                <form class="form2">
                    <button type="button" class="reg" onclick="window.location='/login'">Уже есть аккаунт?</button>
                </form>
            </div>
        </div>
    </form> 
</body>
</html>



