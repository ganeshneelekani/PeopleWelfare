
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   </head>
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
            <div class="container-fluid">
               <h2>Pro Sidebar</h2>
               <hr>
               <div class="row">
                  <div class="form-group col-md-12">
                     <p>This is a responsive sidebar template with dropdown menu based on bootstrap 4 framework.</p>
                     <p> You can find the complete code on <a href="https://github.com/azouaoui-med/pro-sidebar-template" target="_blank">
                        Github</a>, it contains more themes and background image option
                     </p>
                  </div>
                  <div class="form-group col-md-12">
                     <iframe src="https://ghbtns.com/github-btn.html?user=azouaoui-med&repo=pro-sidebar-template&type=star&count=true&size=large"
                        frameborder="0" scrolling="0" width="140px" height="30px"></iframe>
                     <iframe src="https://ghbtns.com/github-btn.html?user=azouaoui-med&repo=pro-sidebar-template&type=fork&count=true&size=large"
                        frameborder="0" scrolling="0" width="140px" height="30px"></iframe>
                  </div>
               </div>
               <h5>More templates</h5>
               <hr>
               <div class="row">
                  <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
                     <div class="card rounded-0 p-0 shadow-sm">
                        <img src="https://user-images.githubusercontent.com/25878302/58369568-a49b2480-7efc-11e9-9ca9-2be44afacda1.png" class="card-img-top rounded-0" alt="Angular pro sidebar">
                        <div class="card-body text-center">
                           <h6 class="card-title">Angular Pro Sidebar</h6>
                           <a href="https://github.com/azouaoui-med/angular-pro-sidebar" target="_blank" class="btn btn-primary btn-sm">Github</a>
                           <a href="https://azouaoui-med.github.io/angular-pro-sidebar/demo/" target="_blank" class="btn btn-success btn-sm">Preview</a>
                        </div>
                     </div>
                  </div>
                  <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
                     <div class="card rounded-0 p-0 shadow-sm">
                        <img src="https://user-images.githubusercontent.com/25878302/58369258-33f20900-7ef8-11e9-8ff3-b277cb7ed7b4.PNG" class="card-img-top rounded-0" alt="Angular pro sidebar">
                        <div class="card-body text-center">
                           <h6 class="card-title">Angular Dashboard</h6>
                           <a href="https://github.com/azouaoui-med/lightning-admin-angular" target="_blank" class="btn btn-primary btn-sm">Github</a>
                           <a href="https://azouaoui-med.github.io/lightning-admin-angular/demo/" target="_blank" class="btn btn-success btn-sm">Preview</a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </main>
         <!-- page-content" -->
      </div>
      <!-- page-wrapper -->
   </body>
</html>

