<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Login Information</title>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    <!-- Website CSS style -->
    <!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/jquery.validation.css" rel="stylesheet">
    <!-- Website Font style -->
    <link rel="stylesheet" href="Preview.css">
    <link rel="stylesheet" href="style.css">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Passion+One'
          rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen'
          rel='stylesheet' type='text/css'>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
    <script src="bootstrap/js/jquery.validation.js"></script> 

</head>
<body>

  <script type="text/javascript">

 $(document).ready(function() { 

$('#form-signin_v1').validate(); 

 }); </script>    



<nav class="navbar navbar-toggleable-md fixed-top navbar-inverse bg-primary">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">BS 4 <strong>My Resume</strong></a>
    <div class="collapse navbar-collapse" id="navbarResponsive" name="navbarResponsive">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link active" href="#resume">Resume <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#attributes">Attributes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#certifications">Certifications</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#skills">Skills</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#schools">Education</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">

            <li class="dropdown"><a href="#" class="dropdown-toggle nav-link nav-item"
                                    data-toggle="dropdown" role="button" aria-haspopup="true"
                                    aria-expanded="false">ABOUT US</a>
                <ul class="dropdown-menu">
                    <li><a class="nav-link-dropdown nav-item" href="#">Action</a></li>
                    <li><a class="nav-link-dropdown nav-item" href="#">Another action</a></li>
                    <li><a class="nav-link-dropdown nav-item" href="#">Something </a></li>
                    <li role="separator" class="divider"></li>
                    <li><a class="nav-link-dropdown nav-item" href="#">Separated link</a></li>
                </ul>
            </li>
        </ul>

    </div>
</nav>

<div class="container">
    </br>
    </br>
    </br>
    <div class="row">
        <div class="col-sm-4">
        </div>
        <div class="col-sm-4">
        </div>
        <div class="col-sm-4">
            <div class="card card-container">
                <form:form class="form-signin" modelAttribute="user" method="post" action="/PeopleWelfare/loginUser"  id="form-signin_v1" name="myForm">
                    <span id="reauth-email" class="reauth-email"></span>

                   <form:label path="username" name="username" type="text" data-validation="[NOTEMPTY]" placeholder="Username"  class="form-control" id="inputdefault" ></form:label >

                   <form:password path="password" name="password" type="password" data-validation="[NOTEMPTY]" placeholder="Password"  class="form-control" id="inputdefault" /> </form:label >

                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <form:button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</form:button>
                </form:form>
                <!-- /form -->
                <a href="#" class="forgot-password">
                    Forgot the password?
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
