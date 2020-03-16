<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>


<div class="container-fluid bg-light py-3" id="divnav">
    <form action="/app/ToDoList/add" method="post" id="form" 	>
    <input type="hidden" value="${toDoList.id}" name ="toDoListID" />
        <div class="messages"></div>
        <div class="controls">
            <div class="row">
                <div class="d-flex flex-wrap align-content-start">
                    <div class="form-group" style="margin: 0 auto; margin-left:15px;">
                        <label for="title">Titolo</label>
                        <input id="title" type="text" name="title" class="form-control" placeholder="Aggiungi titolo" required="required" data-error="name is required.">
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="d-flex flex-wrap align-content-start">
                    <div class="form-group" style="margin: 0 auto; margin-left:35px;">
                        <label for="priority">Priorità</label>
                        <select name="priority" style="margin-top:5px;">
							<option value="1"><am-web:message key="option.high"></am-web:message></option>
							<option value="2"><am-web:message key="option.medium"></am-web:message></option>
							<option value="3"><am-web:message key="option.low"></am-web:message></option>
							</select>
					</div>		
					<div class="d-flex flex-wrap align-content-start">			
						<div class="form-group" style="margin: 0 auto; margin-left: 35px; margin-top:35px;">
                        	<label for="checkbox"><am-web:message key="input.done?"></am-web:message></label>
                        	<input type="checkbox" name="done" value="true" />
                        <div class="help-block with-errors"></div>
                    </div>
                	</div>    
                        <div class="help-block with-errors"></div>
                    
                </div>
            </div>
        </div>
        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="form_message">Descrizione</label>
                    <textarea id="text" name="description" class="form-control" placeholder="Aggiungi descrizione..." rows="4" required="required" data-error="Scrivi qualcosa."></textarea>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-12">
                <button type="submit" name="button" class="btn btn-raised btn-primary" value="Aggiungi"><am-web:message key="button.add"></am-web:message></button>
            </div>
        </div>
    </form>
</div>



