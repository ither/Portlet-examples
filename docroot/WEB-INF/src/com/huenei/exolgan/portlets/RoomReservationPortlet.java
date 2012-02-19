package com.huenei.exolgan.portlets;

import com.huenei.exolgan.services.model.Reservation;
import com.huenei.exolgan.services.model.impl.ReservationImpl;
import com.huenei.exolgan.util.RoomActionUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
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

import org.apache.commons.lang.StringUtils;

public class RoomReservationPortlet extends GenericPortlet
{
    private static Log _log = LogFactoryUtil.getLog(RoomReservationPortlet.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat();
    protected String viewJSP;
    private InternetAddress from, to;
//    private String bodyTemplate;
    private String[] rooms;

    public void init() throws PortletException
    {        
        viewJSP = getInitParameter("view-jsp");
        rooms = PortletProps.getArray("meeting.room.names");
        String mailAddress = PortletProps.get("mail.address");
        String mailName = PortletProps.get("mail.name");
        String adminEmailAddress = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        String adminEmailName = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_NAME);
        
        try
        {
//            bodyTemplate = StringUtil.read(getClass().getClassLoader(), "content/mailTemplate.vm", false);
            from = new InternetAddress(adminEmailAddress, adminEmailName);
            to = new InternetAddress(mailName, mailAddress);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new PortletException("Error al definir las cuentas de correo", e);
        }
//        catch (IOException e)
//        {
//            throw new PortletException("Error al cargar la plantilla de mail", e);
//        }
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        Reservation reservation = new ReservationImpl();        
        renderRequest.setAttribute("reservation", reservation);
        renderRequest.setAttribute("rooms", rooms);
        include(viewJSP, renderRequest, renderResponse);
    }

    @ProcessAction(name="processReservation")
    public void processReserva(ActionRequest request, ActionResponse response)
    {
        List<String> errors = new ArrayList<String>();
        
        Reservation reservation = RoomActionUtil.reservationFromRequest(request);
        if (!RoomActionUtil.validateReservation(reservation, errors))
        {
            for (String err : errors)            
                SessionErrors.add(request, err);
            PortalUtil.copyRequestParameters(request, response);
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
                
                mail.setSubject("[admin] Pedido de reserva de sala");
                mail.setBody(bodyMessage(reservation, user));
                MailServiceUtil.sendEmail(mail);
                
                
                SessionMessages.add(request, "reservation-ok");
                
            }
            catch (UnsupportedEncodingException e)
            {
                SessionErrors.add(request, "reservation-error");
            }            
        }
    }

    private String bodyMessage(Reservation reservation, User user)
    {
        // TODO sustituir este codigo por un template de Velocity
        StringBuilder body = new StringBuilder('\n');
        body.append(user.getFullName()).append(" ha solicitado una reserva de sala\n");
        body.append("\nDatos de la reserva:\n-------------------\n");
        body.append("\nSala deseada: ").append(reservation.getMeetingRoom());
        body.append("\nHorario: ").append(sdf.format(reservation.getReservationTimestamp()));
        body.append(MessageFormat.format("\nDuracion: {0,number}:{1,number,00}", 
                new Object[]{reservation.getReservationDurationHour(), 
                             reservation.getReservationDurationMinute()}));
        if (StringUtils.isNotBlank(reservation.getCompanyName()))
        {
            body.append("\n\nDatos de los visitantes:\n------------------------");
            body.append("\nEmpresa: ").append(reservation.getCompanyName());
            body.append("\nVisitantes:");
            String[] visitNames = StringUtils.split(reservation.getVisitNames(), '\n');
            String[] visitDocs  = StringUtils.split(reservation.getVisitDocs(), '\n');
            for (int i=0; i < visitNames.length; i++)                    
                body.append("\n  ").append(visitNames[i])
                    .append("\t\t\t").append(visitDocs[i]);                    
        }
        
        _log.info(body.toString());
        return body.toString();
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
