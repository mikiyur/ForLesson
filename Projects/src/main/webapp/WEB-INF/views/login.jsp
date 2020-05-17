<!DOCTYPE HTML>
<html lang="en" >
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body class="text-center">
<div class="container">
    <div class="card bg-light">
        <div class="row pl" style="margin-top: 30px">
            <div class="col-sm-8 col-sm-offset-2" style="margin: auto">
                <form:form class="form-horizontal" action="/login" method="POST">

                    <img src="https://i.ibb.co/312Xn3z/6ewsd6u2-900.jpg" alt="Game" width="180" height="180">
                    <h1 class="h3 mb-3 font-weight-normal">Please log in</h1>
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                    <p></p>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
                    <div class="checkbox mb-3 mt-3">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                    <p></p>
                    <a href="registration" class="btn btn-secondary btn-lg btn-block" role="button" aria-pressed="true">Registration</a>
                    <p> </p>
                    <p> </p>
                    <p> </p>
                    <p class="mt-4 mb-3 text-muted" > Made by Yuriy Mykytyuk 2020-2020</p>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>