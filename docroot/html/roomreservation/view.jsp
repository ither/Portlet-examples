<%@ page import="com.huenei.exolgan.services.model.Reservation"%>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:defineObjects />
<theme:defineObjects/>

<% if (!themeDisplay.isSignedIn()) {%>

<% } else { %>
<liferay-ui:error key="meeting-room-empty" message="meeting-room-empty"/>
<liferay-ui:error key="incomplete-data" message="incomplete-data"/>
<liferay-ui:error key="names-mismatch" message="names-mismatch"/>


<portlet:actionURL name="processReservation" var="postURL"/>

<jsp:useBean 
    id="reservation"
    type="com.huenei.exolgan.services.model.Reservation"
    scope="request"/>

<% Calendar now = CalendarFactoryUtil.getCalendar(); %>

<liferay-ui:success key="reservationOk"    message="reservation-ok"/>
<liferay-ui:error   key="reservationError" message="reservation-error"/>

<aui:form action="<%= postURL %>" method="post">
    
    <aui:input name="reservationTimestamp"
               model="<%= Reservation.class %>"
               bean="<%= reservation %>"
               value="<%= now %>"
               />
               
    <aui:input name="reservationDuration"
               type="text" value="30"/>
               
    <aui:input name="companyName"
               type="text" size="50"/>
               
    <aui:input name="visitNames"
               type="textarea"/>

    <aui:input name="visitDocs"
               type="textarea"/>                                             
    
    <aui:button-row>
        <aui:button type="submit" name="submit"/>
    </aui:button-row>
</aui:form>

<% } %>