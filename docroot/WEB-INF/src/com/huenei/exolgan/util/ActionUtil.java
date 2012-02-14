package com.huenei.exolgan.util;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.huenei.exolgan.services.model.Reservation;
import com.huenei.exolgan.services.model.impl.ReservationImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ActionUtil
{
    static public Reservation reservationFromRequest(ActionRequest request)
    {
        Date now = new Date();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Reservation result = new ReservationImpl();
        
        result.setCompanyId(themeDisplay.getCompanyId());
        result.setUserId(themeDisplay.getUserId());
        result.setUserName(themeDisplay.getUser().getFullName());
        result.setCreateDate(now);
        result.setModifiedDate(now);
        
        result.setCompanyName(ParamUtil.getString(request, "companyName"));
        result.setMeetingRoom(ParamUtil.getString(request, "meetingRoom"));
        result.setVisitNames(ParamUtil.getString(request, "visitNames"));
        result.setVisitDocs(ParamUtil.getString(request, "visitDocs"));
        result.setReservationDuration(ParamUtil.getInteger(request, "reservationDuration"));
        
        int year = ParamUtil.getInteger(request,"reservationTimestampYear");
        int month = ParamUtil.getInteger(request, "reservationTimestampMonth");
        int day = ParamUtil.getInteger(request, "reservationTimestampDay");
        int hour = ParamUtil.getInteger(request, "reservationTimestampHour");
        int min = ParamUtil.getInteger(request, "reservationTimestampMinute");
        
        Date reservationTimestamp;
        try
        {
            reservationTimestamp = PortalUtil.getDate(month, day, year, hour, min, new PortalException());
        }
        catch (PortalException e)
        {
            reservationTimestamp = now;
        }
        result.setReservationTimestamp(reservationTimestamp);
                
        return result;
    }
    
    static public void validateReservation(Reservation reservation, List<String> list)
    {

    }
}
