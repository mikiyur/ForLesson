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
            <form class="m-1" method="GET" action="create-hero-class">
                <button class="btn btn-success btn-primary btn-block" type="submit">Create new hero-class</button>
            </form>
            <p> </p>
            <p> </p>
        </div>
    </div>
    <div class="alert alert-dark text-center" role="alert">
        <h3> All hero-classes </h3>
        <div class="row">
            <div class="col-1">picture</div>
            <div class="col-1">name</div>
            <div class="col-1">max-health per skill-point</div>
            <div class="col-1">max-mana per skill-point</div>
            <div class="col-1">power per skill-point</div>
            <div class="col-1">spell-power per skill-point</div>
            <div class="col-1">defence per skill-point</div>
            <div class="col-1">critical-attack per skill-point</div>
            <div class="col-1">chance-critical-attack per skill-point</div>
            <div class="col-1">chance-dodge per skill-point</div>
            <div class="col-2">Edit/Remove</div>
        </div>
        <div class="row">
            <c:forEach var="heroClass" items="${heroClasses}">
                <div class="col-1">
                    <img src="${heroClass.pictureURL}" class="img-fluid" alt="img">
                </div>
                <div class="col-1">
                    <small>${heroClass.name}</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.maxHealthPerSkillPoint}</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.maxManaPerSkillPoint}</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.powerPerSkillPoint}</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.spellPowerPerSkillPoint}</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.defencePerSkillPoint}</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.criticalAttackPerSkillPoint}%</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.chanceCriticalAttackPerSkillPoint}%</small>
                </div>
                <div class="col-1">
                    <small>${heroClass.chanceDodgePerSkillPoint}%</small>
                </div>
                <div class="col-1 text-center">
                    <form class="m-1" method="GET" action="edit-hero-class/${heroClass.id}">
                        <button class="btn btn-info btn-primary btn-block" type="submit">Edit</button>
                    </form>
                </div>
                <div class="col-1 text-center">
                    <form class="m-1" method="GET" action="remove-hero-class/${heroClass.id}">
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