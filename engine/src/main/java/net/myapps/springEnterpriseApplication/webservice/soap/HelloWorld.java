package net.myapps.springEnterpriseApplication.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author rmandada
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWorld{
    @WebMethod
    String getHelloWorldAsString(String name);
}
