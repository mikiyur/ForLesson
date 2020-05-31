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
<div class="container mt-2">
    <div class="row">
        <div class="col-5 text-center">
            <h5>class ${hero.heroClass.name} ${hero.name}</h5>
            <div class="row">
                <div class="col-5 text-right">
                    <p style="margin-bottom: 0px; margin-top: 5px">Health Point</p>
                    <div class="progress">
                        <div class="progress-bar bg-danger" role="progressbar"
                             style="width: ${hero.currentHealthPoint/hero.maxHealthPoint*100}%">${hero.currentHealthPoint}/${hero.maxHealthPoint}</div>
                    </div>
                    <p style="margin-bottom: 0px; margin-top: 5px">Mana Point</p>
                    <div class="progress">
                        <div class="progress-bar bg-info" role="progressbar"
                             style="width: ${hero.currentManaPoint/hero.maxManaPoint*100}%">${hero.currentManaPoint}/${hero.maxManaPoint}</div>
                    </div>
                    <p style="margin-bottom: 0px; margin-top: 5px">Power</p>
                    <p style="margin: 0px">${hero.power}</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Defence</p>
                    <p style="margin: 0px">${hero.defence}</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Spell power</p>
                    <p style="margin: 0px">${hero.spellPower}</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Critical attack</p>
                    <p style="margin: 0px">${hero.criticalAttack}%</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Chance critical attack</p>
                    <p style="margin: 0px">${hero.chanceCriticalAttack}%</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Chance dodge</p>
                    <p style="margin: 0px">${hero.chanceDodge}%</p>
                </div>
                <div class="col-7">
                    <img src=${hero.pictureURL} class="img-fluid" alt="Responsive image">
                </div>
            </div>
        </div>
        <div class="col-2 text-center">
            <div style="margin-top: 150px"></div>
            <form class="m-2" method="GET" action="attack/${monster.id}">
                <button type="submit" class="btn btn-danger">Attack</button>
            </form>
            <div style="margin-top: 100px"></div>
            <form class="m-2" method="POST" action="/use-spell/${hero.id}">
                <button type="submit" class="btn btn-warning">Use spell</button>
            </form>
            <div style="margin-top: 50px"></div>
            <form class="m-2" method="POST" action="/use-potion/${hero.id}">
                <button type="submit" class="btn btn-success">Use potion</button>
            </form>
        </div>
        <div class="col-5 text-center">
            <h5> lv. ${monster.level} ${monster.name} </h5>
            <div class="row">
                <div class="col-7">
                    <img src=${monster.pictureURL} class="img-fluid" alt="Responsive image">
                </div>
                <div class="col-5 text-left">
                    <p style="margin-bottom: 0px; margin-top: 5px">Health Point</p>
                    <div class="progress">
                        <div class="progress-bar bg-danger" role="progressbar"
                             style="width: ${monster.currentHealthPoint/monster.maxHealthPoint*100}%">${monster.currentHealthPoint}/${monster.maxHealthPoint}</div>
                    </div>
                    <p style="margin-bottom: 0px; margin-top: 5px">Mana Point</p>
                    <div class="progress">
                        <div class="progress-bar bg-info" role="progressbar"
                             style="width: ${monster.currentManaPoint/monster.maxManaPoint*100}%">${monster.currentManaPoint}/${monster.maxManaPoint}</div>
                    </div>
                    <p style="margin-bottom: 0px; margin-top: 5px">Power</p>
                    <p style="margin: 0px">${monster.power}</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Defence</p>
                    <p style="margin: 0px">${monster.defence}</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Spell power</p>
                    <p style="margin: 0px">${monster.spellPower}</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Critical attack</p>
                    <p style="margin: 0px">${monster.criticalAttack}%</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Chance critical attack</p>
                    <p style="margin: 0px">${monster.chanceCriticalAttack}%</p>
                    <p style="margin-bottom: 0px; margin-top: 5px">Chance dodge</p>
                    <p style="margin: 0px">${monster.chanceDodge}%</p>
                    <h5 style="margin-bottom: 0px; margin-top: 10px">Other monsters:</h5>
                    <c:forEach var="monsterPassive" items="${monstersGang}">
                        <p style="margin-bottom: 0px; margin-top: 5px">${monsterPassive.name}</p>
                        <div class="progress">
                            <div class="progress-bar bg-danger" role="progressbar"
                                 style="width: ${monsterPassive.currentHealthPoint/monsterPassive.maxHealthPoint*100}%">${monsterPassive.currentHealthPoint}/${monsterPassive.maxHealthPoint}</div>
                        </div>
                        <div class="progress">
                            <div class="progress-bar bg-info" role="progressbar"
                                 style="width: ${monsterPassive.currentManaPoint/monsterPassive.maxManaPoint*100}%">${monsterPassive.currentManaPoint}/${monsterPassive.maxManaPoint}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <p> </p>
    <div class="alert alert-warning  text-center" role="alert">
        <h6 >- - * * Fight log * * - -</h6>
        <p>Hero: ${hero.fightLog}</p>
        <p>Monster: ${hero.fightLogMonster}</p>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>