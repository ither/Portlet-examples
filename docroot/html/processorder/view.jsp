<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<portlet:defineObjects />
<theme:defineObjects/>

<jsp:useBean
    id="processOrder"
    type="com.huenei.exolgan.services.model.ProcessOrder"
    scope="request"/>

<% if (!themeDisplay.isSignedIn()) {%>
<div class="portlet-msg-info"><liferay-ui:message key="requires-login"/></div>
<% } else { %> 

<portlet:renderURL var="redirectURL"/>
<portlet:actionURL name="processOrder" var="postURL">
    <portlet:param name="redirect" value="redirectURL"/>
</portlet:actionURL>

<liferay-ui:success key="orderOk"    message="order-ok"/>
<liferay-ui:error   key="orderError" message="order-error"/>


<aui:form action="<%= postURL %>" method="post">
    <aui:fieldset label="Datos de la empresa destino">              <!-- hay que meter estos campos en i18n  -->
        <aui:input name="companyName"    type="text" size="50"/>
        <aui:input name="companyAddress" type="text" size="50"/>
        <aui:input name="companyContact" type="text" size="50"/> 
    </aui:fieldset>
        
	<aui:fieldset id="cash-fields" label="Importes en efectivo">
	    <div class="lfr-form-row lfr-form-row-inline">
	        <div class="row-fields">
	            <aui:input name="cashValue"
	                fieldParam='cashField0'
	                label="Valor en efectivo" value="0" onFocus="this.select()"
	                inlineLabel="left" size="40" />
	        </div>
	    </div>
	</aui:fieldset>

    <aui:fieldset id="check-fields" label="Importes con cheque">
        <div class="lfr-form-row lfr-form-row-inline">
            <div class="row-fields">
                <aui:input name="checkValue"
                    fieldParam='checkField0'
                    label="Monto del cheque" value="0" onFocus="this.select()"
                    inlineLabel="left" size="40" />
                <aui:input name="checkBankName"
                    fieldParam='checkField1'
                    label="Banco del cheque" value="0" onFocus="this.select()"
                    inlineLabel="left" size="40" />
                <aui:input name="checkNumber"
                    fieldParam='checkField2'
                    label="Nro del cheque" value="0" onFocus="this.select()"
                    inlineLabel="left" size="40" />                    
            </div>
        </div>
    </aui:fieldset>	
	
    <aui:button-row>
        <aui:button type="submit" name="submit"/>
    </aui:button-row>    
</aui:form>

<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
        {
            contentBox: '#cash-fields',
            fieldIndexes: '<portlet:namespace />cashFieldsIndexes'
        }
    ).render();
    new Liferay.AutoFields(
        {
            contentBox: '#check-fields',
            fieldIndexes: '<portlet:namespace />checkFieldsIndexes'
        }    
    ).render();
</aui:script>

<% } %>    
