<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Мой билет ${ticket.flightNum}</title>
</head>
<body>
<h3>Направление полета - ${ticket.direction}</h3>
<h3>Номер рейса - ${ticket.flightNum}</h3>
<h3>Дата вылета - ${ticket.date}</h3>
<h3>Статус - ${ticket.status}</h3>
<br>
<form method="post" action="customerPage/${ticket.id}/return">
    <label> Возврат билета
        <input name="status" value="Укажите причину">
    </label>
    <input type="submit" value="Отправить запрос">
</form>
</body>
</html>