<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль пользователя</title>
</head>
<body>
<br>
<h3>${user.firstName}</h3>
<h3>${user.lastName}</h3>
<br>
<form method="post" action="/userPage/update">
    <label> Имя
        <input name="firstName"
               value="${user.firstName}"
               pattern="[a-zA-Zа-яА-Я]{2,20}">
    </label>
    <label> Фамилия
        <input name="lastName"
               value="${user.lastName}"
               pattern="[a-zA-Zа-яА-Я]{2,20}">
    </label>
    <label> Email
        <input type="email"
               name="email"
               value="${user.email}">
    </label>
    <input type="submit" value="Сохранить">
</form>
<#if errors??>
    <h4 style="color: red">${errors}</h4>
</#if>
<br>
<a href="/home">Вернуться в профиль</a>
</body>
</html>