

<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<link href="bootstrap/js/mainMenuJs/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="bootstrap/js/mainMenuJs/bootstrap.min.js"></script>
<script src="bootstrap/js/mainMenuJs/jquery.min.js"></script>
<script src="bootstrap/js/mainMenuJs/jquery.min.js"></script>
<script src="bootstrap/js/mainMenuJs/popper.min.js"></script>
<script src="bootstrap/js/mainMenuJs/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <script src="bootstrap/js/mainMenuJs/3.3.1.jquery.min.js"></script>
      <script src="bootstrap/mainmenu/mainmenu.js"></script>
      <script type="text/javascript" src="bootstrap/js/common/jquery.validate.min.js"></script>
      <script>
         if ( window.history.replaceState ) {
           window.history.replaceState( null, null, window.location.href );
         }
      </script>
   </head>
   <body>
      <div class="sidebar-content">
         <div class="sidebar-brand">
            <a href="#">pro sidebar</a>
            <div id="close-sidebar">
               <i class="fas fa-times"></i>
            </div>
         </div>
         <div class="sidebar-header">
            <div class="user-info">
               <strong><span class="user-name">${personDetail.personFirstName}</strong>
               <strong><span class="user-name">${personDetail.personLastName}</strong>
               </span>
               <span class="user-status">
               <i class="fa fa-circle"></i>
               <span>Online</span>
               </span>
            </div>
         </div>
         <!-- sidebar-search  -->
         <div class="sidebar-menu">
            <ul>
               <li class="header-menu">
                  <span>General</span>
               </li>
               <li>
                  <a href="/PeopleWelfare/home">
                  <i class="fa fa-home"></i>
                  <span>Home</span>
                  </a>
               </li>
               <li>
                  <a href="/PeopleWelfare/viewProfile">
                  <i class="fa fa-user"></i>
                  <span>View Profile</span>
                  </a>
               </li>
               <li>
                  <a href="/PeopleWelfare/updateProfile">
                  <i class="fa fa-child"></i>
                  <span>Update Profile</span>
                  </a>
               </li>
               <li>
                  <a href="/PeopleWelfare/ChangePassword">
                  <i class="fa fa-lock"></i>
                  <span>Change Password</span>
                  </a>
               </li>
               <li>
                  <a href="/PeopleWelfare/MemberTree">
                  <i class="fa fa-tree"></i>
                  <span>Member Tree</span>
                  </a>
               </li>
               <li class="header-menu">
                  <span>Extra</span>
               </li>
               <li>
                  <a href="#">
                  <i class="fa fa-book"></i>
                  <span>Documentation</span>
                  <span class="badge badge-pill badge-primary">Beta</span>
                  </a>
               </li>
               <li>
                  <a href="#">
                  <i class="fa fa-calendar"></i>
                  <span>Calendar</span>
                  </a>
               </li>
               <li>
                  <a href="#">
                  <i class="fa fa-folder"></i>
                  <span>Examples</span>
                  </a>
               </li>
            </ul>
         </div>
         <!-- sidebar-menu  -->
      </div>
      <!-- sidebar-content  -->
      <div class="sidebar-footer">
         <a href="#">
         <i class="fa fa-bell"></i>
         <span class="badge badge-pill badge-warning notification">3</span>
         </a>
         <a href="#">
         <i class="fa fa-envelope"></i>
         <span class="badge badge-pill badge-success notification">7</span>
         </a>
         <a href="#">
         <i class="fa fa-cog"></i>
         <span class="badge-sonar"></span>
         </a>
         <a href="#">
         <i class="fa fa-power-off"></i>
         </a>
      </div>
   </body>
</html>

