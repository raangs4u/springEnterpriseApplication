package net.myapps.springEnterpriseApplication.webservice.soap;

import javax.jws.WebService;

/**
 * @author rmandada
 */
@WebService(endpointInterface = "net.myapps.springEnterpriseApplication.webservice.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}