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
    <div class="row">
        <div class="col-2">
        </div>
        <div class="col-8">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Value</th>
                    <th scope="col">Input field</th>
                    <th scope="col">Confirmation</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Picture</td>
                    <td><img src="${monster.pictureURL}" class="img-fluid" alt="img" width="200"></td>
                    <form class="m-1" method="GET" action="monster-change-picture/${monster.id}">
                        <td><input class="form-control" name="picture" id="picture" type="url"
                                   placeholder="https://....jpeg"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change picture</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>name</td>
                    <td>${monster.name}</td>
                    <form class="m-1" method="GET" action="monster-change-name/${monster.id}">
                        <td><input class="form-control" name="name" id="name" type="text"
                                   placeholder="name"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change name</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>is boss</td>
                    <td>${monster.boss}</td>
                    <td>
                        <form class="m-1" method="GET" action="monster-set-boss-true/${monster.id}">
                            <c:if test="${monster.boss}">
                                <button class="btn btn-danger btn-primary btn-block" type="submit" disabled> BOSS
                                </button>
                            </c:if>
                            <c:if test="${!monster.boss}">
                                <button class="btn btn-success btn-primary btn-block" type="submit">set is Boss
                                </button>
                            </c:if>
                        </form>
                    </td>
                    <td>
                        <form class="m-1" method="GET" action="monster-set-boss-false/${monster.id}">
                            <c:if test="${!monster.boss}">
                                <button class="btn btn-secondary btn-primary btn-block" type="submit" disabled>not Boss
                                </button>
                            </c:if>
                            <c:if test="${monster.boss}">
                                <button class="btn btn-success btn-primary btn-block" type="submit">set not Boss
                                </button>
                            </c:if>
                        </form>
                    </td>

                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>level</td>
                    <td>${monster.level}</td>
                    <form class="m-1" method="GET" action="monster-change-level/${monster.id}">
                        <td><input class="form-control" name="level" id="level" type="number" min="1" max="50"
                                   placeholder="1-50"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change level</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>maxHealthPoint</td>
                    <td>${monster.maxHealthPoint}</td>
                    <form class="m-1" method="GET" action="monster-change-health/${monster.id}">
                        <td><input class="form-control" name="health" id="health" type="number" min="1"
                                   placeholder="1-..."></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change health point
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>maxManaPoint</td>
                    <td>${monster.maxManaPoint}</td>
                    <form class="m-1" method="GET" action="monster-change-mana/${monster.id}">
                        <td><input class="form-control" name="mana" id="mana" type="number" min="1"
                                   placeholder="1-..."></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change mana point
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>power</td>
                    <td>${monster.power}</td>
                    <form class="m-1" method="GET" action="monster-change-power/${monster.id}">
                        <td><input class="form-control" name="power" id="power" type="number" min="1"
                                   placeholder="1-..."></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change power</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>spellPower</td>
                    <td>${monster.spellPower}</td>
                    <form class="m-1" method="GET" action="monster-change-spell-power/${monster.id}">
                        <td><input class="form-control" name="spell-power" id="spell-power" type="number" min="1"
                                   placeholder="1-..."></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change spell power
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">9</th>
                    <td>defence</td>
                    <td>${monster.defence}</td>
                    <form class="m-1" method="GET" action="monster-change-defence/${monster.id}">
                        <td><input class="form-control" name="defence" id="defence" type="number" min="1"
                                   placeholder="1-..."></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change defence</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>criticalAttack</td>
                    <td>${monster.criticalAttack}%</td>
                    <form class="m-1" method="GET" action="monster-change-critical/${monster.id}">
                        <td><input class="form-control" name="critical" id="critical" type="number" step="0.1" min="0"
                                   max="500"
                                   placeholder="1-500%"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change critical</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">11</th>
                    <td>chanceCriticalAttack</td>
                    <td>${monster.chanceCriticalAttack}%</td>
                    <form class="m-1" method="GET" action="monster-change-critical-chance/${monster.id}">
                        <td><input class="form-control" name="critical-chance" id="critical-chance" type="number"
                                   step="0.1" min="0" max="75"
                                   placeholder="1-75%"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change critical chance
                            </button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">12</th>
                    <td>chanceDodge</td>
                    <td>${monster.chanceDodge}%</td>
                    <form class="m-1" method="GET" action="monster-change-dodge-chance/${monster.id}">
                        <td><input class="form-control" name="dodge-chance" id="dodge-chance" type="number" step="0.1"
                                   min="0" max="75"
                                   placeholder="1-75%"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change dodge chance
                            </button>
                        </td>
                    </form>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-2">
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>