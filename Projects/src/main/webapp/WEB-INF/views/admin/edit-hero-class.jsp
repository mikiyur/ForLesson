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
            <table class="table table-sm table-striped">
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
                    <td><img src="${heroClass.pictureURL}" class="img-fluid" alt="img" width="120"></td>
                    <form class="m-1" method="GET" action="hero-class-change-picture/${heroClass.id}">
                        <td><input class="form-control" name="picture" id="picture" type="url"
                                   placeholder="https://....jpeg"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>name</td>
                    <td>${heroClass.name}</td>
                    <form class="m-1" method="GET" action="hero-class-change-name/${heroClass.id}">
                        <td><input class="form-control" name="name" id="name" type="text"
                                   placeholder="name"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>max-health per skill-point</td>
                    <td>${heroClass.maxHealthPerSkillPoint}</td>
                    <form class="m-1" method="GET" action="hero-class-change-health/${heroClass.id}">
                        <td><input class="form-control" name="maxHealthPerSkillPoint" id="maxHealthPerSkillPoint"
                                   type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>max-mana per skill-point</td>
                    <td>${heroClass.maxManaPerSkillPoint}</td>
                    <form class="m-1" method="GET" action="hero-class-change-mana/${heroClass.id}">
                        <td><input class="form-control" name="maxManaPerSkillPoint" id="maxManaPerSkillPoint"
                                   type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>power per skill-point</td>
                    <td>${heroClass.powerPerSkillPoint}</td>
                    <form class="m-1" method="GET" action="hero-class-change-power/${heroClass.id}">
                        <td><input class="form-control" name="powerPerSkillPoint" id="powerPerSkillPoint" type="number"
                                   step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>spell-power per skill-point</td>
                    <td>${heroClass.spellPowerPerSkillPoint}</td>
                    <form class="m-1" method="GET" action="hero-class-change-spell-power/${heroClass.id}">
                        <td><input class="form-control" name="spellPowerPerSkillPoint" id="spellPowerPerSkillPoint" type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>defence per skill-point</td>
                    <td>${heroClass.defencePerSkillPoint}</td>
                    <form class="m-1" method="GET" action="hero-class-change-defence/${heroClass.id}">
                        <td><input class="form-control" name="defencePerSkillPoint" id="defencePerSkillPoint"
                                   type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>critical-attack per skill-point</td>
                    <td>${heroClass.criticalAttackPerSkillPoint}%</td>
                    <form class="m-1" method="GET" action="hero-class-change-critical-attack/${heroClass.id}">
                        <td><input class="form-control" name="criticalAttackPerSkillPoint"
                                   id="criticalAttackPerSkillPoint" type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">9</th>
                    <td>chance-critical-attack per skill-point</td>
                    <td>${heroClass.chanceCriticalAttackPerSkillPoint}%</td>
                    <form class="m-1" method="GET" action="hero-class-change-chance-critical-attack/${heroClass.id}">
                        <td><input class="form-control" name="chanceCriticalAttackPerSkillPoint"
                                   id="chanceCriticalAttackPerSkillPoint" type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
                        </td>
                    </form>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>chance-dodge per skill-point</td>
                    <td>${heroClass.chanceDodgePerSkillPoint}%</td>
                    <form class="m-1" method="GET" action="hero-class-chance-dodge/${heroClass.id}">
                        <td><input class="form-control" name="chanceDodgePerSkillPoint" id="chanceDodgePerSkillPoint" type="number" step="0.1"
                                   min="0.1" max="10.0" placeholder="0.1-10.0"></td>
                        <td>
                            <button class="btn btn-success btn-primary btn-block" type="submit">change</button>
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