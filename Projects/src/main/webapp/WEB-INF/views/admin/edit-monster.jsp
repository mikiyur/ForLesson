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
                        <td><input class="form-control" name="picture" id="picture" type="text"
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
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>level</td>
                    <td>${monster.level}</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>maxHealthPoint</td>
                    <td>${monster.maxHealthPoint}</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>maxManaPoint</td>
                    <td>${monster.maxManaPoint}</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>power</td>
                    <td>${monster.power}</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>spellPower</td>
                    <td>${monster.spellPower}</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">9</th>
                    <td>defence</td>
                    <td>${monster.defence}</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>criticalAttack</td>
                    <td>${monster.criticalAttack}%</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">11</th>
                    <td>chanceCriticalAttack</td>
                    <td>${monster.chanceCriticalAttack}%</td>
                    <td>Edit</td>
                </tr>
                <tr>
                    <th scope="row">12</th>
                    <td>chanceDodge</td>
                    <td>${monster.chanceDodge}%</td>
                    <td>Edit</td>
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