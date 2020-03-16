<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div style="background-color:#${sessionScope.dashboard.color};">

<!-- <form action="/app/dashboard/addList" method="post"> -->
 <div class="form-row align-items-center d-flex justify-content-center">
  <div class="form-group">
    <label for="formGroupExampleInput" class="bmd-label-placeholder">Aggiungi task alla lista</label>
    <input type="text" name="title" maxlength="50" class="form-control" id="newTitleList"  required autofocus>
    </div>
    
    <button id="btn-add-list" type="submit" name="button" value="Aggiungi" class="btn btn-primary btn-md active">Aggiungi</button>
    
 </div>
<!-- </form>  -->

	
<div class="d-flex flex-wrap align-content-start">
<c:forEach items="${sessionScope.dashboard.list}" var="toDoList">


  <form action="/dashboard/list" method="post">
	<div class="card dropdown" style="width: 15rem;">
  		<div class="card-body">
    		<button class="btn bmd-btn-icon dropdown-toggle" type="button" id="ex1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    		<i class="material-icons">more_vert</i>
	  		</button>
    		<h5 class="card-title">${toDoList.title}</h5>
    		<input type="hidden" value="${toDoList.id}" name ="toDoListID" />
    		<button type="submit" name="button" value="Modifica" class="btn btn-primary btn-sm active">Modifica</button>
	  		<div class="dropdown-menu dropdown-menu-left" aria-labelledby="ex1">
	  		<input type="hidden" value="${todo.id }" name ="taskid" /><input type="hidden" value="${toDoList.id }" name ="toDoListID" />
	    		<button id='todo_${todo.id}' class="dropdown-item" type="button" onClick="removeList()">Elimina</button> 
	  			</div>		
  		</div>
	</div>
  </form>


</c:forEach>
</div>

</div>


