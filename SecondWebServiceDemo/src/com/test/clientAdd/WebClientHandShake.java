/**
 * 
 */
package com.test.clientAdd;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 * @author karthick
 *
 */
public class WebClientHandShake {

	@Resource  
    WebServiceContext wsc; 
	
	@WebMethod  
    public String webMethod() {  
        MessageContext mc = wsc.getMessageContext();  
        HttpServletRequest req = (HttpServletRequest)  
            mc.get(MessageContext.SERVLET_REQUEST);  
        System.out.println("Before Remoter Host:"+req.getLocalName());
        System.out.println("Before Remote Host:"+req.getRemoteUser());
        return "Client: " +  
               req.getRemoteHost() + " (" +  
               req.getRemoteAddr() + ").";  
    }  
	
	public void callMethod()
	{
		System.out.println("Ip Address is:"+webMethod());
	}

}
