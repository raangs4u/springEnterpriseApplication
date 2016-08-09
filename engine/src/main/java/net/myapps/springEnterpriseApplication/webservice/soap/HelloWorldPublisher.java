package net.myapps.springEnterpriseApplication.webservice.soap;

import javax.xml.ws.Endpoint;

/**
 * @author rmandada
 */
public class HelloWorldPublisher{
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7779/ws/hello", new HelloWorldImpl());
    }
}
