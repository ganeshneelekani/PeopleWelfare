
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
</head>

<body>
 <script src="https://balkangraph.com/js/latest/OrgChart.js"></script>

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

      <div id="tree"></div>
          <script>


      window.onload = function () {
          var chart = new OrgChart(document.getElementById("tree"), {
              enableDragDrop: true,
              tags: {
                  "assistant": {
                      template: "ula"
                  }
              },
              nodeBinding: {
                  field_0: "name",
                  field_1: "title",
                  img_0: "img"
              },
              nodes: [
                  ${nodes}
              ]
          });
      };
          </script>
      </div>
    </div>

  </main>
  <!-- page-content" -->
</div>
</body>

</html>