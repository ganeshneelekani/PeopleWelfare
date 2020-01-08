<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
           <meta charset="UTF-8">
            <title>Login Information</title>
            <script
               type="text/javascript" src="bootstrap/js/common/jquery.min.js"></script>
            <script type="text/javascript" src="bootstrap/js/common/jquery.validate.min.js"></script>
            <!-- Website CSS style -->
            <!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
            <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
            <link href="bootstrap/css/jquery.validation.css" rel="stylesheet">
            <!-- Google Fonts -->
            <link href='bootstrap/js/common/PassionOne.css'
               rel='stylesheet' type='text/css'>
            <link href='bootstrap/js/common/Oxygen.css'
               rel='stylesheet' type='text/css'>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
               integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
               crossorigin="anonymous"></script>
            <script type="text/javascript" src="bootstrap/js/loginValidation.js"></script> 
            <script type="text/javascript" src="bootstrap/js/datePicker.js"></script> 
   </head>
   <body>
      <script type="text/javascript" src="bootstrap/js/jquery.validation.js"></script> 
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
               <li class="dropdown">
                  <a href="#" class="dropdown-toggle nav-link nav-item"
                     data-toggle="dropdown" role="button" aria-haspopup="true"
                     aria-expanded="false">ABOUT US</a>
                  <ul class="dropdown-menu">
                     <li><a class="nav-link-dropdown nav-item" href="#">Action</a></li>
                     <li><a class="nav-link-dropdown nav-item" href="#">Another action</a></li>
                     <li><a class="nav-link-dropdown nav-item" href="#">Something </a></li>
                     <li role="separator" class="divider"></li>
                     <li><a class="nav-link-dropdown nav-item" href="#">Separated link</a></li>
                     <li><a class="nav-link-dropdown nav-item" href="/PeopleWelfare/RegisterStudent">Register Student</a></li>
                  </ul>
               </li>
            </ul>
         </div>
      </nav>
      <div class="container">
         </br>
         </br>
         </br>

         <div>
         <span class="container-fluid">
         <h2>${loginCredential}</h2></span>
         </div>
         <div class="row">
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
               <div class="card card-container">
                  <form:form id="loginForm" modelAttribute="login" action="/PeopleWelfare/loginUser" method="post"
                  class="form-signin" >
                     <table align="center">
                        <span class="error">${msg}</span>

                        <tr>
                           <td>
                              <form:input path="personId" name="personId" id="personId" placeholder="Person Id" class="form-control"  />
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <form:password path="personPassword" name="personPassword" id="personPassword" placeholder="Password" class="form-control"  />
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <form:button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="submit" >Sign in</form:button>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <a href="/PeopleWelfare/ForgotPassword" class="forgot-password">
                              Forgot the password?
                              </a>
                           </br>
                               <a class="register-user" href="/PeopleWelfare/RegisterPerson">
                                Register Person
                               </a>
                            </td>
                        </tr>
                        <tr></tr>
                     </table>
                  </form:form>
                  <!-- /form -->
               </div>
            </div>
         </div>
      </div>
   </body>
</html>
