<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>



<div class="login-container">

<form class="form-signin" action="/app/login/login" method="post"><am-web:error style="alert alert-danger"/>
	<div class="text-center mb-4">
		<img class="mb-4" src="/Images/todolist.png" alt="" width="170" height="170">
			<h1 class="h3 mb-3 font-weight-normal">Login</h1>
	</div>
		
	<div class="form-label-group">
	<input type="text" id="inputUsername" name="username" class="form-control" placeholder="<am-web:message key="label.username"></am-web:message>" required autofocus>
    <label for="inputUsername"></label>
	</div>
		
	<div class="form-label-group">
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="<am-web:message key="label.password"></am-web:message>" required>
    <label for="inputPassword"></label>
    </div>
		
		
		
	<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit"><am-web:message key="button.submit"></am-web:message></button>

		
</form>
</div>



