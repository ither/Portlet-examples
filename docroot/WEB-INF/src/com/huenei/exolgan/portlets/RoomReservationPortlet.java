package com.huenei.exolgan.portlets;

import com.huenei.exolgan.services.model.Reservation;
import com.huenei.exolgan.services.model.impl.ReservationImpl;
import com.huenei.exolgan.util.ActionUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.velocity.VelocityContext;
import com.liferay.portal.kernel.velocity.VelocityEngineUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;
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
    private static Log _log = LogFactoryUtil.getLog(RoomReservationPortlet.class);
    
    protected String viewJSP;
    private InternetAddress from, to;
    private String bodyTemplate;

    public void init() throws PortletException
    {
        viewJSP = getInitParameter("view-jsp");
        
        String mailAddress = PortletProps.get("mail.address");
        String mailName = PortletProps.get("mail.name");
        String adminEmailAddress = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        String adminEmailName = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_NAME);
        
        try
        {
            bodyTemplate = StringUtil.read(getClass().getClassLoader(), "content/mailTemplate.vm", false);
            from = new InternetAddress(adminEmailAddress, adminEmailName);
            to = new InternetAddress(mailName, mailAddress);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new PortletException("Error al definir las cuentas de correo", e);
        }
        catch (IOException e)
        {
            throw new PortletException("Error al cargar la plantilla de mail", e);
        }
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        Reservation reservation = new ReservationImpl();
        renderRequest.setAttribute("reservation", reservation);
        renderRequest.setAttribute("rooms", new String[]{"R1", "R2", "R3"});
        include(viewJSP, renderRequest, renderResponse);
    }

    @ProcessAction(name="processReservation")
    public void processReserva(ActionRequest request, ActionResponse response)
    {
        List<String> errors = new ArrayList<String>();
        
        Reservation reservation = ActionUtil.reservationFromRequest(request);
        if (!ActionUtil.validateReservation(reservation, errors))
        {
            for (String err : errors)            
                SessionErrors.add(request, err);
        }
        else
        {            
            // envia el mail            
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            User user = themeDisplay.getUser();
            MailMessage mail = new MailMessage();
                       
            try
            {
                InternetAddress replyTo = new InternetAddress(user.getEmailAddress(), user.getFullName());
                
                mail.setFrom(from);
                mail.setTo(to);
                mail.setReplyTo(new InternetAddress[] {replyTo});

                
                MailServiceUtil.sendEmail(mail);        
                SessionMessages.add(request, "reservation-ok");                   
            }
            catch (UnsupportedEncodingException e)
            {
                SessionErrors.add(request, "reservation-error");
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            
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
