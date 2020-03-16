 <form action="/dashboard/list" method="post">
	<div class="card dropdown" style="width: 15rem;">
  		<div class="card-body">
    		<button class="btn bmd-btn-icon dropdown-toggle" type="button" id="btn_settings_${toDoList.id}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    		<i class="material-icons">more_vert</i>
	  		</button>
    		<h5 class="card-title">${toDoList.title}</h5>
    		<input type="hidden" value="${toDoList.id}" name ="toDoListID" />
    		<button type="submit" name="button" value="Modifica" class="btn btn-primary btn-sm active">Modifica</button>

	  		<div class="dropdown-menu dropdown-menu-left" aria-labelledby="ex1">
	    		<button class="dropdown-item" type="button">Elimina</button>
	  			</div>		
  		</div>
	</div>
</form>