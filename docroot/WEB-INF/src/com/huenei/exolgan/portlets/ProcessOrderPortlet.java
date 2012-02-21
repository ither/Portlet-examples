package com.huenei.exolgan.portlets;

import com.huenei.exolgan.services.model.ProcessOrder;
import com.huenei.exolgan.services.model.impl.ProcessOrderImpl;
import com.huenei.exolgan.util.OrderActionUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;

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
        String redir = renderRequest.getParameter("jspPage");
        if (StringUtils.isBlank(redir))
        {
            ProcessOrder po = new ProcessOrderImpl();
            renderRequest.setAttribute("processOrder", po);
    
            include(viewJSP, renderRequest, renderResponse);
        }
        else
        {
            include(redir, renderRequest, renderResponse);
        }
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
        }
        else
        {
            // redirecciona al PDF
            String red = ParamUtil.getString(request, "redirect");
            SessionMessages.add(request, "order-ok");
        }
        PortalUtil.copyRequestParameters(request, response);
    }    
    
    @Override
    public void serveResource(ResourceRequest resRequest, ResourceResponse resResponse) throws PortletException, IOException 
    {
        Document document = new Document();        
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            document.open();
            document.add(new Paragraph("Probando que es gerundio"));
            document.add(Chunk.NEWLINE);            
            document.add(new Paragraph("It is a sunny day today."));
            
            resResponse.setContentType("application/pdf");
            resResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
            
            // the contentlength is needed for MSIE!!!
            resResponse.setContentLength(baos.size());
            
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream out = resResponse.getPortletOutputStream();
            baos.writeTo(out);
            
            out.flush();
            out.close();            
        }
        catch (DocumentException e)
        {
            throw new IOException("Problemas generando el PDF", e);
        }
        
        document.close();        
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
