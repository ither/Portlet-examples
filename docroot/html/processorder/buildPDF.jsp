
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:resourceURL var="getpdfURL" />

<liferay-ui:success key="order-ok" message="order-ok"/>
<a href="<%= getpdfURL %>">Haga clic aqui para obtener el PDF</a>