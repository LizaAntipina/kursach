<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация</title>
        <link rel = "stylesheet" href ="${pageContext.request.contextPath}/static/register.css"/>
        <script type="text/javascript" src = "${pageContext.request.contextPath}/js/validator.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="title">Регистрация</div>
            <form id="reg-form" name="form" action="${pageContext.request.contextPath}/controller" method="post" onsubmit="return validate()">
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Имя</span>
                        <input type="text" name = "firstname" placeholder="Введите имя" required/>
                    </div>
                    <div class="input-box">
                        <span class="details">Фамилия</span>
                        <input type="text" name = "lastname" placeholder="Введите фамилию" required/>
                    </div>
                    <div class="input-box">
                        <span class="details">Логин</span>
                        <input type="text" name = "login" placeholder="Введите логин" required/>
                    </div>
                    <div class="input-box">
                        <span class="details">Номер телефона</span>
                        <input type="text" name = "telephone" placeholder="Введите номер телефона" required/>
                    </div>
                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="text" name = "email" placeholder="Введите свой email" required/>
                    </div>
                    <div class="input-box">
                        <span class="details">Пароль</span>
                        <input type="password" name = "password" placeholder="Введите пароль" required/>
                    </div>
                    <div class="button">
                        <input type="submit" value="Создать аккаунт" onclick="validate()">
                    </div>
                    <input name = "command" value="register"  hidden/>
                </div>
            </form>
        </div>
    </body>
 </html>