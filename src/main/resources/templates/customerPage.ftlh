<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль покупателя</title>
</head>
<body>
<h1>Личный кабинет</h1>
<h2>${user.firstName} ${user.lastName}</h2>
<a href="/userPage">Изменить данные пользователя</a>
<br>
<h3>Мои билеты</h3>
<table>
    <tr>
        <th>Направление</th>
        <th>Номер рейса</th>
        <th>Дата</th>
        <th>Статус</th>
        <th>Действия</th>
    </tr>
    <#list conformedTickets as cTicket>
        <tr>
            <td>${cTicket.direction}</td>
            <td>${cTicket.flightNum}</td>
            <td>${cTicket.date}</td>
            <td>${cTicket.status}</td>
            <td>
                <form action="/customerPage/${cTicket.id}">
                    <input type="submit" value="Подробнее">
                </form>
            </td>
        </tr>
    </#list>
    <#list rejectedReturns as Ticket>
    <tr>
        <td>${Ticket.direction}</td>
        <td>${Ticket.flightNum}</td>
        <td>${Ticket.date}</td>
        <td>${Ticket.status}</td>
        <td>
            <form action="/customerPage/${Ticket.id}">
                <input type="submit" value="Подробнее">
            </form>
        </td>
    </tr>
    </#list>
</table>
<br>
<h3>Список моих запросов</h3>
<table>
    <tr>
        <th>Направление</th>
        <th>Номер рейса</th>
        <th>Дата</th>
        <th>Статус</th>
    </tr>
    <#list ticketsOnRequestByOwner as ticket>
        <tr>
            <td>${ticket.direction}</td>
            <td>${ticket.flightNum}</td>
            <td>${ticket.date}</td>
            <td>${ticket.status}</td>
        </tr>
    </#list>
    <#list requestsToReturn as ticket>
        <tr>
            <td>${ticket.direction}</td>
            <td>${ticket.flightNum}</td>
            <td>${ticket.date}</td>
            <td>${ticket.status}</td>
        </tr>
    </#list>
</table>
<br>
<h3>Билеты в продаже</h3>
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
                <form method="post" action="/customerPage/${ticket.id}/buy">
                    <input type="submit" value="Купить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>