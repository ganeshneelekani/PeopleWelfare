

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <head>
         <meta name="viewport" content="width=device-width" />
         <title>Royal Family Tree - OrgChart JS | BALKANGraph</title>
         <style>
            html, body {
            margin: 0px;
            padding: 0px;
            width: 100%;
            height: 100%;
            font-family: Helvetica;
            }
            #tree {
            width: 100%;
            height: 100%;
            }
         </style>
   </head>
   <body>
      <div id="tree"></div>
      <div class="page-wrapper chiller-theme toggled">
         <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
         <i class="fas fa-bars"></i>
         </a>
         <nav id="sidebar" class="sidebar-wrapper">
            <jsp:include page="commonMenu.jsp" />
         </nav>
         <!-- sidebar-wrapper  -->
         <main class="page-content">
            </br>
            </br>
            </br>
            <h2> Welcome ${personDetail.personFirstName} ${personDetail.personLastName} - ${personDetail
               .personId}
            </h2>
            <div class="row">
               <div class="col-sm-2 col-md-2">
                  <img src="http://thetransformedmale.files.wordpress.com/2011/06/bruce-wayne-armani.jpg"
                     alt="" class="img-rounded img-responsive" width="250" height="250" />
               </div>
            </div>
            </br>
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
            </div>
            <div class="row col-md-6 col-md-offset-2 custyle">
               Parent Chain List
               <table class="table table-striped custab">
                  <thead>
                     <tr>
                        <td>Person ID</td>
                        <td> </td>
                        <td>First Name</td>
                        <td></td>
                        <td>Last Name</td>
                        <td></td>
                        <td>Joined Date</td>
                     </tr>
                  </thead>
                  <tr>
                     <c:forEach items="${personDetailDirectList}" var="current">
                  <tr>
                  <td><c:out value="${current.personId}"/><td>
                  <td><c:out value="${current.personFirstName}"/><td>
                  <td><c:out value="${current.personLastName}"/><td>
                  <td><c:out value="${current.personJoinedDate}"/><td>
                  </td>
                  </tr>
                  </c:forEach>
                  </tr>
               </table>
               <td class="text-center">
                  <a class='btn btn-info btn-xs'
                  href="/PeopleWelfare/downloadForm1" target="_blank"
                  <span class="glyphicon glyphicon-edit"></span> Form 1</a>
            </div>
         </main>
         <!-- page-content" -->
      </div>
      <!-- page-wrapper -->
      <script type="text/JavaScript" src="bootstrap/js/OrgChart.js"></script>
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
   </body>
</html>

