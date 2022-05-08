<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>
</head>
<body>
<form method="post" action="/signIn">
    <label>Email:
        <input type="email"
               name="email"
               placeholder="Введите email"
               required="required">
    </label>
    <label>Password:
        <input type="password"
               name="password"
               placeholder="Введите пароль"
               required="required">
    </label>
    <input type="submit" value="Вход">
</form>
</body>
</html>