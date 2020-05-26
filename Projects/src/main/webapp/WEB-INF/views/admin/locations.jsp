<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container mt-2">
    <c:forEach var="location" items="${locations}">
        <div class="row">
            <div class="col-4">
                <img src="${location.pictureURL}" class="img-fluid" alt="img">
            </div>
            <div class="col-2 text-center">
                <h4>${location.name}</h4>
                <p>Ready = ${location.ready}</p>
            </div>
            <div class="col-2 text-center">
                <p> Has boss - ${location.hasBoss}</p>
                <c:if test="${location.hasBoss}">
                    <p>Boss name: ${location.bossName}</p>
                </c:if>
                <p> Monsters: ${location.countMonsters}</p>
            </div>
            <div class="col-2 text-center">
                <form class="m-1" method="GET" action="edit/${location.id}">
                    <button class="btn btn-info btn-primary btn-block" type="submit">Edit</button>
                </form>
            </div>
            <div class="col-2 text-center">
                <form class="m-1" method="GET" action="remove/${location.id}">
                    <button class="btn btn-danger btn-primary btn-block" type="submit">Delit</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="color-rect-border"></div>
        </div>
    </c:forEach>
</div>
<div class="container mt-5">
    <div class="col-12 text-center">
        <form class="m-1" method="GET" action="create">
            <button class="btn btn-success btn-primary btn-block" type="submit">Create new location</button>
        </form>
    </div>
</div>
</body>
</html>