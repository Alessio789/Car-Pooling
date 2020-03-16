<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-dark shadow-lg p-3 mb-5 bg-success brounded sticky-top" aria-label="breadcrumb">
	<a class="navbar-brand font-weight-bold" style="font-size: 10px;" href="#"><img src="/Images/todolist.png" width="80" height="80" class="d-inline-block align-top" alt=""></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar6">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <ol class="breadcrumb" style="margin-top: 15px;">
    <li class="breadcrumb-item">
    	<a href="/dashboard">Dashboard</a></li>
    	<i class="material-icons">play_arrow</i>
    <li class="breadcrumb-item active" aria-current="page">Lista Task</li>
 	</ol>
    
    <div class="navbar-collapse collapse justify-content-stretch" id="navbar6">
        
        <ul class="navbar-nav ml-auto">
    		<li class="nav-item" style="margin-top:10px; ">
    			<h6><am-web:guard><am-web:message key="p.hi"></am-web:message><am-web:profile username="true"></am-web:profile></am-web:guard></h6>
     			<%-- <a class="nav-item nav-link font-weight-bold " style="font-size: 20px;" href="#"></a>--%>
    		</li>
    		
    		<li class="nav-item dropdown">
      			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        		<i class="material-icons">person_pin</i>
      			</a>
      			<div class="dropdown-menu dropdown-menu-right" style="border:1px solid gray;">
     				<am-web:guard><a href="/logout" class="dropdown-item" style="border-bottom:1px solid grey;"><am-web:message key="a.logout"></am-web:message></a></am-web:guard>
     				<button type="button" class="dropdown-item" data-toggle="modal" data-target="#myModal" style="margin-top:10px;" >Impostazioni</button>
  			</div>
  			</li>
      		
    	</ul>  
	</div>
</nav> 			
     			
     			
     			<!-- The Modal -->
				  <div class="modal" id="myModal">
				    <div class="modal-dialog">
				      <div class="modal-content">
				      
				        <!-- Modal Header -->
				        <div class="modal-header">
				          <h4 class="modal-title">Impostazioni</h4>
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        
				        <!-- Modal body -->
				        <div class="modal-body">
				          Future opzioni..
				        </div>
				        
				        <!-- Modal footer -->
				        <div class="modal-footer">
				          <button type="button" class="btn btn-danger" data-dismiss="modal">Chiudi</button>
				        </div>
				        
				      </div>
				    </div>
				  </div>
     			
     			
      			
      		   
            
    
    
    
    
    
