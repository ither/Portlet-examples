package com.huenei.exolgan.portlets;

import com.huenei.exolgan.services.model.ProcessOrder;
import com.huenei.exolgan.services.model.impl.ProcessOrderImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

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
        _log.info(ParamUtil.getIntegerValues(request, "memberName"));
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
