<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>

</head>
<body>
<form method="post" action="/signUp">
    <table>
        <tr>
            <td>
                <label>
                    <select size="1" name="role" required="required">
                        <option selected="" disabled="" value=''>Зарегистрироваться как...</option>
                        <option value="ADMIN">Администратор</option>
                        <option value="CUSTOMER">Покупатель</option>
                        <option value="COMPANY">Авиакомпания</option>
                    </select>
                </label>
            </td>
        </tr>
    </table>
    <label>Имя:
        <input name="firstName"
               placeholder="Введите имя"
               required="required"
               pattern="[a-zA-Zа-яА-Я]{2,20}">
    </label>
    <label>Фамилия:
        <input name="lastName"
               placeholder="Введите фамилию"
               required="required"
               pattern="[a-zA-Zа-яА-Я]{2,20}">
    </label>
    <label>email:
        <input type="email"
               name="email"
               placeholder="Введите email"
               required="required"
               pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z]{2,4}$">
    </label>
    <label>password:
        <input type="password"
               name="password"
               placeholder="Введите пароль"
               required="required">
    </label>
    <input type="submit" value="Регистрация">
</form>
</body>
</html>