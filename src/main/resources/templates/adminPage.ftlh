<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль администратора</title>
</head>
<body>
<h1>Личный кабинет</h1>
<h2>${user.firstName} ${user.lastName}</h2>
<a href="/userPage">Изменить данные пользователя</a>
<br>
<h3>Список запросов</h3>
<br>
<table>
<tr>
    <th>Направление</th>
    <th>Номер рейса</th>
    <th>Дата вылета</th>
    <th>Статус</th>
    <th>Действия</th>
</tr>
<#list requests as request>
    <tr>
        <td>${request.direction}</td>
        <td>${request.flightNum}</td>
        <td>${request.date}</td>
        <td>${request.status}</td>
        <td>
            <form method="post" action="/adminPage/${request.id}/Conform">
                <input type="submit" value="Подтвердить">
            </form>
            <form method="post" action="/adminPage/${request.id}/Decline">
                <input type="submit" value="Отклонить">
            </form>
        </td>
    </tr>
</#list>
        <#list requestsToReturn as rRequset>
            <tr>
            <td>${rRequset.direction}</td>
            <td>${rRequset.flightNum}</td>
            <td>${rRequset.date}</td>
            <td>${rRequset.status}</td>
            <td>
                <form method="post" action="/adminPage/${rRequset.id}/ReturnDecline">
                    <input type="submit" value="Вернуть пользователю">
                </form>
                <form method="post" action="/adminPage/${rRequset.id}/Decline">
                    <input type="submit" value="Вернуть в продажу">
                </form>
            </td>
            </tr>
        </#list>
</table>
</body>
</html>