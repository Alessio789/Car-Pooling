<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- CONTROLLER ERROR PAGE --%>
<h1 class="ui-widget-header"><am-web:message key="error.title" /></h1>
<br/>
<div class="ui-corner-all ui-widget-content ui-state-error">
    <p class="ui-state-error-text" style="padding:50px">
    <am-web:message key="${err_code}" />
    </p>
</div>
<!-- 
  ------------------------------------------------------------------------------------
  ERRORE: <c:if test="${!empty err_code}"><c:out value="${err_code}" escapeXml="false" /></c:if>
  ------------------------------------------------------------------------------------
  <c:if test="${!empty err_obj.message}">
  <c:out value="${err_obj}" />
  <c:forEach var="error" items="${err_obj.stackTrace}">at <c:out value="${error.className}" />.<c:out value="${error.methodName}" />(<c:out value="${error.fileName}" />:<c:out value="${error.lineNumber}" />)
  </c:forEach>
  </c:if>
  ------------------------------------------------------------------------------------
--> 