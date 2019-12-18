

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
      <!-- Google Fonts -->F
      <link href='bootstrap/js/common/PassionOne.css'
         rel='stylesheet' type='text/css'>
      <link href='bootstrap/js/common/Oxygen.css'
         rel='stylesheet' type='text/css'>

      <script type="text/javascript" src="bootstrap/js/registrationValidation.js"></script> 
      <script type="text/javascript" src="bootstrap/js/datePicker.js"></script> 
   </head>
   <!------ Include the above in your HEAD tag ---------->
   <body>
      <div class="page-wrapper chiller-theme toggled">
         <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
         <i class="fas fa-bars"></i>
         </a>
         <nav id="sidebar" class="sidebar-wrapper">
            <jsp:include page="commonMenu.jsp" />
         </nav>
         <!-- sidebar-wrapper  -->
         <main class="page-content ">
            <div class="container emp-profile card card-container-view-profile">
               <form method="post">
                  <div class="row">
                     <div class="col-md-4">
                        <div class="profile-img">
                           <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                           <div class="file btn btn-lg btn-primary">
                              Change Photo
                              <input type="file" name="file"/>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-6">
                        <div class="profile-head">
                           <h2>
                              ${personDetail.personFirstName}
                           </h2>
                           <h2>
                              ${personDetail.personLastName}
                           </h2>
                           <ul class="nav nav-tabs" id="myTab" role="tablist">
                              <li class="nav-item">
                                 <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                              </li>
                           </ul>
                        </div>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-md-4">
                     </div>
                     <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                           <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>User Id</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.personId}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Gender</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.gender}</p>
                                 </div>
                              </div>
                              <div class="row">
                                                               <div class="col-md-6">
                                                                  <label>Joining Date</label>
                                                               </div>
                                                               <div class="col-md-6">
                                                                  <p>${personDetail.personJoinedDate}</p>
                                                               </div>
                                                            </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Email</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.emailAddress}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Phone</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.contactNumber}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>State</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.state}</p>
                                 </div>
                              </div>
                           </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Country</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.country}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Pincode</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.pinCode}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Address</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.personAddress}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Nominee</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.nominee}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Nominee Relation</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.nomineeRelation}</p>
                                 </div>
                              </div>
                              <div class="row">
                                 <div class="col-md-6">
                                    <label>Reference</label>
                                 </div>
                                 <div class="col-md-6">
                                    <p>${personDetail.parentReference}</p>
                                 </div>
                              </div>
                        </div>
                     </div>
                  </div>
               </form>
            </div>
         </main>
      </div>
   </body>

