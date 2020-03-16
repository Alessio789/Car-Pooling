<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page errorPage="/pages/errors/jspError.jsp"%>
<!DOCTYPE html>
<html lang="it">
  <head>
    <meta charset="utf-8">
    <title><am-web:insert key="title" /></title>
    <meta name="description" content="To do List">
    <meta name="author" content="Team Marconi">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Material Design for Bootstrap fonts and icons -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
    
    <!-- Material Design for Bootstrap CSS -->
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    
 	<!-- Custom styles for this template -->
    <link href="/Stylesheet/style.css" rel="stylesheet">
<!--     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
   
  </head>
  <body style="background-color:#${sessionScope.dashboard.color};">
    <am-web:insert key="header" />
    <div class="container-fluid">
    	<div class="row-fluid">    	    
      		<am-web:insert key="content" />
        </div><!--/row-->
      <footer class="sticky-bottom" style="background-color:white;">
        <am-web:insert key="footer" />
      </footer>
    </div><!--/.fluid-container-->
    <div id="spinner" style="display:none">Loading...</div>
    <c:import url="/pages/footer_scripts.jsp" />
 <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<!--     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
    <script src="/javascript/jquery-3.4.1.min.js"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
    <script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>
    <script src="/javascript/function.js"></script>
  </body>
</html>