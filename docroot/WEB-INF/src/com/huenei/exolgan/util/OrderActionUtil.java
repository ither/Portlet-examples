package com.huenei.exolgan.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang.StringUtils.split;
import com.huenei.exolgan.services.model.ProcessOrder;
import com.huenei.exolgan.services.model.ProcessOrderDetail;
import com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl;
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
        List<ProcessOrderDetail> details = new ArrayList<ProcessOrderDetail>();        
        ProcessOrderDetail detail;
        
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
        
        
        
        String[] cashIdxs = split(ParamUtil.getString(request, "cashFieldsIndexes"), ',');
        String[] chckIdxs = split(ParamUtil.getString(request, "checkFieldsIndexes"), ',');
        
        long cashValue = ParamUtil.getLong(request, "cashValue");
        if (cashValue != 0)
        {
            detail = new ProcessOrderDetailImpl();
            detail.setProcessDetailAmount(cashValue);
            details.add(detail);
        }
        
        for (String i : cashIdxs)
        {
            detail = new ProcessOrderDetailImpl();
            detail.setProcessDetailAmount(ParamUtil.getLong(request, "cashValue" + i));
            details.add(detail);
        }
        
        cashValue = ParamUtil.getLong(request, "checkValue");
        if (cashValue != 0)
        {            
            detail = new ProcessOrderDetailImpl();
            detail.setProcessDetailAmount(ParamUtil.getLong(request, "checkValue"));
            detail.setBankCheck(ParamUtil.getString(request,"checkBankName"));
            detail.setBankCheckId(ParamUtil.getString(request, "checkNumber"));
            details.add(detail);
        }
        
        for (String i : chckIdxs)
        {
            detail = new ProcessOrderDetailImpl();
            detail.setProcessDetailAmount(ParamUtil.getLong(request, "checkValue" + i));
            detail.setBankCheck(ParamUtil.getString(request,"checkBankName" + i));
            detail.setBankCheckId(ParamUtil.getString(request, "checkNumber" + i));
            details.add(detail);            
        }
        
        result.setProcessOrderDetails(details);
        
        return result;
    }
    
    static public boolean validateProcessOrder(ProcessOrder po, List<String> list)
    {
        boolean valid = true;
        
        if (isBlank(po.getCompanyName()))
        {
            list.add("company-name-empty");
            valid = false;
        }
        if (isBlank(po.getCompanyContact()))
        {
            list.add("company-contact-empty");
            valid = false;
        }
        if (isBlank(po.getProcessOrderDescription()))
        {
            list.add("po-descrip-empty");
            valid = false;            
        }
        
        if (po.getProcessOrderDetails().size() == 0)
        {
            list.add("details-empty");
            valid = false;            
        }
        
        return valid;
    }
}
