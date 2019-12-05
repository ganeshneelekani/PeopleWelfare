

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      <script type="text/javascript" src="bootstrap/js/registrationValidation.js"></script> 
      <script type="text/javascript" src="bootstrap/js/datePicker.js"></script> 
   </head>
   <body>
      <script type='text/javascript'>
         $(function() {
         	//calendar call function
         	$('.datepicker').dcalendar();
         	$('.datepicker').dcalendarpicker();
         
         	    var max_fields = 10; //maximum input boxes allowed
         	    var x = 1; //initlal text box count
         
         	$('#add').click(function () {
         		if(x < max_fields){ //max input box allowed
         		    x++; //text box increment
         		    $("#addblock").before('<div class="col-md-12 col-sm-12" id="deceased">	<a href="#" class="remove_field" title="Remove">X</a>	<div class="form-group col-md-3 col-sm-3">            <label for="name">Name*</label>            <input type="text" class="form-control input-sm" id="name" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="gender">Gender*</label>            <input type="text" class="form-control input-sm" id="gender" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="age">Age*</label>            <input type="text" class="form-control input-sm" id="age" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOB">Date of Birth or Exact Birth Year*</label>            <input type="text" class="form-control input-sm datepicker" id="DOB'+x+'" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOD">Date of Death or Exact Death Year*</label>             <input type="text" class="form-control input-sm datepicker" id="DOD'+x+'" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="mother">Deceased Person\'s Mother Name*</label>            <input type="text" class="form-control input-sm" id="mother" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="father">Deceased Person\'s Father Name*</label>            <input type="text" class="form-control input-sm" id="father" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">	    <label for="photo">Upload Photo*</label>	    <input type="file" id="photo">	    <p class="help-block">Please upload individual photo. Group photo is not acceptable.</p>	</div></div>');
         
         			$('.datepicker').dcalendarpicker();
         		}  else{
         			alert("Only 10 Names Allowed");
         		}
         	});
         	$(document).on('click', '.remove_field', function(e){
         	        e.preventDefault();
         		$(this).parent('div').remove();
         		x--;
         	});
         });
      </script>
      <div class="page-wrapper chiller-theme toggled">
      <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
      <i class="fas fa-bars"></i>
      </a>
      <nav id="sidebar" class="sidebar-wrapper">
         <jsp:include page="commonMenu.jsp" />
      </nav>
      <!-- sidebar-wrapper  -->
      <main class="page-content">
         <div class="container">
            </br>
            </br>
            <div class="card card-container-register col-xs-12 col-sm-6 col-md-6 col-lg-6 col-sm-offset-2 col-md-offset-4"
            <div >
               <div class="panel panel-default">
                  <div class="panel-body">
                     <form:form id="personRegistrationForm" modelAttribute="personRegistration"
                        action="/PeopleWelfare/RegisterPersonDetails" method="post" class="form-signin">
                        <span class="error">${exceptionMsg}</span>
                        <div class="form-group">
                           <form:input type="text" path="personFirstName" name="personFirstName" id="personFirstName"
                              class="form-control" placeholder="First Name"/>
                        </div>
                        <div class="form-group">
                           <form:input type="text" path="personLastName" name="personLastName" id="personLastName"
                              class="form-control" placeholder="Last Name"/>
                        </div>
                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:select type="text" path="gender" name="gender" id="gender" class="form-control" placeholder="Gender">
                                    <option>Select Gender</option>
                                    <option>Male</option>
                                    <option>Female</option>
                                 </form:select>
                              </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <span class="error">${msg}</span>
                                 <form:input type="text" path="parentReference" name="parentReference" id="parentReference"
                                    class="form-control" placeholder="Reference"/>
                              </div>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:input type="text" path="contactNumber" name="contactNumber" id="contactNumber" class="form-control" placeholder="Contact Number"/>
                              </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:input type="text" path="emailAddress" name="emailAddress" id="emailAddress" class="form-control" placeholder="Email Address"/>
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <form:textarea type="text" path="personAddress" name="personAddress" id="personAddress" class="form-control" placeholder="Address"/>
                        </div>
                        <script type= "text/javascript" src = "bootstrap/js/countries.js"></script>
                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:select type="text" path="country" name="country" id="country" class="form-control" placeholder="country">
                                 </form:select>
                              </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:select type="text" path="state" name="state" id="state" class="form-control" placeholder="state">
                                    <option>Select State</option>
                                 </form:select>
                              </div>
                           </div>
                        </div>
                        <script language="javascript">
                           populateCountries("country", "state"); // first parameter is id of country drop-down and second parameter is id of state drop-down
                           populateCountries("country2");
                           
                        </script>
                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:input type="text" path="pinCode" name="pinCode" id="pinCode" class="form-control"
                                    placeholder="Pin Code"/>
                              </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                              </div>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:input type="text" path="nominee" name="nominee" id="nominee" class="form-control"
                                    placeholder="Nominee Name"/>
                              </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:input type="text" path="nomineeRelation" name="nomineeRelation" id="nomineeRelation" class="form-control"
                                    placeholder="Nominee Relation"/>
                              </div>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:password  path="password" name="password" id="password" class="form-control" placeholder="Password"/>
                              </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                              <div class="form-group">
                                 <form:password  path="verifyPassword" name="verifyPassword" id="verifyPassword" class="form-control"
                                    placeholder="Re Enter Password"/>
                              </div>
                           </div>
                        </div>
                        <form:button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="submit" > Submit </form:button>
                     </form:form>
                  </div>
               </div>
            </div>
      </main>
   </body>
</html>

