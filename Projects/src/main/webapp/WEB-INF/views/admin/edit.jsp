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
<div class="container-fluid mt-2">
    <div class="row">
        <div class="col-4">
            <img src="${location.pictureURL}" class="img-fluid" alt="img">
        </div>
        <div class="col-3 text-center">
            <h4>${location.name}</h4>
            <p>Ready = ${location.ready}</p>
        </div>
        <div class="col-2 text-center">
            <p> Minimum required level - ${location.minLevel} </p>
        </div>
        <div class="col-1 text-center">
            <p> Has boss - ${location.hasBoss}</p>
            <c:if test="${location.hasBoss}">
                <p>Boss name: ${location.bossName}</p>
            </c:if>
            <p> Monsters: ${location.countMonsters}</p>
        </div>
        <div class="col-2 text-center">
            <form class="m-1" method="GET" action="set-ready-true/${location.id}">
                <button class="btn btn-success btn-primary btn-block" type="submit">add to game</button>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-4">
            <form class="m-1" method="GET" action="change-picture/${location.id}">
                <input class="form-control" name="picture" id="picture" type="text" placeholder="https://....jpeg">
                <button class="btn btn-success btn-primary btn-block" type="submit">change picture</button>
            </form>
        </div>
        <div class="col-3 text-center">
            <form class="m-1" method="GET" action="change-name/${location.id}">
                <input class="form-control" name="name" id="name" type="text" placeholder="location's name">
                <button class="btn btn-success btn-primary btn-block" type="submit">change name</button>
            </form>
        </div>
        <div class="col-2 text-center">
            <form class="m-1" method="GET" action="set-min-level/${location.id}">
                <input class="form-control" name="min-level" id="min-level" type="number" placeholder="0-50">
                <button class="btn btn-success btn-primary btn-block" type="submit">set required level</button>
            </form>
        </div>
        <div class="col-1 text-center">

        </div>
        <div class="col-2 text-center">
            <form class="m-1" method="GET" action="set-ready-false/${location.id}">
                <button class="btn btn-danger btn-primary btn-block" type="submit">remove from game</button>
            </form>
        </div>
    </div>


    <div class="alert alert-success text-center" role="alert">
        <h3>Location's monsters</h3>
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
            <div class="col-1">gang</div>

        </div>
        <div class="row">
            <c:forEach var="monster" items="${locationMonsters}">
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
                <div class="col-1">
                    <small>${monster.gang}</small>
                </div>
                <div class="col-1 text-center">
                    <form class="m-1" method="GET" action="remove/${location.id}/${monster.id}">
                        <button class="btn btn-danger btn-primary btn-block" type="submit">Remove</button>
                    </form>
                </div>
            </c:forEach>
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
            <c:forEach var="monster" items="${allMonsters}">
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
                <div class="col-2 text-center">
                    <form class="m-1" method="GET" action="add/${location.id}/${monster.id}">
                        <label class="mr-sm-2 sr-only" for="gang">gang</label>
                        <select class="custom-select mr-sm-2" id="gang" name="gang">
                            <option selected value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                        </select>
                        <button class="btn btn-success btn-primary btn-block" type="submit">Add</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>