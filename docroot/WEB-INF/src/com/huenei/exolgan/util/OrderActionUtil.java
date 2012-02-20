package com.huenei.exolgan.util;

import java.util.Date;

import javax.portlet.ActionRequest;

import com.huenei.exolgan.services.model.ProcessOrder;
import com.huenei.exolgan.services.model.impl.ProcessOrderImpl;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class OrderActionUtil
{
    static public ProcessOrder processOrderFromRequest(ActionRequest request)
    {
        Date now = new Date();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        ProcessOrder result = new ProcessOrderImpl();
                
        result.setCompanyId(themeDisplay.getCompanyId());
        result.setUserId(themeDisplay.getUserId());
        result.setUserName(themeDisplay.getUser().getFullName());
        result.setCreateDate(now);
        result.setModifiedDate(now);

        result.setCompanyName(ParamUtil.getString(request, "companyName"));
        result.setCompanyAddress(ParamUtil.getString(request, "companyAddress"));
        result.setCompanyContact(ParamUtil.getString(request, "companyContact"));
        result.setProcessOrderDescription(ParamUtil.getString(request, "poDescrip"));
        result.setProcessOrderFailedBy(ParamUtil.getString(request, "poFailBy"));
        
        
        return result;
    }    
}
