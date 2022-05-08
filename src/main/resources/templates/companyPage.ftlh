<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль компании</title>
</head>
<body>
<h1>Личный кабинет</h1>
<h2>${user.firstName} ${user.lastName}</h2>
<a href="/userPage">Изменить данные пользователя</a>
<br>
<h3>Добавить билеты в продажу</h3>
<br>
<form method="post" action="/companyPage">
    <label> Направление
        <input name="direction" placeholder="Направление">
    </label>
    <label> Номер рейса
        <input name="flightNum" placeholder="Номер рейса">
    </label>
    <label> Дата вылета
        <input type="date" name="date" placeholder="Дата">
    </label>
    <input type="submit" value="Добавить">
    <#if errors??>
        <h4 style="color: red">${errors}</h4>
    </#if>
</form>
<br>
<table>
    <tr>
        <th>Направление</th>
        <th>Номер рейса</th>
        <th>Дата</th>
        <th>Действия</th>
    </tr>
    <#list ticketsOnSale as ticket>
        <tr>
            <td>${ticket.direction}</td>
            <td>${ticket.flightNum}</td>
            <td>${ticket.date}</td>
            <td>
                <form method="post" action="/companyPage/${ticket.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/companyPage/${ticket.id}">Открыть</a>
            </td>
        </tr>
    </#list>
</table>

</body>
</html>