
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
         <!-- sidebar-header  -->
         <div class="sidebar-search">
            <div>
               <div class="input-group">
                  <input type="text" class="form-control search-menu" placeholder="Search...">
                  <div class="input-group-append">
                     <span class="input-group-text">
                     <i class="fa fa-search" aria-hidden="true"></i>
                     </span>
                  </div>
               </div>
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
               <li class="sidebar-dropdown">
                  <a href="#">
                  <i class="fa fa-user"></i>
                  <span>My Profile</span>
                  </a>
                  <div class="sidebar-submenu">
                     <ul>
                        <li>
                           <a href="/PeopleWelfare/viewProfile">View Profile
                           </a>
                        </li>
                        <li>
                           <a href="/PeopleWelfare/updateProfile">Update Profile</a>
                        </li>
                        <li>
                           <a href="#">
                           Change Password</a>
                        </li>
                     </ul>
                  </div>
               </li>
               <li class="sidebar-dropdown">
                  <a href="#">
                  <i class="fa fa-users"></i>
                  <span>Team Member</span>
                  <span class="badge badge-pill badge-danger">3</span>
                  </a>
                  <div class="sidebar-submenu">
                     <ul>
                        <li>
                           <a href="/PeopleWelfare/MemberTree">Member Tree
                           </a>
                        </li>
                        <li>
                           <a href="#">Orders</a>
                        </li>
                        <li>
                           <a href="#">Credit cart</a>
                        </li>
                     </ul>
                  </div>
               </li>
               <li class="sidebar-dropdown">
                  <a href="#">
                  <i class="far fa-gem"></i>
                  <span>Components</span>
                  </a>
                  <div class="sidebar-submenu">
                     <ul>
                        <li>
                           <a href="#">General</a>
                        </li>
                        <li>
                           <a href="#">Panels</a>
                        </li>
                        <li>
                           <a href="#">Tables</a>
                        </li>
                        <li>
                           <a href="#">Icons</a>
                        </li>
                        <li>
                           <a href="#">Forms</a>
                        </li>
                     </ul>
                  </div>
               </li>
               <li class="sidebar-dropdown">
                  <a href="#">
                  <i class="fa fa-chart-line"></i>
                  <span>Charts</span>
                  </a>
                  <div class="sidebar-submenu">
                     <ul>
                        <li>
                           <a href="#">Pie chart</a>
                        </li>
                        <li>
                           <a href="#">Line chart</a>
                        </li>
                        <li>
                           <a href="#">Bar chart</a>
                        </li>
                        <li>
                           <a href="#">Histogram</a>
                        </li>
                     </ul>
                  </div>
               </li>
               <li class="sidebar-dropdown">
                  <a href="#">
                  <i class="fa fa-globe"></i>
                  <span>Maps</span>
                  </a>
                  <div class="sidebar-submenu">
                     <ul>
                        <li>
                           <a href="#">Google maps</a>
                        </li>
                        <li>
                           <a href="#">Open street map</a>
                        </li>
                     </ul>
                  </div>
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

