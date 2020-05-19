<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="text-center">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">
    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 400px; margin: 10px">
            <img src="https://i.ibb.co/312Xn3z/6ewsd6u2-900.jpg" alt="Game" width="180" height="180">
            <h4 class="card-title mt-1 text-center">Create Account</h4>

            <form>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="" class="form-control" placeholder="User name" type="text">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input name="" class="form-control" placeholder="Email address" type="email">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                    </div>
                    <select class="custom-select" style="max-width: 120px;">
                        <option selected="">+380</option>
                        <option value="1">+971</option>
                        <option value="2">+972</option>
                        <option value="3">+198</option>
                    </select>
                    <input name="" class="form-control" placeholder="Phone number" type="text">
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Create password" type="password">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input class="form-control" placeholder="Repeat password" type="password">
                </div> <!-- form-group// -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
                </div> <!-- form-group// -->
                <p class="text-center">Have an account? <a href="/login">Log In</a> </p>
            </form>
        </article>
    </div> <!-- card.// -->

</div>
<!--container end.//-->

</body>
</html>