<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form class="m-5" method="POST" action="/fight/${hero.id}">
    <div class="row">
        <div class="col-2 text-right">
            <span>Name ${hero.name}</span>
            <p></p>
            <span>HP</span>
            <p>${hero.maxHealthPoint}/${hero.currentHealthPoint}</p>
            <span>MP</span>
            <p>${hero.maxManaPoint}/${hero.currentManaPoint}</p>
            <span>ATK</span>
            <p>${hero.power}</p>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-2 offset-5">
            <button type="submit" class="btn btn-success btn-lg">Fighter</button>
        </div>
    </div>
</form>

</body>
</html>