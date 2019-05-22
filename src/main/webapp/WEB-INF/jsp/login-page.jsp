<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Добро пожаловать!</title>
        <meta charset="UTF-8">
           <link rel="icon" type="image/png" href="../images/icon.ico"/>
           <link rel="stylesheet" type="text/css" href="../css/AuthReg.css">
    </head>
<body>

    <div class="background" style="background-image: url('../images/coffeeBGa.png');">
        <div class="user">
            <header class="user_header">
            <h1>Авторизация</h1>
            </header>


            <form action="/login" method="post">
              <c:if test="${errorMsg != null}">
                  <div class="errorMessage">
                    <div style="font-weight: 600;">
                      Не удается войти<br>
                      <br>
                    </div>
                    ${errorMsg}
                  </div>
              </c:if>
                <input type="email" name="email" value="${email}" placeholder="Email" class="form_input" />
                <input type="password" name="password" placeholder="Пароль" class="form_input" />
                <input type="submit" class="btn" value="Войти">
            </form>
            <form class="form2">
              <button type="button" class="reg" onclick="window.location='/registration'">Нет аккаунта?</button>
            </form>
        </div>
    </div>
</body>
</html>