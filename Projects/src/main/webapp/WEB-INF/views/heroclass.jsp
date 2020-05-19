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
<div class="row mt-4">
    <div class="col-2 offset-5">
        <button type="submit" class="btn btn-success btn-lg">Fight</button>
    </div>
</div>
</form>
<div>
    <c:forEach var="heroclass" items="${heroclasses}">
        <tr>
            <form class="m-5" method="POST" action="${heroclass.name}">
                <button class="btn btn-lg btn-primary btn-block" type="submit">${heroclass.name}</button>
            </form>
        </tr>
    </c:forEach>
</div>
<div class="container text-center">
    <div class="row">
        <div class="col-md">
            One of three columns
        </div>
        <div class="col-md">
            Two of three columns
        </div>
        <div class="col-md">
            Three of three columns
        </div>
    </div>
</div>
</body>
</html>