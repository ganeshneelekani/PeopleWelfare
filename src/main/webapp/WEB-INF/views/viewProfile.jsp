

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
   <main class="page-content">
      <div class="container emp-profile">
         <form method="post">
            <div class="row">
               <div class="col-md-4">
                  <div class="profile-img">
                     <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
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
                     <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                     <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                           <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                        </li>
                     </ul>
                  </div>
               </div>
               <div class="col-md-2">
                  <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
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
                              <h5>
                                 <p>${personDetail.personId}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>Gender</label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.gender}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>Email</label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.emailAddress}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>Phone</label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.contactNumber}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>State</label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.state}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>Country</label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.country}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>Address</label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.personAddress}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-md-6">
                              <label>Pin Code
                              </label>
                           </div>
                           <div class="col-md-6">
                              <h5>
                                 <p>${personDetail.pinCode}</p>
                              </h5>
                           </div>
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                           <div class="row">
                              <div class="col-md-6">
                                 <label>Nominee</label>
                              </div>
                              <div class="col-md-6">
                                 <h5>
                                    <p>${personDetail.nominee}</p>
                                 </h5>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col-md-6">
                                 <label>Nominee Relation</label>
                              </div>
                              <div class="col-md-6">
                                 <h5>
                                    <p>${personDetail.nomineeRelation}</p>
                                 </h5>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
         </form>
         </div>
   </main>
   <!-- page-content" -->
   </div>
   <!-- page-wrapper -->
</body>

