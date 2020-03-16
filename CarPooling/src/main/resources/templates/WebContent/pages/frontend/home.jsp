<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel = "stylesheet" href = "/Stylesheet/style.css">

<h1 style="margin-left:240px;"><am-web:message key="h1.listofthingstodo"></am-web:message></h1>	

<c:import url="/pages/frontend/navbar.jsp" />






<div class="container text-center">
  <div style="font-size:20px;">
    <div class="col-12">
      <table class="table table-bordered" style="background-color:white">
        <thead class="thead-dark">
          <tr>
            <th scope="col" style="font-size:20px;"><am-web:message key="th.title"></am-web:message></th>
            <th scope="col" style="font-size:20px;"><am-web:message key="th.description"></am-web:message></th>
            <th scope="col" style="font-size:20px;"><am-web:message key="th.isdone?"></am-web:message></th>
            <th scope="col" style="font-size:20px;"><am-web:message key="th.priority"></am-web:message></th>
            <th scope="col" style="font-size:20px;"><am-web:message key="th.actions"></am-web:message></th>
          </tr>
        </thead>
        <tbody> 	
        <c:forEach items="${toDoList.tasks}" var="todo">
          <tr>
            <th scope="row" class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.title}</th>
            <td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.description}</td>
            <td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.done}</td>
            <td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.priority}</td>
            <td class="d-flex align-content-end"> 
            	<form action="/app/ToDoList/remove" method="post">
					<input type="hidden" value="${todo.id }" name ="taskid" /><input type="hidden" value="${toDoList.id }" name ="toDoListID" />
			 		<button id='todo_${todo.id}' type="submit" name="button" class="btn btn-dark" value="Rimuovi" onClick="remove('$todo.id')" style="width:15px;"><i class="material-icons d-flex justify-content-center">delete</i></button>
			    </form>
					<form action="/app/ToDoList/modifyRequest" method="post">
					<input type="hidden" value="${toDoList.id}" name ="toDoListID" />
					<input type="hidden" value="${todo.id }" name ="taskid" />
					<button id='${todo.id}' type="submit" name="button" value="Modifica" class="btn btn-dark" style="width:15px;"><i class="material-icons md-dark d-flex justify-content-center">edit</i></button>
			    </form>             
            </td>
          </tr>
         </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>








<%-- 

<div class="d-flex justify-content-center">
	<table class="table border border-dark rounded">
		
		<thead class="border border-dark rounded">
		<tr>
		
			<th><am-web:message key="th.title"></am-web:message></th>
			<th><am-web:message key="th.description"></am-web:message></th>
			<th><am-web:message key="th.isdone?"></am-web:message></th>
			<th><am-web:message key="th.priority"></am-web:message></th>
		    <th><am-web:message key="th.actions"></am-web:message></th>
		
		</tr>
		</thead>
		<tbody>
	<c:forEach items="${toDoList.tasks}" var="todo">
		
		
		<tr>
		
			<td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.title}</td>
			<td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.description}</td>
			<td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.done}</td>
			<td class="<c:if test='${todo.done eq true}'>done</c:if>">${todo.priority}</td>
			<td>
			
			
			<form action="/app/ToDoList/remove" method="post" style="width:15px;">
			<input type="hidden" value="${todo.id }" name ="taskid" /><input type="hidden" value="${toDoList.id }" name ="toDoListID" />
			 <button id='todo_${todo.id}' type="submit" name="button" class="btn btn-dark" value="Rimuovi" onClick="remove('$todo.id')" style="width:15px;"><i class="material-icons d-flex justify-content-center">delete</i></button>
			</form>
			<form action="/app/ToDoList/modifyRequest" method="post" style="width:15px;">
			<input type="hidden" value="${toDoList.id}" name ="toDoListID" />
			<input type="hidden" value="${todo.id }" name ="taskid" />
			<button id='${todo.id}' type="submit" name="button" value="Modifica" class="btn btn-dark" style="width:15px;"><i class="material-icons md-dark d-flex justify-content-center">edit</i></button>
			</form>
			</td>
			
		</tr>
		
		
		
		
	</c:forEach>
	</tbody>
	</table>
	
</div>
	--%>	