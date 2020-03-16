<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="/app/ToDoList/modify" method="post">
		<input type="hidden" value="${task.id }" name ="taskid" />
		<input type="text" name="title" value="${task.title}"/>
		<input type="hidden" value="${toDoList.id }" name ="toDoListID" />
	<textarea rows="2" cols="20" name="description" >${task.description}</textarea>
	<select name="priority">
	<option value="1" <c:if test="${task.priority eq 1 }">selected="selected"</c:if>><am-web:message key="option.high"></am-web:message></option>
	<option value="2" <c:if test="${task.priority eq 2 }">selected="selected"</c:if>><am-web:message key="option.medium"></am-web:message></option>
	<option value="3" <c:if test="${task.priority eq 3 }">selected="selected"</c:if>><am-web:message key="option.low"></am-web:message></option>
	</select>
	<input type="checkbox" name="done" value="true" <c:if test="${task.done eq true }">checked="checked"</c:if>/><am-web:message key="input.done?"></am-web:message>
		<button id='${task.id}' type="submit" name="button" value="Modifica" ><am-web:message key="button.modifyAccept"></am-web:message></button>
		</form>
