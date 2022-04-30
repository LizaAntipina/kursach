<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
    <head>
        <title>Авторизация</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href ="static/login.css"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="title">Авторизация</div>
            <form id="loginFormId" name="loginForm" method="post" action="${pageContext.request.contextPath}/controller">
                <div class="field">
                    <input type="text" name="login" required>
                    <label>Логин</label>
                </div>
                <div class="field">
                    <input type="password" name = "password" required>
                    <label>Пароль</label>
                </div>
                <div class="field">
                    <input type="submit" value="Войти">
                </div>
                <div class="signup-link">
                    Нет аккаунта? <a href="register.jsp">Зарегистрироваться</a>
                </div>
                <input name = "command" value="login" hidden/>
            </form>
        </div>
    </body>
 </html>