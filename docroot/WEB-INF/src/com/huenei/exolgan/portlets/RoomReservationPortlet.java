package com.huenei.exolgan.portlets;

import com.huenei.exolgan.services.model.Reservation;
import com.huenei.exolgan.services.model.impl.ReservationImpl;
import com.huenei.exolgan.util.ActionUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

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

public class RoomReservationPortlet extends GenericPortlet
{
    protected String viewJSP;
    private static Log _log = LogFactoryUtil.getLog(RoomReservationPortlet.class);

    public void init()
    {
        viewJSP = getInitParameter("view-jsp");
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        Reservation reservation = new ReservationImpl();
        renderRequest.setAttribute("reservation", reservation);
        include(viewJSP, renderRequest, renderResponse);
    }

    @ProcessAction(name="processReservation")
    public void processReserva(ActionRequest request, ActionResponse response)
    {
        List<String> errors = new ArrayList<String>();
        
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY); 
        Reservation reservation = ActionUtil.reservationFromRequest(request);
        if (!ActionUtil.validateReservation(reservation, errors))
        {
            for (String err : errors)            
                SessionErrors.add(request, err);
            return;
        }
        
            
            
        
    }
    
    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null)        
            _log.error(path + " is not a valid include");        
        else        
            portletRequestDispatcher.include(renderRequest, renderResponse);        
    }
}
