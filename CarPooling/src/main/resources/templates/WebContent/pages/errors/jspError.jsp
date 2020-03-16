<%@page isErrorPage="true" %>
<%@taglib uri="www.marconivr.it/Error" prefix="am-web" %>
<%@page import="java.util.*"%>
<%-- JSP ERROR PAGE --%>
<h1><am-web:message key="error.jsp" /></h1>
<am-web:message key="error.message" />
<!--
Errore: <%=exception.getMessage()%>
-->	
