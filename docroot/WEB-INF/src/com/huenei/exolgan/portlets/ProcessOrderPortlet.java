package com.huenei.exolgan.portlets;

import com.huenei.exolgan.services.model.ProcessOrder;
import com.huenei.exolgan.services.model.impl.ProcessOrderImpl;
import com.huenei.exolgan.util.OrderActionUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class ProcessOrderPortlet
 */
public class ProcessOrderPortlet extends GenericPortlet
{
    private static Log _log = LogFactoryUtil.getLog(ProcessOrderPortlet.class);
    protected String viewJSP;

    public void init()
    {
        viewJSP = getInitParameter("view-jsp");
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ProcessOrder po = new ProcessOrderImpl();
        renderRequest.setAttribute("processOrder", po);

        include(viewJSP, renderRequest, renderResponse);
    }

    @ProcessAction(name="processOrder")
    public void processTramite(ActionRequest request, ActionResponse response)
    {
        List<String> errors = new ArrayList<String>();
        ProcessOrder processOrder = OrderActionUtil.processOrderFromRequest(request);
        if (!OrderActionUtil.validateProcessOrder(processOrder, errors))
        {
            for (String err : errors)            
                SessionErrors.add(request, err);
            PortalUtil.copyRequestParameters(request, response);
        }
        else
        {
            // genera el PDF
            SessionMessages.add(request, "order-ok");
        }
    }
    
    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null)
        {
            _log.error(path + " is not a valid include");
        }
        else
        {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
}
