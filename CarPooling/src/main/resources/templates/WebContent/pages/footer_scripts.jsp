<%@taglib uri="http://www.marconivr.it/am-web" prefix="am-web"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty javascripts}">
<script type="text/javascript">
    <c:forEach items="${javascripts}" var="script">
     ${script.value}
    </c:forEach>
</script>
</c:if>
<c:if test="${not empty javascript_file}"><script src="${javascript_file}"></script></c:if>
