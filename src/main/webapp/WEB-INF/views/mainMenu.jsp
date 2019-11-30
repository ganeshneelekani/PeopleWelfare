

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Bootstrap Navbar Sidebar - Fixed to Left or Right</title>
      <link rel="stylesheet" href="bootstrap/mainmenu/ajax.bootstrap.min.css" />
      <link href='bootstrap/mainmenu/bootstrap.min.css'
         rel='stylesheet' type='text/css'>
      <!-- Google Fonts -->
     <link rel="stylesheet" href='bootstrap/mainmenu/font-awesome.min.css"/>
      <link href='bootstrap/mainmenu/navbar-fixed-left.min.css'
         rel='stylesheet' type='text/css'>
      <link href='bootstrap/mainmenu/navbar-fixed-right.min.css'
         rel='stylesheet' type='text/css'>
      <link href='bootstrap/mainmenu/docs.css'
         rel='stylesheet' type='text/css'>
      <script type="text/javascript" src="bootstrap/mainmenu/jquery.min.js"></script>
      <script type="text/javascript" src="bootstrap/mainmenu/twitter.bootstrap.min.js"></script>
      <script type="text/javascript" src="bootstrap/mainmenu/docs.js"></script> 
      <script async defer type="text/javascript" src="bootstrap/mainmenu/button.js"></script> 
   </head>
   <body>
      <nav class="navbar navbar-inverse navbar-fixed-left">
         <div class="container">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#">Project name</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
               <ul class="nav navbar-nav">
                  <li><a href="#">Home</a></li>
                  <li><a href="#">About</a></li>
                  <li><a href="#">Contact</a></li>
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                     </ul>
                  </li>
               </ul>
               <ul class="nav navbar-nav navbar-right">
                  <li>
                     <a data-class="navbar-fixed-left">
                     <i class="fa fa-arrow-left"></i>
                     Fixed Left
                     </a>
                  </li>
                  <li>
                     <a data-class="navbar-fixed-top">
                     <i class="fa fa-arrow-up"></i>
                     Fixed Top
                     <small>(original)</small>
                     </a>
                  </li>
                  <li>
                     <a data-class="navbar-fixed-right">
                     <i class="fa fa-arrow-right"></i>
                     Fixed Right
                     </a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>
      <div class="container">
         <div class="jumbotron">
            <h1>
               Bootstrap Navbar Sidebar
               <br>
               <small>Fixed to Left or Right</small>
            </h1>
            <p>
               <strong>
               Use classic Bootstrap navbar as sidebar, on left or right side.
               </strong>
            </p>
            <p>
               <a class="github-button" href="https://github.com/mladenplavsic/bootstrap-navbar-sidebar" data-icon="octicon-star" data-style="mega" data-count-href="/mladenplavsic/bootstrap-navbar-sidebar/stargazers" data-count-api="/repos/mladenplavsic/bootstrap-navbar-sidebar#stargazers_count" data-count-aria-label="# stargazers on GitHub" aria-label="Star mladenplavsic/bootstrap-navbar-sidebar on GitHub">Star</a>
               <a class="github-button" href="https://github.com/mladenplavsic/bootstrap-navbar-sidebar/fork" data-icon="octicon-repo-forked" data-style="mega" data-count-href="/mladenplavsic/bootstrap-navbar-sidebar/network" aria-label="Fork mladenplavsic/bootstrap-navbar-sidebar on GitHub">Fork</a>
               <a class="github-button" href="https://github.com/mladenplavsic" data-style="mega" aria-label="Follow @mladenplavsic on GitHub">Follow @mladenplavsic</a>
            </p>
            <p>Same when using <code>.navbar-fixed-top</code> - add class <code>.navbar-fixed-left</code> or <code>.navbar-fixed-right</code> where needed.</p>
            <p>Click buttons below, and appropriate class will be added to example navbar.</p>
            <p>
               <span class="btn-group">
               <a data-class="navbar-fixed-left" class="btn btn-lg btn-default">
               <i class="fa fa-arrow-left"></i>
               Fixed Left
               </a>
               <a data-class="navbar-fixed-top" class="btn btn-lg btn-default">
               <i class="fa fa-arrow-up"></i>
               Fixed Top
               <small>(original)</small>
               </a>
               <a data-class="navbar-fixed-right" class="btn btn-lg btn-default">
               <i class="fa fa-arrow-right"></i>
               Fixed Right
               </a>
               </span>
            </p>
         </div>
         <footer>
            Repository maintained by <a href="https://github.com/mladenplavsic">mladenplavsic</a>
         </footer>
      </div>
   </body>
</html>

