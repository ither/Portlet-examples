<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@ page import="com.huenei.exolgan.services.model.Reservation"%>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:defineObjects />
<theme:defineObjects/>

<jsp:useBean 
    id="reservation"
    type="com.huenei.exolgan.services.model.Reservation"
    scope="request"/>
    
<jsp:useBean 
    id="rooms" 
    type="java.lang.String[]"
    scope="request"/>    


<% if (!themeDisplay.isSignedIn()) {%>
<div class="portlet-msg-info"><liferay-ui:message key="not-logged-in"/></div>
<% } else { 
    Calendar now = CalendarFactoryUtil.getCalendar();
    long reservationDurationHour = BeanParamUtil.getLong(reservation, request, "reservationDurationHour");
    long reservationDurationMinute = BeanParamUtil.getLong(reservation, request, "reservationDurationMinute");
    if (reservationDurationHour == 0 && reservationDurationMinute == 0)
        reservationDurationHour = 1;
    String room = BeanParamUtil.getString(reservation, request, "meetingRoom");
%>

<liferay-ui:success key="reservation-ok" message="reservation-ok"/>
<portlet:renderURL var="redirectURL"/>
<portlet:actionURL name="processReservation" var="postURL">
    <portlet:param name="redirect" value="redirectURL"/>
</portlet:actionURL>

<liferay-ui:success key="reservationOk"    message="reservation-ok"/>
<liferay-ui:error   key="reservationError" message="reservation-error"/>

<aui:form action="<%= postURL %>" method="post">
    
    <liferay-ui:error key="meeting-room-empty" message="meeting-room-empty"/>
    <aui:select name="meetingRoom">
        <aui:option value=""><liferay-ui:message key="please-choose"/></aui:option>
        <% for(String opt: rooms) {%>
        <aui:option value="<%= opt %>" selected="<%= opt.equals(room) %>"><%= opt %></aui:option>
        <%} %>
    </aui:select>
    
    <aui:fieldset>
    <aui:input name="reservationTimestamp"
               model="<%= Reservation.class %>"
               bean="<%= reservation %>"
               value="<%= now %>" />
               
    <aui:field-wrapper label="duration">
        <aui:select cssClass="reservation-duration-hour" label="hours" name="reservationDurationHour">
            <% for (int i = 0; i <= 8 ; i++) { %>
                <aui:option label="<%= i %>" selected="<%= reservationDurationHour == i %>" />
            <% } %>
        </aui:select>
        <aui:select label="minutes" name="reservationDurationMinute">
            <% for (int i=0; i < 60 ; i = i + 15) { %>
                <aui:option label='<%= ":" + (i < 10 ? "0" : StringPool.BLANK) + i %>' selected="<%= reservationDurationMinute == i %>" value="<%= i %>" />
            <% }%>
        </aui:select>
    </aui:field-wrapper>
    </aui:fieldset>
               
    <liferay-ui:error key="incomplete-data" message="incomplete-data"/>
    <aui:input name="companyName"
               type="text" size="50"/>
               
    <liferay-ui:error key="names-mismatch" message="names-mismatch"/>
               
    <aui:input name="visitNames" 
               type="textarea"/>

    <aui:input name="visitDocs"
               type="textarea"/>                                             
       
    <aui:button-row>
        <aui:button type="submit" name="submit"/>
    </aui:button-row>
</aui:form>

<% } %>