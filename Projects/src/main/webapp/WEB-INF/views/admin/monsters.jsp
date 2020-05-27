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
<jsp:include page="header.jsp"/>
<div class="container-fluid mt-2">
    <div class="container mt-5">
        <div class="col-12 text-center">
            <form class="m-1" method="GET" action="create-monster">
                <button class="btn btn-success btn-primary btn-block" type="submit">Create new monster</button>
            </form>
            <p> </p>
            <p> </p>
        </div>
    </div>
    <div class="alert alert-dark text-center" role="alert">
        <h3> All monsters </h3>
        <div class="row">
            <div class="col-1">name</div>
            <div class="col-1">level</div>
            <div class="col-1">health point</div>
            <div class="col-1">mana point</div>
            <div class="col-1">power</div>
            <div class="col-1">spell power</div>
            <div class="col-1">defence</div>
            <div class="col-1">critical attack</div>
            <div class="col-1">chance critical attack</div>
            <div class="col-1">chance dodge</div>
            <div class="col-2">Add to Location's gang</div>
        </div>
        <div class="row">
            <c:forEach var="monster" items="${monsters}">
                <div class="col-1">
                    <small>${monster.name}</small>
                    <c:if test="${monster.boss}">
                        <p>
                            <small>--Boss--</small>
                        </p>
                    </c:if>
                </div>
                <div class="col-1">
                    <small>${monster.level}</small>
                </div>
                <div class="col-1">
                    <small>${monster.maxHealthPoint}</small>
                </div>
                <div class="col-1">
                    <small>${monster.maxManaPoint}</small>
                </div>
                <div class="col-1">
                    <small>${monster.power}</small>
                </div>
                <div class="col-1">
                    <small>${monster.spellPower}</small>
                </div>
                <div class="col-1">
                    <small>${monster.defence}</small>
                </div>
                <div class="col-1">
                    <small>${monster.criticalAttack}</small>
                </div>
                <div class="col-1">
                    <small>${monster.chanceCriticalAttack}%</small>
                </div>
                <div class="col-1">
                    <small>${monster.chanceDodge}%</small>
                </div>
                <div class="col-1 text-center">
                    <form class="m-1" method="GET" action="edit-monster/${monster.id}">
                        <button class="btn btn-info btn-primary btn-block" type="submit">Edit</button>
                    </form>
                </div>
                <div class="col-1 text-center">
                    <form class="m-1" method="GET" action="remove-monster/${monster.id}">
                        <button class="btn btn-danger btn-primary btn-block" type="submit">Remove</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="../footer.jsp"/>
</body>
</html>